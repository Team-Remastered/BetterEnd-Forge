package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.registry.world.TempEndFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.PottableFeatureSapling;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.world.EndFeatures;

public class HelixTreeSaplingBlock extends PottableFeatureSapling {
	public HelixTreeSaplingBlock() {
		super((state)-> TempEndFeatures.HELIX_TREE.get());
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).is(EndBlocks.AMBER_MOSS.get());
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		return block == EndBlocks.AMBER_MOSS.get();
	}
}
