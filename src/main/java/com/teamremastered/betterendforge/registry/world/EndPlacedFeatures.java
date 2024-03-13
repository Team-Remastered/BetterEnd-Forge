package com.teamremastered.betterendforge.registry.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.placement.*;

public class EndPlacedFeatures {

    //TODO: ALL PLACED FEATURES FOR A BIOME NEED TO BE REVIEWED ONCE A BIOME IS FINISHED
    //TODO: Change countExtra with onAverageOnceEvery/CountOnEveryLayerPlacement to match the Fabric version

    /** TREES **/
    public static final Holder<PlacedFeature> MOSSY_GLOWSHROOM_PLACED = PlacementUtils.register("mossy_glowshroom_placed",
            EndConfiguredFeatures.MOSSY_GLOWSHROOM_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.1f, 2)));

    public static final Holder<PlacedFeature> PYTHADENDRON_TREE_PLACED = PlacementUtils.register("pythadendron_tree_placed",
            EndConfiguredFeatures.PYTHADENDRON_TREE, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 2)));

    public static final Holder<PlacedFeature> LACUGROVE_TREE_PLACED = PlacementUtils.register("lacugrove_tree_placed",
            EndConfiguredFeatures.LACUGROVE, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(4, 0.1f, 2)));

    public static final Holder<PlacedFeature> DRAGON_TREE_PLACED = PlacementUtils.register("dragon_tree_placed",
            EndConfiguredFeatures.DRAGON_TREE, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));

    public static final Holder<PlacedFeature> TENANEA_TREE_PLACED = PlacementUtils.register("tenanea_tree_placed",
            EndConfiguredFeatures.TENANEA, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));

    public static final Holder<PlacedFeature> HELIX_TREE_PLACED = PlacementUtils.register("helix_tree_placed",
            EndConfiguredFeatures.HELIX_TREE, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 2)));

    public static final Holder<PlacedFeature> UMBRELLA_TREE_PLACED = PlacementUtils.register("umbrella_tree_placed",
            EndConfiguredFeatures.UMBRELLA_TREE, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));

    public static final Holder<PlacedFeature> JELLYSHROOM_TREE_PLACED = PlacementUtils.register("jellyshroom_tree_placed",
            EndConfiguredFeatures.JELLYSHROOM, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));

    public static final Holder<PlacedFeature> GIGANTIC_AMARANITA_TREE_PLACED = PlacementUtils.register("gigantic_amaranita_tree_placed",
            EndConfiguredFeatures.GIGANTIC_AMARANITA, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 2)));

    public static final Holder<PlacedFeature> LUCERNIA_TREE_PLACED = PlacementUtils.register("lucernia_tree_placed",
            EndConfiguredFeatures.LUCERNIA, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(4, 0.1f, 2)));
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

    public static final Holder<PlacedFeature> PYTHADENDRON_BUSH_PLACED = PlacementUtils.register("pythadendron_bush_placed",
            EndConfiguredFeatures.PYTHADENDRON_BUSH,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> DRAGON_TREE_BUSH_PLACED = PlacementUtils.register("dragon_tree_bush_placed",
            EndConfiguredFeatures.DRAGON_TREE_BUSH,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 5)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> TENANEA_BUSH_PLACED = PlacementUtils.register("tenanea_bush_placed",
            EndConfiguredFeatures.TENANEA_BUSH,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 6)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> LUMECORN_PLACED = PlacementUtils.register("lumecorn_placed",
            EndConfiguredFeatures.LUMECORN,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 5)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> LARGE_AMARANITA_PLACED = PlacementUtils.register("large_amaranita_placed",
            EndConfiguredFeatures.LARGE_AMARANITA,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 5)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> LUCERNIA_BUSH_PLACED = PlacementUtils.register("lucernia_bush_placed",
            EndConfiguredFeatures.LUCERNIA_BUSH,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 10)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> LUCERNIA_BUSH_RARE_PLACED = PlacementUtils.register("lucernia_bush_rare_placed",
            EndConfiguredFeatures.LUCERNIA_BUSH_RARE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 1)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> NEON_CACTUS_PLACED = PlacementUtils.register("neon_cactus_placed",
            EndConfiguredFeatures.NEON_CACTUS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 2)),
            BiomeFilter.biome());



    /** WALL PLANTS **/
    public static final Holder<PlacedFeature> TAIL_MOSS_PLACED = PlacementUtils.register("tail_moss_placed",
            EndConfiguredFeatures.TAIL_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> TAIL_MOSS_WOOD_PLACED = PlacementUtils.register("tail_moss_wood_placed",
            EndConfiguredFeatures.TAIL_MOSS_WOOD,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> PURPLE_POLYPORE_PLACED = PlacementUtils.register("purple_polypore_placed",
            EndConfiguredFeatures.PURPLE_POLYPORE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> CYAN_MOSS_PLACED = PlacementUtils.register("cyan_moss_placed",
            EndConfiguredFeatures.CYAN_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> CYAN_MOSS_WOOD_PLACED = PlacementUtils.register("cyan_moss_wood_placed",
            EndConfiguredFeatures.CYAN_MOSS_WOOD,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> TWISTED_MOSS_PLACED = PlacementUtils.register("twisted_moss_placed",
            EndConfiguredFeatures.TWISTED_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> TWISTED_MOSS_WOOD_PLACED = PlacementUtils.register("twisted_moss_wood_placed",
            EndConfiguredFeatures.TWISTED_MOSS_WOOD,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BULB_MOSS_PLACED = PlacementUtils.register("bulb_moss_placed",
            EndConfiguredFeatures.BULB_MOSS,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> BULB_MOSS_WOOD_PLACED = PlacementUtils.register("bulb_moss_wood_placed",
            EndConfiguredFeatures.BULB_MOSS_WOOD,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SMALL_JELLYSHROOM_WALL_PLACED = PlacementUtils.register("small_jellyshroom_wall_placed",
            EndConfiguredFeatures.SMALL_JELLYSHROOM_WALL,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> SMALL_JELLYSHROOM_WOOD_PLACED = PlacementUtils.register("small_jellyshroom_wood_placed",
            EndConfiguredFeatures.SMALL_JELLYSHROOM_WOOD,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> JUNGLE_FERN_WOOD_PLACED = PlacementUtils.register("jungle_fern_wood_placed",
            EndConfiguredFeatures.JUNGLE_FERN_WOOD,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());
    public static final Holder<PlacedFeature> RUSCUS_PLACED = PlacementUtils.register("ruscus_placed",
            EndConfiguredFeatures.RUSCUS_WOOD,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> RUSCUS_WOOD_PLACED = PlacementUtils.register("ruscus_wood_placed",
            EndConfiguredFeatures.RUSCUS_WOOD,
            PlacementUtils.HEIGHTMAP,
            InSquarePlacement.spread(),
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
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
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 1)),
            CountPlacement.of(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> DENSE_VINE_PLACED = PlacementUtils.register("dense_vine_placed",
            EndConfiguredFeatures.DENSE_VINE,
            PlacementUtils.HEIGHTMAP,
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 1)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> TWISTED_VINE_PLACED = PlacementUtils.register("twisted_vine_placed",
            EndConfiguredFeatures.TWISTED_VINE,
            PlacementUtils.HEIGHTMAP,
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 1)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> BULB_VINE_PLACED = PlacementUtils.register("bulb_vine_placed",
            EndConfiguredFeatures.BULB_VINE,
            PlacementUtils.HEIGHTMAP,
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 3)),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> JUNGLE_VINE_PLACED = PlacementUtils.register("jungle_vine_placed",
            EndConfiguredFeatures.JUNGLE_VINE,
            PlacementUtils.HEIGHTMAP,
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 5)),
            BiomeFilter.biome());

    /** LAKES **/
    //FIXME: Lakes do not generate properly
    public static final Holder<PlacedFeature> END_LAKE_PLACED = PlacementUtils.register("end_lake_placed",
            EndConfiguredFeatures.END_LAKE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(4),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> END_LAKE_RARE_PLACED = PlacementUtils.register("end_lake_rare_placed",
            EndConfiguredFeatures.END_LAKE_RARE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(40),
            BiomeFilter.biome());

    /** TERRAIN **/

    public static final Holder<PlacedFeature> END_LAKE_NORMAL_PLACED = PlacementUtils.register("end_lake_normal",
            EndConfiguredFeatures.END_LAKE_NORMAL,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(20),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> DESERT_LAKE = PlacementUtils.register("desert_lake",
            EndConfiguredFeatures.DESERT_LAKE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(8),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> ROUND_CAVE = PlacementUtils.register("round_cave",
            EndConfiguredFeatures.ROUND_CAVE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(2),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SPIRE_PLACED = PlacementUtils.register("spire",
            EndConfiguredFeatures.SPIRE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(4),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> FLOATING_SPIRE_PLACED = PlacementUtils.register("floating_spire",
            EndConfiguredFeatures.FLOATING_SPIRE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(8),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> GEYSER_PLACED = PlacementUtils.register("geyser",
            EndConfiguredFeatures.GEYSER,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(8),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SULPHURIC_LAKE_PLACED = PlacementUtils.register("sulphuric_lake",
            EndConfiguredFeatures.SULPHURIC_LAKE,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(8),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> ICE_STAR_PLACED = PlacementUtils.register("ice_star",
            EndConfiguredFeatures.ICE_STAR,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(15),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> ICE_STAR_SMALL_PLACED = PlacementUtils.register("ice_star_small",
            EndConfiguredFeatures.ICE_STAR_SMALL,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(8),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SURFACE_VENT_PLACED = PlacementUtils.register("surface_vent",
            EndConfiguredFeatures.SURFACE_VENT,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(4),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> SULPHUR_HILL_PLACED = PlacementUtils.register("sulphur_hill",
            EndConfiguredFeatures.SULPHUR_HILL,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(8),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> OBSIDIAN_PILLAR_BASEMENT_PLACED = PlacementUtils.register("obsidian_pillar_basement",
            EndConfiguredFeatures.OBSIDIAN_PILLAR_BASEMENT,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(8),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> OBSIDIAN_BOULDER_PLACED = PlacementUtils.register("obsidian_boulder",
            EndConfiguredFeatures.OBSIDIAN_BOULDER,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(10),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> FALLEN_PILLAR_PLACED = PlacementUtils.register("fallen_pillar",
            EndConfiguredFeatures.FALLEN_PILLAR,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(20),
            BiomeFilter.biome());

    public static final Holder<PlacedFeature> UMBRALITH_ARCH_PLACED = PlacementUtils.register("umbralith_arch",
            EndConfiguredFeatures.UMBRALITH_ARCH,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(10),
            BiomeFilter.biome());

    /** CEIL PLANTS **/
    public static final Holder<PlacedFeature> SMALL_JELLYSHROOM_CEIL_PLACED = PlacementUtils.register("small_jellyshroom_ceil_placed",
            EndConfiguredFeatures.SMALL_JELLYSHROOM_CEIL,
            PlacementUtils.HEIGHTMAP,
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 1)),
            BiomeFilter.biome());

    /** SKY PLANTS **/
    public static final Holder<PlacedFeature> FILALUX_PLACED = PlacementUtils.register("filalux_placed",
            EndConfiguredFeatures.FILALUX,
            PlacementUtils.HEIGHTMAP,
            CountOnEveryLayerPlacement.of(UniformInt.of(0, 1)),
            BiomeFilter.biome());

    /** BUILDING **/
    public static final Holder<PlacedFeature> CRASHED_SHIP_PLACED = PlacementUtils.register("crashed_ship_placed",
            EndConfiguredFeatures.CRASHED_SHIP,
            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
            RarityFilter.onAverageOnceEvery(500),
            BiomeFilter.biome());

    /** MOBS **/
    public static final Holder<PlacedFeature> SILK_MOTH_NEST_PLACED = PlacementUtils.register("silk_moth_placed",
            EndConfiguredFeatures.SILK_MOTH_NEST,
            PlacementUtils.HEIGHTMAP,
            RarityFilter.onAverageOnceEvery(2),
            BiomeFilter.biome());
}