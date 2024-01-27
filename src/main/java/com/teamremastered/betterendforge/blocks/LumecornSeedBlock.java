package com.teamremastered.betterendforge.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import com.teamremastered.betterendforge.blocks.basis.EndPlantWithAgeBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.world.EndFeatures;

import java.util.Optional;
import java.util.Random;

public class LumecornSeedBlock extends EndPlantWithAgeBlock {

	@Override
	public void growAdult(WorldGenLevel world, Random random, BlockPos pos) {
		((Feature<NoneFeatureConfiguration>) (EndFeatures.LUMECORN.getFeature())).place(new FeaturePlaceContext<>(
				Optional.empty(),
				world,
				null,
				random,
				pos,
				(NoneFeatureConfiguration) null));
	}

	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.END_MOSS.get());
	}

	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.NONE;
	}
}
