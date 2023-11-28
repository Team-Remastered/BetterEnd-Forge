package com.teamremastered.betterendforge.world.biome.cave;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiomeSettings;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.registry.EndFeatures;
import com.teamremastered.betterendforge.world.biome.EndBiome;

public class EmptyEndCaveBiome extends EndCaveBiome.Config {
	public static class Biome extends EndCaveBiome {
		public Biome(ResourceLocation biomeID, net.minecraft.world.level.biome.Biome biome, BCLBiomeSettings settings) {
			super(biomeID, biome, settings);

			this.addFloorFeature(EndFeatures.END_STONE_STALAGMITE, 1);
			this.addCeilFeature(EndFeatures.END_STONE_STALACTITE, 1);
		}

		@Override
		public float getFloorDensity() {
			return 0.1F;
		}

		@Override
		public float getCeilDensity() {
			return 0.1F;
		}
	}

	public EmptyEndCaveBiome() {
		super("empty_end_cave");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		super.addCustomBuildData(builder);
		builder.fogDensity(2.0F);
	}

	@Override
	public BCLBiomeBuilder.BiomeSupplier<EndBiome> getSupplier() {
		return Biome::new;
	}
}
