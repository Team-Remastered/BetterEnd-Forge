package ru.betterend.world.features.terrain;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.api.tag.CommonBlockTags;
import ru.betterend.bclib.sdf.SDF;
import ru.betterend.bclib.sdf.operator.SDFRotation;
import ru.betterend.bclib.sdf.primitive.SDFHexPrism;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.bclib.util.MHelper;
import ru.betterend.bclib.world.features.DefaultFeature;
import ru.betterend.registry.EndBlocks;

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
