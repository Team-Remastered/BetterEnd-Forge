package com.teamremastered.betterendforge.world.biome.cave;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiomeSettings;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.world.biome.EndBiome;

public class EmptySmaragdantCaveBiome extends EndCaveBiome.Config {
	public static class Biome extends EndCaveBiome {
		public Biome(ResourceLocation biomeID, net.minecraft.world.level.biome.Biome biome, BCLBiomeSettings settings) {
			super(biomeID, biome, settings);

//			this.addFloorFeature(EndFeatures.SMARAGDANT_CRYSTAL, 1);
//			this.addFloorFeature(EndFeatures.SMARAGDANT_CRYSTAL_SHARD, 20);
//
//			this.addCeilFeature(EndFeatures.END_STONE_STALACTITE, 1);
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

	public EmptySmaragdantCaveBiome() {
		super("empty_smaragdant_cave");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		super.addCustomBuildData(builder);
		builder.fogColor(0, 253, 182)
				.fogDensity(2.0F)
				.plantsColor(0, 131, 145)
				.waterAndFogColor(31, 167, 212)
				.particles(EndParticles.SMARAGDANT.get(), 0.001F);
	}

	@Override
	public BCLBiomeBuilder.BiomeSupplier<EndBiome> getSupplier() {
		return EmptySmaragdantCaveBiome.Biome::new;
	}
}
