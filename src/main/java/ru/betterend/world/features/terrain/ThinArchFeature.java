package ru.betterend.world.features.terrain;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import ru.betterend.bclib.api.tag.CommonBlockTags;
import ru.betterend.bclib.sdf.SDF;
import ru.betterend.bclib.sdf.operator.SDFCoordModify;
import ru.betterend.bclib.sdf.operator.SDFDisplacement;
import ru.betterend.bclib.sdf.operator.SDFRotation;
import ru.betterend.bclib.sdf.operator.SDFUnion;
import ru.betterend.bclib.sdf.primitive.SDFTorus;
import ru.betterend.bclib.util.MHelper;
import ru.betterend.bclib.world.features.DefaultFeature;
import ru.betterend.noise.OpenSimplexNoise;

import java.util.Random;

public class ThinArchFeature extends DefaultFeature {
	private Block block;
	
	public ThinArchFeature(Block block) {
		this.block = block;
	}
	
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
		final WorldGenLevel world = featurePlaceContext.level();
		BlockPos origin = featurePlaceContext.origin();
		Random random = featurePlaceContext.random();

		BlockPos pos = getPosOnSurfaceWG(world, new BlockPos((origin.getX() & 0xFFFFFFF0) | 7, 0, (origin.getZ() & 0xFFFFFFF0) | 7));
		if (!world.getBlockState(pos.below(5)).is(CommonBlockTags.GEN_END_STONES)) {
			return false;
		}
	
		SDF sdf = null;
		float bigRadius = MHelper.randRange(15F, 20F, random);
		float variation = bigRadius * 0.3F;
		int count = MHelper.randRange(2, 4, random);
		
		for (int i = 0; i < count; i++) {
			float smallRadius = MHelper.randRange(0.6F, 1.3F, random);
			SDF arch = new SDFTorus().setBigRadius(bigRadius - random.nextFloat() * variation).setSmallRadius(smallRadius).setBlock(block);
			float angle = (i - count * 0.5F) * 0.3F + random.nextFloat() * 0.05F + (float) Math.PI * 0.5F;
			arch = new SDFRotation().setRotation(Vector3f.XP, angle).setSource(arch);
			sdf = sdf == null ? arch : new SDFUnion().setSourceA(sdf).setSourceB(arch);
		}
		
		sdf = new SDFRotation().setRotation(MHelper.randomHorizontal(random), random.nextFloat() * MHelper.PI2).setSource(sdf);
	
		OpenSimplexNoise noise = new OpenSimplexNoise(random.nextLong());
		sdf = new SDFCoordModify().setFunction(vec -> {
			float dx = (float) noise.eval(vec.y() * 0.02, vec.z() * 0.02);
			float dy = (float) noise.eval(vec.x() * 0.02, vec.z() * 0.02);
			float dz = (float) noise.eval(vec.x() * 0.02, vec.y() * 0.02);
			vec.add(dx * 10, dy * 10, dz * 10);
		}).setSource(sdf);
		sdf = new SDFDisplacement().setFunction(vec -> {
			float offset = vec.y() / bigRadius - 0.5F;
			return Mth.clamp(offset * 3, -10F, 0F);
		}).setSource(sdf);
		
		float side = (bigRadius + 2.5F) * 2;
		if (side > 47) {
			side = 47;
		}
		sdf.fillArea(world, pos, AABB.ofSize(Vec3.atCenterOf(pos), side, side, side));
		return true;
	}
}
