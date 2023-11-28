package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndEntities;
import com.teamremastered.betterendforge.registry.EndFeatures;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.registry.EndStructures;

public class MegalakeBiome extends EndBiome.Config {
	public MegalakeBiome() {
		super("megalake");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.structure(EndStructures.MEGALAKE)
			.plantsColor(73, 210, 209)
			.fogColor(178, 209, 248)
			.waterAndFogColor(96, 163, 255)
			.fogDensity(1.75F)
			.music(EndSounds.MUSIC_WATER.get())
			.loop(EndSounds.AMBIENT_MEGALAKE.get())
			.terrainHeight(0F)
			.feature(EndFeatures.END_LOTUS)
			.feature(EndFeatures.END_LOTUS_LEAF)
			.feature(EndFeatures.BUBBLE_CORAL_RARE)
			.feature(EndFeatures.END_LILY_RARE)
			.feature(EndFeatures.UMBRELLA_MOSS)
			.feature(EndFeatures.CREEPING_MOSS)
			//.feature(EndFeatures.PEARLBERRY)
			.feature(EndFeatures.CHARNIA_CYAN)
			.feature(EndFeatures.CHARNIA_LIGHT_BLUE)
			.feature(EndFeatures.CHARNIA_RED_RARE)
			.feature(EndFeatures.MENGER_SPONGE)
			.spawn(EndEntities.DRAGONFLY.get(), 50, 1, 3)
			.spawn(EndEntities.END_FISH.get(), 50, 3, 8)
			.spawn(EndEntities.CUBOZOA.get(), 50, 3, 8)
			.spawn(EndEntities.END_SLIME.get(), 5, 1, 2)
			.spawn(EntityType.ENDERMAN, 10, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.END_MOSS.get().defaultBlockState();
			}

			@Override
			public BlockState getAltTopMaterial() {
				return EndBlocks.ENDSTONE_DUST.get().defaultBlockState();
			}
		};
	}
}
