package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.features.*;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class EndConfiguredFeatures {

    /** TREES **/
    //Not sure if it is necessary to do this
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MOSSY_GLOWSHROOM =
            registerNoneFeatureConfiguration("mossy_glowshroom", TempEndFeatures.MOSSY_GLOWSHROOM.get());

    public static final Holder<PlacedFeature> MOSSY_GLOWSHROOM_CHECKED = PlacementUtils.register("mossy_glowshroom_checked", MOSSY_GLOWSHROOM,
            PlacementUtils.filteredByBlockSurvival(EndBlocks.MOSSY_GLOWSHROOM_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MOSSY_GLOWSHROOM_SPAWN = FeatureUtils.register("mossy_glowshroom_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(List.of(
            new WeightedPlacedFeature(MOSSY_GLOWSHROOM_CHECKED, 0.5F)), MOSSY_GLOWSHROOM_CHECKED));

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PYTHADENDRON_TREE =
            registerNoneFeatureConfiguration("pythadendron_tree_spawn", TempEndFeatures.PYTHADENDRON_TREE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LACUGROVE =
            registerNoneFeatureConfiguration("lacugrove_tree_spawn", TempEndFeatures.LACUGROVE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> DRAGON_TREE =
            registerNoneFeatureConfiguration("dragon_tree_spawn", TempEndFeatures.DRAGON_TREE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TENANEA =
            registerNoneFeatureConfiguration("tenanea_tree_spawn", TempEndFeatures.TENANEA.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HELIX_TREE =
            registerNoneFeatureConfiguration("helix_tree_spawn", TempEndFeatures.HELIX_TREE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> UMBRELLA_TREE =
            registerNoneFeatureConfiguration("umbrella_tree_spawn", TempEndFeatures.UMBRELLA_TREE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JELLYSHROOM =
            registerNoneFeatureConfiguration("jellyshroom_tree_spawn", TempEndFeatures.JELLYSHROOM.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GIGANTIC_AMARANITA =
            registerNoneFeatureConfiguration("gigantic_amaranita_tree_spawn", TempEndFeatures.GIGANTIC_AMARANITA.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LUCERNIA =
            registerNoneFeatureConfiguration("lucernia_tree_spawn", TempEndFeatures.LUCERNIA.get());

    /** FLOWERS **/

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CREEPING_MOSS =
            registerNoneFeatureConfiguration("creeping_moss_spawn", TempEndFeatures.CREEPING_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> UMBRELLA_MOSS =
            registerNoneFeatureConfiguration("umbrella_moss_spawn", TempEndFeatures.UMBRELLA_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHORUS_GRASS =
            registerNoneFeatureConfiguration("chorus_grass_spawn", TempEndFeatures.CHORUS_GRASS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHORUS_MUSHROOM =
            registerNoneFeatureConfiguration("chorus_mushroom_spawn", TempEndFeatures.CHORUS_MUSHROOM.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CRYSTAL_GRASS =
            registerNoneFeatureConfiguration("crystal_grass_spawn", TempEndFeatures.CRYSTAL_GRASS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SHADOW_PLANT =
            registerNoneFeatureConfiguration("shadow_plant_spawn", TempEndFeatures.SHADOW_PLANT.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MURKWEED =
            registerNoneFeatureConfiguration("murkweed_spawn", TempEndFeatures.MURKWEED.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> NEEDLEGRASS =
            registerNoneFeatureConfiguration("needlegrass_spawn", TempEndFeatures.NEEDLEGRASS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SHADOW_BERRY =
            registerNoneFeatureConfiguration("shadow_berry_spawn", TempEndFeatures.SHADOW_BERRY.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BUSHY_GRASS =
            registerNoneFeatureConfiguration("bushy_grass_spawn", TempEndFeatures.BUSHY_GRASS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BUSHY_GRASS_WG =
            registerNoneFeatureConfiguration("bushy_grass_wg_spawn", TempEndFeatures.BUSHY_GRASS_WG.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> AMBER_GRASS =
            registerNoneFeatureConfiguration("amber_grass_spawn", TempEndFeatures.AMBER_GRASS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LANCELEAF =
            registerNoneFeatureConfiguration("lanceleaf_spawn", TempEndFeatures.LANCELEAF.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GLOW_PILLAR =
            registerNoneFeatureConfiguration("glow_pillar_spawn", TempEndFeatures.GLOW_PILLAR.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TWISTED_UMBRELLA_MOSS =
            registerNoneFeatureConfiguration("twisted_umbrella_moss_spawn", TempEndFeatures.TWISTED_UMBRELLA_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUNGLE_GRASS =
            registerNoneFeatureConfiguration("jungle_grass_spawn", TempEndFeatures.JUNGLE_GRASS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_JELLYSHROOM_FLOOR =
            registerNoneFeatureConfiguration("small_jellyshroom_floor_spawn", TempEndFeatures.SMALL_JELLYSHROOM_FLOOR.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BLOSSOM_BERRY =
            registerNoneFeatureConfiguration("blossom_berry_spawn", TempEndFeatures.BLOSSOM_BERRY.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BLOOMING_COOKSONIA =
            registerNoneFeatureConfiguration("blooming_cooksonia_spawn", TempEndFeatures.BLOOMING_COOKSONIA.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SALTEAGO =
            registerNoneFeatureConfiguration("salteago_spawn", TempEndFeatures.SALTEAGO.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> VAIOLUSH_FERN =
            registerNoneFeatureConfiguration("vaiolush_fern_spawn", TempEndFeatures.VAIOLUSH_FERN.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FRACTURN =
            registerNoneFeatureConfiguration("fracturn_spawn", TempEndFeatures.FRACTURN.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> UMBRELLA_MOSS_RARE =
            registerNoneFeatureConfiguration("umbrella_moss_rare_spawn", TempEndFeatures.UMBRELLA_MOSS_RARE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CREEPING_MOSS_RARE =
            registerNoneFeatureConfiguration("creeping_moss_rare_spawn", TempEndFeatures.CREEPING_MOSS_RARE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TWISTED_UMBRELLA_MOSS_RARE =
            registerNoneFeatureConfiguration("twisted_umbrella_moss_rare_spawn", TempEndFeatures.TWISTED_UMBRELLA_MOSS_RARE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> ORANGO =
            registerNoneFeatureConfiguration("orango_spawn", TempEndFeatures.ORANGO.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> AERIDIUM =
            registerNoneFeatureConfiguration("aeridium_spawn", TempEndFeatures.AERIDIUM.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LUTEBUS =
            registerNoneFeatureConfiguration("lutebus_spawn", TempEndFeatures.LUTEBUS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LAMELLARIUM =
            registerNoneFeatureConfiguration("lamellarium_spawn", TempEndFeatures.LAMELLARIUM.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_AMARANITA =
            registerNoneFeatureConfiguration("small_amaranita_spawn", TempEndFeatures.SMALL_AMARANITA.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GLOBULAGUS =
            registerNoneFeatureConfiguration("globulagus_spawn", TempEndFeatures.GLOBULAGUS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CLAWFERN =
            registerNoneFeatureConfiguration("clawfern_spawn", TempEndFeatures.CLAWFERN.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BOLUX_MUSHROOM =
            registerNoneFeatureConfiguration("bolux_mushroom_spawn", TempEndFeatures.BOLUX_MUSHROOM.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> AMBER_ROOT =
            registerNoneFeatureConfiguration("amber_root_spawn", TempEndFeatures.AMBER_ROOT.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> INFLEXIA =
            registerNoneFeatureConfiguration("inflexia_spawn", TempEndFeatures.INFLEXIA.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FLAMMALIX =
            registerNoneFeatureConfiguration("flammalix_spawn", TempEndFeatures.FLAMMALIX.get());

    /** BUSHES **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PYTHADENDRON_BUSH =
            registerNoneFeatureConfiguration("pythadendron_bush_spawn", TempEndFeatures.PYTHADENDRON_BUSH.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> DRAGON_TREE_BUSH =
            registerNoneFeatureConfiguration("dragon_tree_bush_spawn", TempEndFeatures.DRAGON_TREE_BUSH.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TENANEA_BUSH =
            registerNoneFeatureConfiguration("tenanea_bush_spawn", TempEndFeatures.TENANEA_BUSH.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LUMECORN =
            registerNoneFeatureConfiguration("lumecorn_spawn", TempEndFeatures.LUMECORN.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LARGE_AMARANITA =
            registerNoneFeatureConfiguration("large_amaranita_spawn", TempEndFeatures.LARGE_AMARANITA.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LUCERNIA_BUSH =
            registerNoneFeatureConfiguration("lucernia_bush_spawn", TempEndFeatures.LUCERNIA_BUSH.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> LUCERNIA_BUSH_RARE =
            registerNoneFeatureConfiguration("lucernia_bush_rare_spawn", TempEndFeatures.LUCERNIA_BUSH_RARE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> NEON_CACTUS =
            registerNoneFeatureConfiguration("neon_cactus_spawn", TempEndFeatures.NEON_CACTUS.get());

    /** WALL PLANTS **/

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAIL_MOSS =
            registerNoneFeatureConfiguration("tail_moss_spawn", TempEndFeatures.TAIL_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAIL_MOSS_WOOD =
            registerNoneFeatureConfiguration("tail_moss_wood_spawn", TempEndFeatures.TAIL_MOSS_WOOD.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PURPLE_POLYPORE =
            registerNoneFeatureConfiguration("purple_polypore_spawn", TempEndFeatures.PURPLE_POLYPORE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CYAN_MOSS =
            registerNoneFeatureConfiguration("cyan_moss_spawn", TempEndFeatures.CYAN_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CYAN_MOSS_WOOD =
            registerNoneFeatureConfiguration("cyan_moss_wood_spawn", TempEndFeatures.CYAN_MOSS_WOOD.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TWISTED_MOSS =
            registerNoneFeatureConfiguration("twisted_moss_spawn", TempEndFeatures.TWISTED_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TWISTED_MOSS_WOOD =
            registerNoneFeatureConfiguration("twisted_moss_wood_spawn", TempEndFeatures.TWISTED_MOSS_WOOD.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BULB_MOSS =
            registerNoneFeatureConfiguration("bulb_moss_spawn", TempEndFeatures.BULB_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BULB_MOSS_WOOD =
            registerNoneFeatureConfiguration("bulb_moss_wood_spawn", TempEndFeatures.BULB_MOSS_WOOD.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_JELLYSHROOM_WALL =
            registerNoneFeatureConfiguration("small_jellyshroom_wall_spawn", TempEndFeatures.SMALL_JELLYSHROOM_WALL.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_JELLYSHROOM_WOOD =
            registerNoneFeatureConfiguration("small_jellyshroom_wood_spawn", TempEndFeatures.SMALL_JELLYSHROOM_WOOD.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUNGLE_FERN_WOOD =
            registerNoneFeatureConfiguration("jungle_fern_wood_spawn", TempEndFeatures.JUNGLE_FERN_WOOD.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> RUSCUS =
            registerNoneFeatureConfiguration("ruscus_spawn", TempEndFeatures.RUSCUS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> RUSCUS_WOOD =
            registerNoneFeatureConfiguration("ruscus_wood_spawn", TempEndFeatures.RUSCUS_WOOD.get());
    /** WATER **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LOTUS =
            registerNoneFeatureConfiguration("end_lotus_spawn", TempEndFeatures.END_LOTUS.get());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BUBBLE_CORAL =
            registerNoneFeatureConfiguration("bubble_coral_spawn", TempEndFeatures.BUBBLE_CORAL.get());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BUBBLE_CORAL_RARE =
            registerNoneFeatureConfiguration("bubble_coral_rare_spawn", TempEndFeatures.BUBBLE_CORAL_RARE.get());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LILY =
            registerNoneFeatureConfiguration("end_lily_spawn", TempEndFeatures.END_LILY.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_CYAN =
            registerNoneFeatureConfiguration("charnia_cyan_spawn", TempEndFeatures.CHARNIA_CYAN.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_LIGHT_BLUE =
            registerNoneFeatureConfiguration("charnia_light_blue_spawn", TempEndFeatures.CHARNIA_LIGHT_BLUE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_RED_RARE =
            registerNoneFeatureConfiguration("charnia_red_rare_spawn", TempEndFeatures.CHARNIA_RED_RARE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LILY_RARE =
            registerNoneFeatureConfiguration("end_lily_rare_spawn", TempEndFeatures.END_LILY_RARE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LOTUS_LEAF =
            registerNoneFeatureConfiguration("end_lotus_leaf_spawn", TempEndFeatures.END_LOTUS_LEAF.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HYDRALUX =
            registerNoneFeatureConfiguration("hydralux_spawn", TempEndFeatures.HYDRALUX.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> POND_ANEMONE =
            registerNoneFeatureConfiguration("pond_anemone_spawn", TempEndFeatures.POND_ANEMONE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_RED =
            registerNoneFeatureConfiguration("charnia_red_spawn", TempEndFeatures.CHARNIA_RED.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_PURPLE =
            registerNoneFeatureConfiguration("charnia_purple_spawn", TempEndFeatures.CHARNIA_PURPLE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_ORANGE =
            registerNoneFeatureConfiguration("charnia_orange_spawn", TempEndFeatures.CHARNIA_ORANGE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_GREEN =
            registerNoneFeatureConfiguration("charnia_green_spawn", TempEndFeatures.CHARNIA_GREEN.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MENGER_SPONGE =
            registerNoneFeatureConfiguration("menger_sponge_spawn", TempEndFeatures.MENGER_SPONGE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BIOME_ISLAND =
            registerNoneFeatureConfiguration("overworld_island_spawn", TempEndFeatures.BIOME_ISLAND.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FLAMAEA =
            registerNoneFeatureConfiguration("flamaea_spawn", TempEndFeatures.FLAMAEA.get());

    /** VINES **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> DENSE_VINE =
            registerNoneFeatureConfiguration("dense_vine_spawn", TempEndFeatures.DENSE_VINE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BLUE_VINE =
            registerNoneFeatureConfiguration("blue_vine_spawn", TempEndFeatures.BLUE_VINE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TWISTED_VINE =
            registerNoneFeatureConfiguration("twisted_vine_spawn", TempEndFeatures.TWISTED_VINE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BULB_VINE =
            registerNoneFeatureConfiguration("bulb_vine_spawn", TempEndFeatures.BULB_VINE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUNGLE_VINE =
            registerNoneFeatureConfiguration("jungle_vine_spawn", TempEndFeatures.JUNGLE_VINE.get());


    /** LAKES **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LAKE =
            registerNoneFeatureConfiguration("end_lake_spawn", TempEndFeatures.END_LAKE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LAKE_RARE =
            registerNoneFeatureConfiguration("end_lake_rare_spawn", TempEndFeatures.END_LAKE_RARE.get());

    /** TERRAIN **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LAKE_NORMAL =
            registerNoneFeatureConfiguration("end_lake_normal_spawn", TempEndFeatures.END_LAKE_NORMAL.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> DESERT_LAKE =
            registerNoneFeatureConfiguration("desert_lake_spawn", TempEndFeatures.DESERT_LAKE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> ROUND_CAVE =
            registerNoneFeatureConfiguration("round_cave_spawn", TempEndFeatures.ROUND_CAVE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SPIRE =
            registerNoneFeatureConfiguration("spire_spawn", TempEndFeatures.SPIRE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FLOATING_SPIRE =
            registerNoneFeatureConfiguration("floating_spire_spawn", TempEndFeatures.FLOATING_SPIRE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GEYSER =
            registerNoneFeatureConfiguration("geyser_spawn", TempEndFeatures.GEYSER.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SULPHURIC_LAKE =
            registerNoneFeatureConfiguration("sulphuric_lake_spawn", TempEndFeatures.SULPHURIC_LAKE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> ICE_STAR =
            registerNoneFeatureConfiguration("ice_star_spawn", TempEndFeatures.ICE_STAR.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> ICE_STAR_SMALL =
            registerNoneFeatureConfiguration("ice_star_small_spawn", TempEndFeatures.ICE_STAR_SMALL.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SURFACE_VENT =
            registerNoneFeatureConfiguration("surface_vent_spawn", TempEndFeatures.SURFACE_VENT.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SULPHUR_HILL =
            registerNoneFeatureConfiguration("sulphur_hill_spawn", TempEndFeatures.SULPHUR_HILL.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> OBSIDIAN_PILLAR_BASEMENT =
            registerNoneFeatureConfiguration("obsidian_pillar_basement_spawn", TempEndFeatures.OBSIDIAN_PILLAR_BASEMENT.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> OBSIDIAN_BOULDER =
            registerNoneFeatureConfiguration("obsidian_boulder_spawn", TempEndFeatures.OBSIDIAN_BOULDER.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FALLEN_PILLAR =
            registerNoneFeatureConfiguration("fallen_pillar_spawn", TempEndFeatures.FALLEN_PILLAR.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> UMBRALITH_ARCH =
            registerNoneFeatureConfiguration("umbralith_arch_spawn", TempEndFeatures.UMBRALITH_ARCH.get());

    /** CEIL PLANTS **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_JELLYSHROOM_CEIL =
            registerNoneFeatureConfiguration("small_jellyshroom_ceil_spawn", TempEndFeatures.SMALL_JELLYSHROOM_CEIL.get());

    /** SKY PLANTS **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FILALUX =
            registerNoneFeatureConfiguration("filalux_spawn", TempEndFeatures.FILALUX.get());

    /** BUILDING **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CRASHED_SHIP =
            registerNoneFeatureConfiguration("crashed_ship_spawn", TempEndFeatures.CRASHED_SHIP.get());

    /** MOBS **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SILK_MOTH_NEST =
            registerNoneFeatureConfiguration("silk_moth_spawn", TempEndFeatures.SILK_MOTH_NEST.get());

    private static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> registerNoneFeatureConfiguration(String id, Feature feature) {
        return FeatureUtils.register(id, feature, new NoneFeatureConfiguration());
    }

}