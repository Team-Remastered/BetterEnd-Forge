package com.teamremastered.betterendforge.mixin.common;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OverworldBiomes.class)
public interface VanillaBiomeAccess {

    @Invoker("calculateSkyColor")
    static int bef_invokeCalculateSkyColor(float f) {
        throw new Error("Mixin did not apply!");
    }
}