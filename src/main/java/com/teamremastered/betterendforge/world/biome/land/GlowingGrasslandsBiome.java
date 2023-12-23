package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndFeatures;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;

public class GlowingGrasslandsBiome extends EndBiome.Config {
	public GlowingGrasslandsBiome() {
		super("glowing_grasslands");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.fogColor(99, 228, 247)
			.fogDensity(1.3F)
			.particles(EndParticles.FIREFLY.get(), 0.001F)
			.music(EndSounds.MUSIC_OPENSPACE.get())
			.loop(EndSounds.AMBIENT_GLOWING_GRASSLANDS.get())
			.waterAndFogColor(92, 250, 230)
			.plantsColor(73, 210, 209)
//			.feature(EndFeatures.END_LAKE_RARE)
//			.feature(EndFeatures.LUMECORN)
//			.feature(EndFeatures.BLOOMING_COOKSONIA)
//			.feature(EndFeatures.SALTEAGO)
//			.feature(EndFeatures.VAIOLUSH_FERN)
//			.feature(EndFeatures.FRACTURN)
//			.feature(EndFeatures.UMBRELLA_MOSS_RARE)
//			.feature(EndFeatures.CREEPING_MOSS_RARE)
//			.feature(EndFeatures.TWISTED_UMBRELLA_MOSS_RARE)
//			.feature(EndFeatures.CHARNIA_CYAN)
//			.feature(EndFeatures.CHARNIA_GREEN)
//			.feature(EndFeatures.CHARNIA_LIGHT_BLUE)
//			.feature(EndFeatures.CHARNIA_RED_RARE)
//			.structure(BiomeTags.HAS_END_CITY)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.END_MOSS.get().defaultBlockState();
			}
		};
	}
}
