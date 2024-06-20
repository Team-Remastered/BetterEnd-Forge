package com.teamremastered.betterendforge.events;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.entity.*;
import com.teamremastered.betterendforge.registry.EndEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//TODO: Subscribe the event inside a "Register Events" class or something.
//I don't like to subscribe events with the @SubscribeEvent annotation
@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributesEvent {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EndEntities.DRAGONFLY.get(), DragonflyEntity.createMobAttributes().build());
        event.put(EndEntities.END_SLIME.get(), EndSlimeEntity.createMobAttributes().build());
        event.put(EndEntities.END_FISH.get(), EndFishEntity.createMobAttributes().build());
        event.put(EndEntities.SHADOW_WALKER.get(), ShadowWalkerEntity.createMobAttributes().build());
        event.put(EndEntities.CUBOZOA.get(), CubozoaEntity.createMobAttributes().build());
        event.put(EndEntities.SILK_MOTH.get(), SilkMothEntity.createMobAttributes().build());
    }
}