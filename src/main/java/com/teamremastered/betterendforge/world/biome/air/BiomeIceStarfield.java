package com.teamremastered.betterendforge.world.biome.air;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.entity.EntityType;
import com.teamremastered.betterendforge.registry.world.EndFeatures;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.world.EndStructures;

public class BiomeIceStarfield extends EndBiome.Config {
	public BiomeIceStarfield() {
		super("ice_starfield");
	}

	@Override
	protected boolean hasCaves() {
		return false;
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder.structure(EndStructures.GIANT_ICE_STAR)
			   .fogColor(224, 245, 254)
			   .temperature(0F)
			   .fogDensity(2.2F)
			   .foliageColor(193, 244, 244)
			   .genChance(0.25F)
			   .particles(EndParticles.SNOWFLAKE.get(), 0.002F)
			   .feature(EndFeatures.ICE_STAR)
			   .feature(EndFeatures.ICE_STAR_SMALL)
			   .spawn(EntityType.ENDERMAN, 20, 1, 4);
	}
}
