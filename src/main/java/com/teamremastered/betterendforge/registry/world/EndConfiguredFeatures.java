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
import java.util.function.Supplier;

public class EndConfiguredFeatures {

    /** TREES **/
    //Not sure if it is necessary to do this
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MOSSY_GLOWSHROOM =
            FeatureUtils.register("mossy_glowshroom", TempEndFeatures.MOSSY_GLOWSHROOM.get(), new NoneFeatureConfiguration());

    public static final Holder<PlacedFeature> MOSSY_GLOWSHROOM_CHECKED = PlacementUtils.register("mossy_glowshroom_checked", MOSSY_GLOWSHROOM,
            PlacementUtils.filteredByBlockSurvival(EndBlocks.MOSSY_GLOWSHROOM_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MOSSY_GLOWSHROOM_SPAWN = FeatureUtils.register("mossy_glowshroom_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(List.of(
            new WeightedPlacedFeature(MOSSY_GLOWSHROOM_CHECKED, 0.5F)), MOSSY_GLOWSHROOM_CHECKED));

    /** FLOWERS **/

}