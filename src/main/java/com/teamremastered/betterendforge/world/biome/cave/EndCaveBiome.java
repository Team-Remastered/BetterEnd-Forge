package com.teamremastered.betterendforge.world.biome.cave;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.api.biomes.BiomeAPI;
import com.teamremastered.betterendforge.bclib.api.features.BCLCommonFeatures;
import com.teamremastered.betterendforge.bclib.util.WeightedList;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiomeSettings;
import com.teamremastered.betterendforge.bclib.world.features.BCLFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import com.teamremastered.betterendforge.world.features.terrain.caves.CaveChunkPopulatorFeature;

import java.util.Random;

public class EndCaveBiome extends EndBiome {
	public static abstract class Config extends EndBiome.Config {
		protected Config(String name) {
			super(name);
		}

		@Override
		protected void addCustomBuildData(BCLBiomeBuilder builder) {
			BCLFeature feature = BCLCommonFeatures.makeChunkFeature(
					BetterEndForge.makeID(ID.getPath() + "_cave_populator"),
					GenerationStep.Decoration.RAW_GENERATION,
					new CaveChunkPopulatorFeature(() -> (EndCaveBiome) BiomeAPI.getBiome(ID))
			);

			builder.category(BiomeCategory.NONE)
				   .feature(feature)
				   .music(EndSounds.MUSIC_CAVES.get())
				   .loop(EndSounds.AMBIENT_CAVES.get());
		}

		@Override
		protected boolean hasCaves() {
			return false;
		}

		@Override
		public BCLBiomeBuilder.BiomeSupplier<EndBiome> getSupplier() {
			return EndCaveBiome::new;
		}
	}

	private WeightedList<Feature<?>> floorFeatures = new WeightedList<Feature<?>>();
	private WeightedList<Feature<?>> ceilFeatures = new WeightedList<Feature<?>>();

	public EndCaveBiome(ResourceLocation biomeID, Biome biome, BCLBiomeSettings settings) {
		super(biomeID, biome, settings);
	}
	
	public void addFloorFeature(Feature<?> feature, float weight) {
		floorFeatures.add(feature, weight);
	}
	
	public void addCeilFeature(Feature<?> feature, float weight) {
		ceilFeatures.add(feature, weight);
	}
	
	public Feature<?> getFloorFeature(Random random) {
		return floorFeatures.isEmpty() ? null : floorFeatures.get(random);
	}
	
	public Feature<?> getCeilFeature(Random random) {
		return ceilFeatures.isEmpty() ? null : ceilFeatures.get(random);
	}
	
	public float getFloorDensity() {
		return 0;
	}
	
	public float getCeilDensity() {
		return 0;
	}
	
	public BlockState getCeil(BlockPos pos) {
		return null;
	}
	
	public BlockState getWall(BlockPos pos) {
		return null;
	}

	public static EndCaveBiome create(EndBiome.Config biomeConfig){
		return (EndCaveBiome) EndBiome.create(biomeConfig);
	}
}
