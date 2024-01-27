package com.teamremastered.betterendforge.mixin.common;

import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseChunk;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.blending.Blender;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.teamremastered.betterendforge.interfaces.BETargetChecker;
import com.teamremastered.betterendforge.world.generator.TerrainGenerator;

import java.util.List;

@Mixin(NoiseChunk.class)
public class NoiseChunkMixin implements BETargetChecker {
	private boolean be_isEndGenerator;

	@Inject(method = "<init>*", at = @At("TAIL"))
	private void be_onNoiseChunkInit(int i, int j, int k, NoiseRouter noiseRouter, int l, int m, DensityFunctions.BeardifierOrMarker beardifierOrMarker, NoiseGeneratorSettings noiseGeneratorSettings, Aquifer.FluidPicker fluidPicker, Blender blender, CallbackInfo ci) {
		be_isEndGenerator = BETargetChecker.class.cast(noiseGeneratorSettings).be_isTarget();
	}
	
	@Override
	public boolean be_isTarget() {
		return be_isEndGenerator;
	}
	
	@Override
	public void be_setTarget(boolean target) {
		be_isEndGenerator = target;
	}

	@Shadow @Final private List<NoiseChunk.NoiseInterpolator> interpolators;

	@Inject(method = "fillSlice", at = @At("HEAD"), cancellable = true)
	private void be_fillSlice(boolean primarySlice, int x, CallbackInfo info) {
//		if (!be_isTarget()) return;
//
//		info.cancel();
//
//		NoiseChunkAccessor accessor = NoiseChunkAccessor.class.cast(this);
//		NoiseSettings noiseSettings = accessor.bnv_getNoiseSettings();
//
//		final int sizeY = noiseSettings.getCellHeight();
//		final int sizeXZ = noiseSettings.getCellWidth();
//		final int cellSizeXZ = accessor.bnv_getCellCountXZ() + 1;
//		final int firstCellZ = accessor.bnv_getFirstCellZ();
//
//		x *= sizeXZ;
//		for (int cellXZ = 0; cellXZ < cellSizeXZ; ++cellXZ) {
//			int z = (firstCellZ + cellXZ) * sizeXZ;
//			for (NoiseChunk.NoiseInterpolator noiseInterpolator : this.interpolators) {
//				NoiseInterpolatorAccessor interpolator = (NoiseInterpolatorAccessor) noiseInterpolator;
//				final double[] ds = (primarySlice ? interpolator.be_getSlice0() : interpolator.be_getSlice1())[cellXZ];
//				TerrainGenerator.fillTerrainDensity(ds, x, z, sizeXZ, sizeY);
//			}
//		}
	}
}