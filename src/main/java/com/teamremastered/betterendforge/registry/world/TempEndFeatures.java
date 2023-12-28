package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import com.teamremastered.betterendforge.world.features.trees.MossyGlowshroomFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TempEndFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BetterEndForge.MOD_ID);

    public static void initRegister(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }

    public static final RegistryObject<DefaultFeature> MOSSY_GLOWSHROOM = FEATURES.register("mossy_glowshroom", MossyGlowshroomFeature::new);

}