package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.registry.world.TempEndFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.PottableFeatureSapling;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.world.EndFeatures;

public class TenaneaSaplingBlock extends PottableFeatureSapling {
	public TenaneaSaplingBlock() {
		super((state)-> TempEndFeatures.TENANEA.get());
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).is(EndBlocks.PINK_MOSS.get());
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		return block == EndBlocks.PINK_MOSS.get();
	}
}
