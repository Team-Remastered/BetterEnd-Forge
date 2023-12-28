package com.teamremastered.betterendforge.world.biome.land;

import com.teamremastered.betterendforge.bclib.api.biomes.BCLBiomeBuilder;
import com.teamremastered.betterendforge.bclib.interfaces.SurfaceMaterialProvider;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndEntities;
import com.teamremastered.betterendforge.registry.EndFeatures;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.registry.EndStructures;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FoggyMushroomlandBiome extends EndBiome.Config {
	public FoggyMushroomlandBiome() {
		super("foggy_mushroomland");
	}

	@Override
	protected void addCustomBuildData(BCLBiomeBuilder builder) {
		builder
//			.structure(EndStructures.GIANT_MOSSY_GLOWSHROOM)
			.plantsColor(73, 210, 209)
			.fogColor(41, 122, 173)
			.fogDensity(3)
			.waterAndFogColor(119, 227, 250)
			.particles(EndParticles.GLOWING_SPHERE.get(), 0.001F)
			.loop(EndSounds.AMBIENT_FOGGY_MUSHROOMLAND.get())
			.music(EndSounds.MUSIC_FOREST.get())
//			.feature(EndFeatures.END_LAKE)
//			.feature(EndFeatures.MOSSY_GLOWSHROOM)
//			.feature(EndFeatures.BLUE_VINE)
//			.feature(EndFeatures.UMBRELLA_MOSS)
//			.feature(EndFeatures.CREEPING_MOSS)
//			.feature(EndFeatures.DENSE_VINE)
//			//.feature(EndFeatures.PEARLBERRY)
//			.feature(EndFeatures.CYAN_MOSS)
//			.feature(EndFeatures.CYAN_MOSS_WOOD)
//			.feature(EndFeatures.END_LILY)
//			.feature(EndFeatures.BUBBLE_CORAL)
//			.feature(EndFeatures.CHARNIA_CYAN)
//			.feature(EndFeatures.CHARNIA_LIGHT_BLUE)
//			.feature(EndFeatures.CHARNIA_RED_RARE)
			.feature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.GLOWSTONE)
			.feature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BAMBOO)
			.feature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_TAIGA)
			.feature(GenerationStep.Decoration.VEGETAL_DECORATION, NetherPlacements.SMALL_BASALT_COLUMNS)
			.feature(GenerationStep.Decoration.SURFACE_STRUCTURES, NetherPlacements.LARGE_BASALT_COLUMNS)

			.structure(BiomeTags.HAS_IGLOO)
			.structure(BiomeTags.HAS_DESERT_PYRAMID)
			.structure(BiomeTags.HAS_END_CITY)
//			.spawn(EndEntities.DRAGONFLY.get(), 80, 2, 5)
//			.spawn(EndEntities.END_FISH.get(), 20, 2, 5)
//			.spawn(EndEntities.CUBOZOA.get(), 10, 3, 8)
//			.spawn(EndEntities.END_SLIME.get(), 10, 1, 2)
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
				return EndBlocks.END_MYCELIUM.get().defaultBlockState();
			}
		};


	}
}