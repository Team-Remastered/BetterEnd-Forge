package com.teamremastered.betterendforge.registry.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EndPlacedFeatures {

    public static final Holder<PlacedFeature> MOSSY_GLOWSHROOM_PLACED = PlacementUtils.register("mossy_glowshroom_placed",
            EndConfiguredFeatures.MOSSY_GLOWSHROOM_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.1f, 2)));
}