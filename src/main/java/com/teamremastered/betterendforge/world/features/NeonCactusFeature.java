package com.teamremastered.betterendforge.world.features;

import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import com.teamremastered.betterendforge.blocks.NeonCactusPlantBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class NeonCactusFeature extends DefaultFeature {
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featureConfig) {
		final Random random = featureConfig.random();
		final BlockPos pos = featureConfig.origin();
		final WorldGenLevel world = featureConfig.level();
		BlockState ground = world.getBlockState(pos.below());
		if (!ground.is(EndBlocks.ENDSTONE_DUST.get()) && !ground.is(EndBlocks.END_MOSS.get())) {
			return false;
		}
		
		NeonCactusPlantBlock cactus = ((NeonCactusPlantBlock) EndBlocks.NEON_CACTUS.get());
		cactus.growPlant(world, pos, random);
		
		return true;
	}
}
