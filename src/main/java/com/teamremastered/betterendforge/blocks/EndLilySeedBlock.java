package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.blocks.UnderwaterPlantWithAgeBlock;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class EndLilySeedBlock extends UnderwaterPlantWithAgeBlock {
	@Override
	public void grow(WorldGenLevel world, Random random, BlockPos pos) {
		if (canGrow(world, pos)) {
			BlocksHelper.setWithoutUpdate(
				world,
				pos,
				EndBlocks.END_LILY.get().defaultBlockState().setValue(EndLilyBlock.SHAPE, BlockProperties.TripleShape.BOTTOM)
			);
			BlockPos up = pos.above();
			while (world.getFluidState(up).isSource()) {
				BlocksHelper.setWithoutUpdate(
					world,
					up,
					EndBlocks.END_LILY.get().defaultBlockState().setValue(EndLilyBlock.SHAPE, BlockProperties.TripleShape.MIDDLE)
				);
				up = up.above();
			}
			BlocksHelper.setWithoutUpdate(
				world,
				up,
				EndBlocks.END_LILY.get().defaultBlockState().setValue(EndLilyBlock.SHAPE, BlockProperties.TripleShape.TOP)
			);
		}
	}
	
	private boolean canGrow(WorldGenLevel world, BlockPos pos) {
		BlockPos up = pos.above();
		while (world.getBlockState(up).getFluidState().getType().equals(Fluids.WATER.getSource())) {
			up = up.above();
		}
		return world.isEmptyBlock(up);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
}
