package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID)
public class WorldGenerationEvent {

    @SubscribeEvent
    public static void BiomeLoadingEvent(final BiomeLoadingEvent event) {
        if (event.getName().equals(EndBiomes.FOGGY_MUSHROOMLAND.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.MOSSY_GLOWSHROOM_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.DENSE_VINES_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CREEPING_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRELLA_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BLUE_VINE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CYAN_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CYAN_MOSS_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LILY_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BUBBLE_CORAL_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_CYAN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_LIGHT_BLUE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
        }
    }
}