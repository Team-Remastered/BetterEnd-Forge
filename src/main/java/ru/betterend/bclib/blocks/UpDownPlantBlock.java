package ru.betterend.bclib.blocks;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.interfaces.RenderLayerProvider;
import ru.betterend.bclib.interfaces.tools.AddMineableHoe;
import ru.betterend.bclib.interfaces.tools.AddMineableShears;
import ru.betterend.bclib.items.tool.BaseShearsItem;

import java.util.List;

public abstract class UpDownPlantBlock extends BaseBlockNotFull implements RenderLayerProvider, AddMineableShears, AddMineableHoe {
	private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
	
	public UpDownPlantBlock() {
		this(FabricBlockSettings
			.of(Material.PLANT)
			.sound(SoundType.GRASS)
			.noCollission()
		);
	}
	
	public UpDownPlantBlock(Properties properties) {
		super(properties);
	}
	
	protected abstract boolean isTerrain(BlockState state);
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockState down = world.getBlockState(pos.below());
		BlockState up = world.getBlockState(pos.above());
		return (isTerrain(down) || down.getBlock() == this) && (isSupport(up, world, pos) || up.getBlock() == this);
	}
	
	protected boolean isSupport(BlockState state, LevelReader world, BlockPos pos) {
		return canSupportCenter(world, pos.above(), Direction.UP);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		if (!canSurvive(state, world, pos)) {
			return Blocks.AIR.defaultBlockState();
		}
		else {
			return state;
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
	public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack) {
		super.playerDestroy(world, player, pos, state, blockEntity, stack);
		world.neighborChanged(pos, Blocks.AIR, pos.below());
	}
}
