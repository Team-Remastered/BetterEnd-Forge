package com.teamremastered.betterendforge.registry.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
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

    public static final Holder<PlacedFeature> PYTHADENDRON_TREE_PLACED = PlacementUtils.register("pythadendron_tree_placed",
            EndConfiguredFeatures.PYTHADENDRON_TREE, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 2)));

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

    public static final Holder<PlacedFeature> CHORUS_GRASS_PLACED = PlacementUtils.register("chorus_grass_placed",
            EndConfiguredFeatures.CHORUS_GRASS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHORUS_MUSHROOM_PLACED = PlacementUtils.register("chorus_mushroom_placed",
            EndConfiguredFeatures.CHORUS_MUSHROOM,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CRYSTAL_GRASS_PLACED = PlacementUtils.register("crystal_grass_placed",
            EndConfiguredFeatures.CRYSTAL_GRASS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SHADOW_PLANT_PLACED = PlacementUtils.register("shadow_plant_placed",
            EndConfiguredFeatures.SHADOW_PLANT,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> MURKWEED_PLACED = PlacementUtils.register("murkweed_placed",
            EndConfiguredFeatures.MURKWEED,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> NEEDLEGRASS_PLACED = PlacementUtils.register("needlegrass_placed",
            EndConfiguredFeatures.NEEDLEGRASS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SHADOW_BERRY_PLACED = PlacementUtils.register("shadow_berry_placed",
            EndConfiguredFeatures.SHADOW_BERRY,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BUSHY_GRASS_PLACED = PlacementUtils.register("bushy_grass_placed",
            EndConfiguredFeatures.BUSHY_GRASS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BUSHY_GRASS_WG_PLACED = PlacementUtils.register("bushy_grass_wg_placed",
            EndConfiguredFeatures.BUSHY_GRASS_WG,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> AMBER_GRASS_PLACED = PlacementUtils.register("amber_grass_placed",
            EndConfiguredFeatures.AMBER_GRASS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> LANCELEAF_PLACED = PlacementUtils.register("lanceleaf_placed",
            EndConfiguredFeatures.LANCELEAF,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> GLOW_PILLAR_PLACED = PlacementUtils.register("glow_pillar_placed",
            EndConfiguredFeatures.GLOW_PILLAR,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> TWISTED_UMBRELLA_MOSS_PLACED = PlacementUtils.register("twisted_umbrella_moss_placed",
            EndConfiguredFeatures.TWISTED_UMBRELLA_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> JUNGLE_GRASS_PLACED = PlacementUtils.register("jungle_grass_placed",
            EndConfiguredFeatures.JUNGLE_GRASS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SMALL_JELLYSHROOM_FLOOR_PLACED = PlacementUtils.register("small_jellyshroom_floor_placed",
            EndConfiguredFeatures.SMALL_JELLYSHROOM_FLOOR,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BLOSSOM_BERRY_PLACED = PlacementUtils.register("blossom_berry_placed",
            EndConfiguredFeatures.BLOSSOM_BERRY,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BLOOMING_COOKSONIA_PLACED = PlacementUtils.register("blooming_cooksonia_placed",
            EndConfiguredFeatures.BLOOMING_COOKSONIA,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SALTEAGO_PLACED = PlacementUtils.register("salteago_placed",
            EndConfiguredFeatures.SALTEAGO,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> VAIOLUSH_FERN_PLACED = PlacementUtils.register("vaiolush_fern_placed",
            EndConfiguredFeatures.VAIOLUSH_FERN,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> FRACTURN_PLACED = PlacementUtils.register("fracturn_placed",
            EndConfiguredFeatures.FRACTURN,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> UMBRELLA_MOSS_RARE_PLACED = PlacementUtils.register("umbrella_moss_rareplaced",
            EndConfiguredFeatures.UMBRELLA_MOSS_RARE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CREEPING_MOSS_RARE_PLACED = PlacementUtils.register("creeping_moss_rare_placed",
            EndConfiguredFeatures.CREEPING_MOSS_RARE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> TWISTED_UMBRELLA_MOSS_RARE_PLACED = PlacementUtils.register("twisted_umbrella_moss_rare_placed",
            EndConfiguredFeatures.TWISTED_UMBRELLA_MOSS_RARE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> ORANGO_PLACED = PlacementUtils.register("orango_placed",
            EndConfiguredFeatures.ORANGO,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> AERIDIUM_PLACED = PlacementUtils.register("aeridium_placed",
            EndConfiguredFeatures.AERIDIUM,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> LUTEBUS_PLACED = PlacementUtils.register("lutebus_placed",
            EndConfiguredFeatures.LUTEBUS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> LAMELLARIUM_PLACED = PlacementUtils.register("lamellarium_placed",
            EndConfiguredFeatures.LAMELLARIUM,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SMALL_AMARANITA_PLACED = PlacementUtils.register("small_amaranita_placed",
            EndConfiguredFeatures.SMALL_AMARANITA,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> GLOBULAGUS_PLACED = PlacementUtils.register("globulagus_placed",
            EndConfiguredFeatures.GLOBULAGUS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CLAWFERN_PLACED = PlacementUtils.register("clawfern_placed",
            EndConfiguredFeatures.CLAWFERN,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BOLUX_MUSHROOM_PLACED = PlacementUtils.register("bolux_mushroom_placed",
            EndConfiguredFeatures.BOLUX_MUSHROOM,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> AMBER_ROOT_PLACED = PlacementUtils.register("amber_root_placed",
            EndConfiguredFeatures.AMBER_ROOT,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> INFLEXIA_PLACED = PlacementUtils.register("inflexia_placed",
            EndConfiguredFeatures.INFLEXIA,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> FLAMMALIX_PLACED = PlacementUtils.register("flammalix_placed",
            EndConfiguredFeatures.FLAMMALIX,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    /** BUSHES **/

    public static final Holder<PlacedFeature> PYTHADENDRON_BUSH_PLACED = PlacementUtils.register("pythadendron_bush",
            EndConfiguredFeatures.PYTHADENDRON_BUSH,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    /** WALL PLANTS **/
    public static final Holder<PlacedFeature> TAIL_MOSS_PLACED = PlacementUtils.register("tail_moss_placed",
            EndConfiguredFeatures.TAIL_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> TAIL_MOSS_WOOD_PLACED = PlacementUtils.register("tail_moss_wood_placed",
            EndConfiguredFeatures.TAIL_MOSS_WOOD,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> PURPLE_POLYPORE_PLACED = PlacementUtils.register("purple_polypore_placed",
            EndConfiguredFeatures.PURPLE_POLYPORE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            PlacementUtils.countExtra(5, 0.5F, 5),
            BiomeFilter.biome());

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
    public static final Holder<PlacedFeature> END_LOTUS_PLACED = PlacementUtils.register("end_lotus_placed",
            EndConfiguredFeatures.END_LOTUS,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> BUBBLE_CORAL_PLACED = PlacementUtils.register("bubble_coral_placed",
            EndConfiguredFeatures.BUBBLE_CORAL,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(1),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BUBBLE_CORAL_RARE_PLACED = PlacementUtils.register("bubble_coral_rare_placed",
            EndConfiguredFeatures.BUBBLE_CORAL_RARE,
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

    public static final Holder<PlacedFeature> END_LILY_RARE_PLACED = PlacementUtils.register("end_lily_rare_placed",
            EndConfiguredFeatures.END_LILY_RARE,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> END_LOTUS_LEAF_PLACED = PlacementUtils.register("end_lotus_leaf_placed",
            EndConfiguredFeatures.END_LOTUS_LEAF,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> HYDRALUX_PLACED = PlacementUtils.register("hydralux_placed",
            EndConfiguredFeatures.HYDRALUX,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> POND_ANEMONE_PLACED = PlacementUtils.register("pond_anemone_placed",
            EndConfiguredFeatures.POND_ANEMONE,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHARNIA_RED_PLACED = PlacementUtils.register("charnia_red_placed",
            EndConfiguredFeatures.CHARNIA_RED,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHARNIA_PURPLE_PLACED = PlacementUtils.register("charnia_purple_placed",
            EndConfiguredFeatures.CHARNIA_PURPLE,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHARNIA_ORANGE_PLACED = PlacementUtils.register("charnia_orange_placed",
            EndConfiguredFeatures.CHARNIA_ORANGE,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CHARNIA_GREEN_PLACED = PlacementUtils.register("charnia_green_placed",
            EndConfiguredFeatures.CHARNIA_GREEN,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> MENGER_SPONGE_PLACED = PlacementUtils.register("menger_sponge_placed",
            EndConfiguredFeatures.MENGER_SPONGE,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BIOME_ISLAND_PLACED = PlacementUtils.register("overworld_island_placed",
            EndConfiguredFeatures.BIOME_ISLAND,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            RarityFilter.onAverageOnceEvery(5),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> FLAMAEA_PLACED = PlacementUtils.register("flamaea_placed",
            EndConfiguredFeatures.FLAMAEA,
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

    public static final Holder<PlacedFeature> END_LAKE_RARE_PLACED = PlacementUtils.register("end_lake_rare_placed",
            EndConfiguredFeatures.END_LAKE_RARE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            PlacementUtils.countExtra(0, 0.05F, 1),
            BiomeFilter.biome());
}