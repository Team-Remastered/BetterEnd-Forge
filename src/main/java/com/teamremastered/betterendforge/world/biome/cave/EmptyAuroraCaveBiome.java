package com.teamremastered.betterendforge.world.biome.cave;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiomeSettings;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.world.biome.EndBiome;

public class EmptyAuroraCaveBiome extends EndCaveBiome.Config {
	public static class Biome extends EndCaveBiome {
		public Biome(ResourceLocation biomeID, net.minecraft.world.level.biome.Biome biome, BCLBiomeSettings settings) {
			super(biomeID, biome, settings);

//			this.addFloorFeature(EndFeatures.BIG_AURORA_CRYSTAL, 1);
//
//			this.addCeilFeature(EndFeatures.END_STONE_STALACTITE, 1);
		}

		@Override
		public float getFloorDensity() {
			return 0.01F;
		}

		@Override
		public float getCeilDensity() {
			return 0.1F;
		}
	}

	public EmptyAuroraCaveBiome() {
		super("empty_aurora_cave");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		super.addCustomBuildData(builder);
		builder.fogColor(150, 30, 68)
			   .fogDensity(2.0F)
			   .plantsColor(108, 25, 46)
			   .waterAndFogColor(186, 77, 237)
			   .particles(EndParticles.GLOWING_SPHERE.get(), 0.001F);
	}

	@Override
	public BCLBiomeBuilder.BiomeSupplier<EndBiome> getSupplier() {
		return EmptyAuroraCaveBiome.Biome::new;
	}
}
