package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import com.teamremastered.betterendforge.blocks.basis.EndPlantBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Collections;
import java.util.List;

public class LanceleafBlock extends EndPlantBlock {
	
	public static final EnumProperty<BlockProperties.PentaShape> SHAPE = BlockProperties.PENTA_SHAPE;
	public static final IntegerProperty ROTATION = BlockProperties.ROTATION;
	
	public LanceleafBlock() {
		super();
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(SHAPE, ROTATION);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockProperties.PentaShape shape = state.getValue(SHAPE);
		if (shape == BlockProperties.PentaShape.TOP) {
			return world.getBlockState(pos.below()).is(this);
		}
		else if (shape == BlockProperties.PentaShape.BOTTOM) {
			return world.getBlockState(pos.below()).is(EndBlocks.AMBER_MOSS.get()) && world.getBlockState(pos.above())
																					 .is(this);
		}
		else {
			return world.getBlockState(pos.below()).is(this) && world.getBlockState(pos.above()).is(this);
		}
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		if (!canSurvive(state, world, pos)) {
			return Blocks.AIR.defaultBlockState();
		}
		else {
			return state;
		}
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		if (state.getValue(SHAPE) == BlockProperties.PentaShape.BOTTOM) {
			return Collections.singletonList(new ItemStack(EndBlocks.LANCELEAF_SEED.get()));
		}
		return MHelper.RANDOM.nextBoolean() ? Collections.emptyList() : Collections.singletonList(new ItemStack(
			EndBlocks.LANCELEAF_SEED.get()));
	}
}
