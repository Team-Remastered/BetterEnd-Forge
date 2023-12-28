package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.BetterEndForge;
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
        }
    }
}