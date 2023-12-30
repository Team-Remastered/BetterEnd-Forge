package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

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

    /** FLOWERS **/

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CREEPING_MOSS =
            registerNoneFeatureConfiguration("creeping_moss_spawn", TempEndFeatures.CREEPING_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> UMBRELLA_MOSS =
            registerNoneFeatureConfiguration("umbrella_moss_spawn", TempEndFeatures.UMBRELLA_MOSS.get());

    /** WALL PLANTS **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CYAN_MOSS =
            registerNoneFeatureConfiguration("cyan_moss_spawn", TempEndFeatures.CYAN_MOSS.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CYAN_MOSS_WOOD =
            registerNoneFeatureConfiguration("cyan_moss_wood_spawn", TempEndFeatures.CYAN_MOSS_WOOD.get());

    /** WATER **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BUBBLE_CORAL =
            registerNoneFeatureConfiguration("bubble_coral_spawn", TempEndFeatures.BUBBLE_CORAL.get());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LILY =
            registerNoneFeatureConfiguration("end_lily_spawn", TempEndFeatures.END_LILY.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_CYAN =
            registerNoneFeatureConfiguration("charnia_cyan_spawn", TempEndFeatures.CHARNIA_CYAN.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_LIGHT_BLUE =
            registerNoneFeatureConfiguration("charnia_light_blue_spawn", TempEndFeatures.CHARNIA_LIGHT_BLUE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CHARNIA_RED_RARE =
            registerNoneFeatureConfiguration("charnia_red_rare_spawn", TempEndFeatures.CHARNIA_RED_RARE.get());

    /** VINES **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> DENSE_VINE =
            registerNoneFeatureConfiguration("dense_vine_spawn", TempEndFeatures.DENSE_VINE.get());

    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> BLUE_VINE =
            registerNoneFeatureConfiguration("blue_vine_spawn", TempEndFeatures.BLUE_VINE.get());


    /** LAKES **/
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> END_LAKE =
            registerNoneFeatureConfiguration("end_lake_spawn", TempEndFeatures.END_LAKE.get());

    private static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> registerNoneFeatureConfiguration(String id, Feature feature) {
        return FeatureUtils.register(id, feature, new NoneFeatureConfiguration());
    }
}