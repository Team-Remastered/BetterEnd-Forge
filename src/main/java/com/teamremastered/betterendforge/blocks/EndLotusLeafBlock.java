package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlockNotFull;
import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import com.teamremastered.betterendforge.registry.EndBlocks;

public class EndLotusLeafBlock extends BaseBlockNotFull implements RenderLayerProvider {
	public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<BlockProperties.TripleShape> SHAPE = BlockProperties.TRIPLE_SHAPE;
	private static final VoxelShape VSHAPE = Block.box(0, 0, 0, 16, 1, 16);
	
	public EndLotusLeafBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT).noOcclusion().sound(SoundType.WET_GRASS));
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockState down = world.getBlockState(pos.below());
		return !down.getFluidState().isEmpty() && down.getFluidState().getType() instanceof WaterFluid;
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(SHAPE, HORIZONTAL_FACING);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return VSHAPE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState rotate(BlockState state, Rotation rotation) {
		return BlocksHelper.rotateHorizontal(state, rotation, HORIZONTAL_FACING);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return BlocksHelper.mirrorHorizontal(state, mirror, HORIZONTAL_FACING);
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
		return new ItemStack(EndBlocks.END_LOTUS_SEED.get());
	}
}
