package com.teamremastered.betterendforge.world.features.terrain;

import com.mojang.math.Vector3f;
import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.sdf.SDF;
import com.teamremastered.betterendforge.bclib.sdf.operator.SDFRotation;
import com.teamremastered.betterendforge.bclib.sdf.primitive.SDFHexPrism;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class BigAuroraCrystalFeature extends DefaultFeature {
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featureConfig) {
		final Random random = featureConfig.random();
		BlockPos pos = featureConfig.origin();
		final WorldGenLevel world = featureConfig.level();
		int maxY = pos.getY() + BlocksHelper.upRay(world, pos, 16);
		int minY = pos.getY() - BlocksHelper.downRay(world, pos, 16);
		
		if (maxY - minY < 10) {
			return false;
		}
		
		int y = MHelper.randRange(minY, maxY, random);
		pos = new BlockPos(pos.getX(), y, pos.getZ());
		
		int height = MHelper.randRange(5, 25, random);
		SDF prism = new SDFHexPrism().setHeight(height)
									 .setRadius(MHelper.randRange(1.7F, 3F, random))
									 .setBlock(EndBlocks.AURORA_CRYSTAL.get());
		Vector3f vec = MHelper.randomHorizontal(random);
		prism = new SDFRotation().setRotation(vec, random.nextFloat()).setSource(prism);
		prism.setReplaceFunction((bState) -> {
			return bState.getMaterial().isReplaceable() || bState.is(CommonBlockTags.GEN_END_STONES) || bState.getMaterial()
																											  .equals(Material.PLANT) || bState
				.getMaterial()
				.equals(Material.LEAVES);
		});
		prism.fillRecursive(world, pos);
		BlocksHelper.setWithoutUpdate(world, pos, EndBlocks.AURORA_CRYSTAL.get());
		
		return true;
	}
}
