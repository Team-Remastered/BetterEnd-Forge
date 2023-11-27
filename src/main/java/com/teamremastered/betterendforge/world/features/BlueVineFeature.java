package com.teamremastered.betterendforge.world.features;

import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import com.teamremastered.betterendforge.blocks.basis.EndPlantWithAgeBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class BlueVineFeature extends ScatterFeature {
	private boolean small;
	
	public BlueVineFeature() {
		super(5);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean canGenerate(WorldGenLevel world, Random random, BlockPos center, BlockPos blockPos, float radius) {
		float d = MHelper.length(
			center.getX() - blockPos.getX(),
			center.getZ() - blockPos.getZ()
		) / radius * 0.6F + random.nextFloat() * 0.4F;
		small = d > 0.5F;
		return EndBlocks.BLUE_VINE_SEED.get().canSurvive(AIR, world, blockPos);
	}
	
	@Override
	public void generate(WorldGenLevel world, Random random, BlockPos blockPos) {
		if (small) {
			BlocksHelper.setWithoutUpdate(
				world,
				blockPos,
				EndBlocks.BLUE_VINE_SEED.get().defaultBlockState().setValue(EndPlantWithAgeBlock.AGE, random.nextInt(4))
			);
		}
		else {
			EndPlantWithAgeBlock seed = ((EndPlantWithAgeBlock) EndBlocks.BLUE_VINE_SEED.get());
			seed.growAdult(world, random, blockPos);
		}
	}
}
