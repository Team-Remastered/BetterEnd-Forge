package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.registry.world.TempEndFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.PottableFeatureSapling;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.world.EndFeatures;

public class MossyGlowshroomSaplingBlock extends PottableFeatureSapling {
	public MossyGlowshroomSaplingBlock() {
		super(7, (state)-> TempEndFeatures.MOSSY_GLOWSHROOM.get());
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).is(EndBlocks.END_MOSS.get()) || world.getBlockState(pos.below())
																			   .is(EndBlocks.END_MYCELIUM.get());
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		return block == EndBlocks.END_MOSS.get() || block == EndBlocks.END_MYCELIUM.get();
	}
}
