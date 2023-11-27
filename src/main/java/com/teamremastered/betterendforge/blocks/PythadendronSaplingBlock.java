package com.teamremastered.betterendforge.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.PottableFeatureSapling;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndFeatures;

public class PythadendronSaplingBlock extends PottableFeatureSapling {
	public PythadendronSaplingBlock() {
		super((state)->EndFeatures.PYTHADENDRON_TREE.getFeature());
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).is(EndBlocks.CHORUS_NYLIUM.get());
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		return block == EndBlocks.CHORUS_NYLIUM.get();
	}
}
