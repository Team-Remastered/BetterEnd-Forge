package com.teamremastered.betterendforge.registry.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.NoiseBasedCountPlacement;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class EndPlacedFeatures {

    //TODO: ALL PLACED FEATURES FOR A BIOME NEED TO BE REVIEWED ONCE A BIOME IS FINISHED

    /** TREES **/
    public static final Holder<PlacedFeature> MOSSY_GLOWSHROOM_PLACED = PlacementUtils.register("mossy_glowshroom_placed",
            EndConfiguredFeatures.MOSSY_GLOWSHROOM_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.1f, 2)));

    /** FLOWERS **/
    public static final Holder<PlacedFeature> CREEPING_MOSS_PLACED = PlacementUtils.register("creeping_moss_placed",
            EndConfiguredFeatures.CREEPING_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> UMBRELLA_MOSS_PLACED = PlacementUtils.register("umbrella_moss_placed",
            EndConfiguredFeatures.UMBRELLA_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    /** WALL PLANTS **/
    public static final Holder<PlacedFeature> CYAN_MOSS_PLACED = PlacementUtils.register("cyan_moss_placed",
            EndConfiguredFeatures.CYAN_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> CYAN_MOSS_WOOD_PLACED = PlacementUtils.register("cyan_moss_wood_placed",
            EndConfiguredFeatures.CYAN_MOSS_WOOD,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());
    /** WATER **/
    public static final Holder<PlacedFeature> BUBBLE_CORAL_PLACED = PlacementUtils.register("bubble_coral_placed",
            EndConfiguredFeatures.BUBBLE_CORAL,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> END_LILY_PLACED = PlacementUtils.register("end_lily_placed",
            EndConfiguredFeatures.END_LILY,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHARNIA_CYAN_PLACED = PlacementUtils.register("charnia_cyan_placed",
            EndConfiguredFeatures.CHARNIA_CYAN,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHARNIA_LIGHT_BLUE_PLACED = PlacementUtils.register("charnia_light_blue_placed",
            EndConfiguredFeatures.CHARNIA_LIGHT_BLUE,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHARNIA_RED_RARE_PLACED = PlacementUtils.register("charnia_red_rare_placed",
            EndConfiguredFeatures.CHARNIA_RED_RARE,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    /** VINES **/
    public static final Holder<PlacedFeature> BLUE_VINE_PLACED = PlacementUtils.register("blue_vine_placed",
            EndConfiguredFeatures.BLUE_VINE,
            PlacementUtils.HEIGHTMAP,
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> DENSE_VINES_PLACED = PlacementUtils.register("dense_vines_placed",
            EndConfiguredFeatures.DENSE_VINE,
            PlacementUtils.HEIGHTMAP,
            PlacementUtils.countExtra(2, 0.05F, 1),
            BiomeFilter.biome());

    /** LAKES **/
    //FIXME: Lakes do not generate properly
    public static final Holder<PlacedFeature> END_LAKE_PLACED = PlacementUtils.register("end_lake_placed",
            EndConfiguredFeatures.END_LAKE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            PlacementUtils.countExtra(0, 0.1F, 1),
            BiomeFilter.biome());
}