package com.teamremastered.betterendforge.world.features.terrain;

import com.mojang.math.Vector3f;
import com.teamremastered.betterendforge.bclib.sdf.SDF;
import com.teamremastered.betterendforge.bclib.sdf.operator.SDFRotation;
import com.teamremastered.betterendforge.bclib.sdf.operator.SDFTranslate;
import com.teamremastered.betterendforge.bclib.sdf.operator.SDFUnion;
import com.teamremastered.betterendforge.bclib.sdf.primitive.SDFCappedCone;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IceStarFeature extends DefaultFeature {
	private final float minSize;
	private final float maxSize;
	private final int minCount;
	private final int maxCount;
	
	public IceStarFeature(float minSize, float maxSize, int minCount, int maxCount) {
		this.minSize = minSize;
		this.maxSize = maxSize;
		this.minCount = minCount;
		this.maxCount = maxCount;
	}
	
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featureConfig) {
		final Random random = featureConfig.random();
		BlockPos pos = featureConfig.origin();
		final WorldGenLevel world = featureConfig.level();
		float size = MHelper.randRange(minSize, maxSize, random);
		int count = MHelper.randRange(minCount, maxCount, random);
		List<Vector3f> points = getFibonacciPoints(count);
		SDF sdf = null;
		SDF spike = new SDFCappedCone().setRadius1(3 + (size - 5) * 0.2F)
									   .setRadius2(0)
									   .setHeight(size)
									   .setBlock(EndBlocks.DENSE_SNOW.get());
		spike = new SDFTranslate().setTranslate(0, size - 0.5F, 0).setSource(spike);
		for (Vector3f point : points) {
			SDF rotated = spike;
			point = MHelper.normalize(point);
			float angle = MHelper.angle(Vector3f.YP, point);
			if (angle > 0.01F && angle < 3.14F) {
				Vector3f axis = MHelper.normalize(MHelper.cross(Vector3f.YP, point));
				rotated = new SDFRotation().setRotation(axis, angle).setSource(spike);
			}
			else if (angle > 1) {
				rotated = new SDFRotation().setRotation(Vector3f.YP, (float) Math.PI).setSource(spike);
			}
			sdf = (sdf == null) ? rotated : new SDFUnion().setSourceA(sdf).setSourceB(rotated);
		}
		
		int x1 = (pos.getX() >> 4) << 4;
		int z1 = (pos.getZ() >> 4) << 4;
		pos = new BlockPos(x1 + random.nextInt(16), MHelper.randRange(32, 128, random), z1 + random.nextInt(16));
		
		final float ancientRadius = size * 0.7F;
		final float denseRadius = size * 0.9F;
		final float iceRadius = size < 7 ? size * 5 : size * 1.3F;
		final float randScale = size * 0.3F;
		
		final BlockPos center = pos;
		final BlockState ice = EndBlocks.EMERALD_ICE.get().defaultBlockState();
		final BlockState dense = EndBlocks.DENSE_EMERALD_ICE.get().defaultBlockState();
		final BlockState ancient = EndBlocks.ANCIENT_EMERALD_ICE.get().defaultBlockState();
		final SDF sdfCopy = sdf;
		
		sdf.addPostProcess((info) -> {
			BlockPos bpos = info.getPos();
			float px = bpos.getX() - center.getX();
			float py = bpos.getY() - center.getY();
			float pz = bpos.getZ() - center.getZ();
			float distance = MHelper.length(px, py, pz) + sdfCopy.getDistance(
				px,
				py,
				pz
			) * 0.4F + random.nextFloat() * randScale;
			if (distance < ancientRadius) {
				return ancient;
			}
			else if (distance < denseRadius) {
				return dense;
			}
			else if (distance < iceRadius) {
				return ice;
			}
			return info.getState();
		}).fillRecursive(world, pos);
		
		return true;
	}
	
	private List<Vector3f> getFibonacciPoints(int count) {
		float max = count - 1;
		List<Vector3f> result = new ArrayList<Vector3f>(count);
		for (int i = 0; i < count; i++) {
			float y = 1F - (i / max) * 2F;
			float radius = (float) Math.sqrt(1F - y * y);
			float theta = MHelper.PHI * i;
			float x = (float) Math.cos(theta) * radius;
			float z = (float) Math.sin(theta) * radius;
			result.add(new Vector3f(x, y, z));
		}
		return result;
	}
}
