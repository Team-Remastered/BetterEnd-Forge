package com.teamremastered.betterendforge.world.features;

import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import com.teamremastered.betterendforge.blocks.EndBlockProperties;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class CavePumpkinFeature extends DefaultFeature {
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featureConfig) {
		final Random random = featureConfig.random();
		final BlockPos pos = featureConfig.origin();
		final WorldGenLevel world = featureConfig.level();
		if (!world.getBlockState(pos.above()).is(CommonBlockTags.GEN_END_STONES) || !world.isEmptyBlock(pos) || !world.isEmptyBlock(
			pos.below())) {
			return false;
		}
		
		int age = random.nextInt(4);
		BlocksHelper.setWithoutUpdate(
			world,
			pos,
			EndBlocks.CAVE_PUMPKIN_SEED.get().defaultBlockState().setValue(EndBlockProperties.AGE, age)
		);
		if (age > 1) {
			BlocksHelper.setWithoutUpdate(
				world,
				pos.below(),
				EndBlocks.CAVE_PUMPKIN.get().defaultBlockState().setValue(EndBlockProperties.SMALL, age < 3)
			);
		}
		
		return true;
	}
}
