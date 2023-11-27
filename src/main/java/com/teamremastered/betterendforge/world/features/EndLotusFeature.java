package com.teamremastered.betterendforge.world.features;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import com.teamremastered.betterendforge.blocks.EndLotusSeedBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class EndLotusFeature extends UnderwaterPlantScatter {
	public EndLotusFeature(int radius) {
		super(radius);
	}
	
	@Override
	public void generate(WorldGenLevel world, Random random, BlockPos blockPos) {
		EndLotusSeedBlock seed = (EndLotusSeedBlock) EndBlocks.END_LOTUS_SEED.get();
		seed.grow(world, random, blockPos);
	}
	
	@Override
	protected int getChance() {
		return 15;
	}
}
