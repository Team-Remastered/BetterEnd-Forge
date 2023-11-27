package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndFeatures;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.world.biome.EndBiome;

public class LanternWoodsBiome extends EndBiome.Config {
	public LanternWoodsBiome() {
		super("lantern_woods");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.fogColor(189, 82, 70)
			.fogDensity(1.1F)
			.waterAndFogColor(171, 234, 226)
			.plantsColor(254, 85, 57)
			.music(EndSounds.MUSIC_FOREST.get())
			.particles(EndParticles.GLOWING_SPHERE.get(), 0.001F)
			.feature(EndFeatures.END_LAKE_NORMAL)
			.feature(EndFeatures.FLAMAEA)
			.feature(EndFeatures.LUCERNIA)
			.feature(EndFeatures.LUCERNIA_BUSH)
			.feature(EndFeatures.FILALUX)
			.feature(EndFeatures.AERIDIUM)
			.feature(EndFeatures.LAMELLARIUM)
			.feature(EndFeatures.BOLUX_MUSHROOM)
			.feature(EndFeatures.AURANT_POLYPORE)
			.feature(EndFeatures.POND_ANEMONE)
			.feature(EndFeatures.CHARNIA_ORANGE)
			.feature(EndFeatures.CHARNIA_RED)
			.feature(EndFeatures.RUSCUS)
			.feature(EndFeatures.RUSCUS_WOOD)
			.structure(BiomeTags.HAS_END_CITY)
			.spawn(EntityType.ENDERMAN, 50, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.RUTISCUS.get().defaultBlockState();
			}
		};
	}
}
