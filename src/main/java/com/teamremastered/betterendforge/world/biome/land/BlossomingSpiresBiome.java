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

public class BlossomingSpiresBiome extends EndBiome.Config {
	public BlossomingSpiresBiome() {
		super("blossoming_spires");
	}

	@Override
	protected boolean hasCaves() {
		return false;
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
			.fogColor(241, 146, 229)
			.fogDensity(1.7F)
			.plantsColor(122, 45, 122)
			.music(EndSounds.MUSIC_FOREST.get())
			.loop(EndSounds.AMBIENT_BLOSSOMING_SPIRES.get())
			.feature(EndFeatures.SPIRE)
			.feature(EndFeatures.FLOATING_SPIRE)
			.feature(EndFeatures.TENANEA)
			.feature(EndFeatures.TENANEA_BUSH)
			.feature(EndFeatures.BULB_VINE)
			.feature(EndFeatures.BUSHY_GRASS)
			.feature(EndFeatures.BUSHY_GRASS_WG)
			.feature(EndFeatures.BLOSSOM_BERRY)
			.feature(EndFeatures.TWISTED_MOSS)
			.feature(EndFeatures.TWISTED_MOSS_WOOD)
			.feature(EndFeatures.SILK_MOTH_NEST)
			.spawn(EntityType.ENDERMAN, 50, 1, 4)
			.spawn(EndEntities.SILK_MOTH.get(), 5, 1, 2);
	}

	@Override
	protected SurfaceMaterialProvider surfaceMaterial() {
		return new EndBiome.DefaultSurfaceMaterialProvider() {
			@Override
			public BlockState getTopMaterial() {
				return EndBlocks.PINK_MOSS.get().defaultBlockState();
			}
		};
	}
}
