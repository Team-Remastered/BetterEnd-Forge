package com.teamremastered.betterendforge.world.features.bushes;

import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class LargeAmaranitaFeature extends DefaultFeature {
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featureConfig) {
		final Random random = featureConfig.random();
		final BlockPos pos = featureConfig.origin();
		final WorldGenLevel world = featureConfig.level();
		if (!world.getBlockState(pos.below()).is(CommonBlockTags.END_STONES)) return false;
		
		MutableBlockPos mut = new MutableBlockPos().set(pos);
		int height = MHelper.randRange(2, 3, random);
		for (int i = 1; i < height; i++) {
			mut.setY(mut.getY() + 1);
			if (!world.isEmptyBlock(mut)) {
				return false;
			}
		}
		mut.set(pos);
		
		BlockState state = EndBlocks.LARGE_AMARANITA_MUSHROOM.get().defaultBlockState();
		BlocksHelper.setWithUpdate(world, mut, state.setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.BOTTOM));
		if (height > 2) {
			BlocksHelper.setWithUpdate(
				world,
				mut.move(Direction.UP),
				state.setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.MIDDLE)
			);
		}
		BlocksHelper.setWithUpdate(
			world,
			mut.move(Direction.UP),
			state.setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.TOP)
		);
		
		return true;
	}
}
