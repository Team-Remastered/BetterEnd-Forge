package com.teamremastered.betterendforge.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.PottableFeatureSapling;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndFeatures;

public class LacugroveSaplingBlock extends PottableFeatureSapling {
	public LacugroveSaplingBlock() {
		super((state)->EndFeatures.LACUGROVE.getFeature());
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).is(EndBlocks.END_MOSS.get()) || world.getBlockState(pos.below())
																			   .is(EndBlocks.ENDSTONE_DUST.get());
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		return block == EndBlocks.END_MOSS.get();
	}
}
