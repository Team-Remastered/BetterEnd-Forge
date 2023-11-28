package com.teamremastered.betterendforge.world.features;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import com.teamremastered.betterendforge.blocks.basis.EndPlantWithAgeBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class LanceleafFeature extends ScatterFeature {
	public LanceleafFeature() {
		super(7);
	}
	
	@Override
	public boolean canGenerate(WorldGenLevel world, Random random, BlockPos center, BlockPos blockPos, float radius) {
		return EndBlocks.LANCELEAF_SEED.get().canSurvive(AIR, world, blockPos);
	}
	
	@Override
	public void generate(WorldGenLevel world, Random random, BlockPos blockPos) {
		EndPlantWithAgeBlock seed = ((EndPlantWithAgeBlock) EndBlocks.LANCELEAF_SEED.get());
		seed.growAdult(world, random, blockPos);
	}
	
	@Override
	protected int getChance() {
		return 5;
	}
}
