package ru.betterend.bclib.blocks;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.betterend.bclib.blocks.BlockProperties.TripleShape;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.interfaces.RenderLayerProvider;
import ru.betterend.bclib.items.tool.BaseShearsItem;
import ru.betterend.bclib.util.BlocksHelper;

import java.util.List;
import java.util.Random;

@SuppressWarnings("deprecation")
public class BaseVineBlock extends BaseBlockNotFull implements RenderLayerProvider, BonemealableBlock {
	public static final EnumProperty<TripleShape> SHAPE = BlockProperties.TRIPLE_SHAPE;
	private static final VoxelShape VOXEL_SHAPE = Block.box(2, 0, 2, 14, 16, 14);
	
	public BaseVineBlock() {
		this(0, false);
	}
	
	public BaseVineBlock(int light) {
		this(light, false);
	}
	
	public BaseVineBlock(int light, boolean bottomOnly) {
		this(
			BlockBehaviour.Properties
				.of(Material.PLANT)
				.sound(SoundType.GRASS)
				.lightLevel((state) -> bottomOnly ? state.getValue(SHAPE) == TripleShape.BOTTOM ? light : 0 : light)
				.noCollission()
		);
	}
	
	public BaseVineBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, TripleShape.BOTTOM));
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(SHAPE);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		Vec3 vec3d = state.getOffset(view, pos);
		return VOXEL_SHAPE.move(vec3d.x, vec3d.y, vec3d.z);
	}
	
	@Override
	public OffsetType getOffsetType() {
		return OffsetType.XZ;
	}
	
	public boolean canGenerate(BlockState state, LevelReader world, BlockPos pos) {
		return isSupport(state, world, pos);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return isSupport(state, world, pos);
	}
	
	protected boolean isSupport(BlockState state, LevelReader world, BlockPos pos) {
		BlockState up = world.getBlockState(pos.above());
		return up.is(this) || up.is(BlockTags.LEAVES) || canSupportCenter(world, pos.above(), Direction.DOWN);
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		if (!canSurvive(state, world, pos)) {
			return Blocks.AIR.defaultBlockState();
		}
		else {
			if (world.getBlockState(pos.below()).getBlock() != this) return state.setValue(SHAPE, TripleShape.BOTTOM);
			else if (world.getBlockState(pos.above()).getBlock() != this) return state.setValue(SHAPE, TripleShape.TOP);
			return state.setValue(SHAPE, TripleShape.MIDDLE);
		}
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		ItemStack tool = builder.getParameter(LootContextParams.TOOL);
		if (tool != null && BaseShearsItem.isShear(tool) || EnchantmentHelper.getItemEnchantmentLevel(
			Enchantments.SILK_TOUCH,
			tool
		) > 0) {
			return Lists.newArrayList(new ItemStack(this));
		}
		else {
			return Lists.newArrayList();
		}
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
		while (world.getBlockState(pos).getBlock() == this) {
			pos = pos.below();
		}
		return world.getBlockState(pos).isAir();
	}
	
	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		while (world.getBlockState(pos).getBlock() == this) {
			pos = pos.below();
		}
		return world.isEmptyBlock(pos);
	}
	
	@Override
	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
		while (world.getBlockState(pos).getBlock() == this) {
			pos = pos.below();
		}
		world.setBlockAndUpdate(pos, defaultBlockState());
		BlocksHelper.setWithoutUpdate(world, pos, defaultBlockState());
	}
}
