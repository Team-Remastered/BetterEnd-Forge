package com.teamremastered.betterendforge.events;

import com.google.common.eventbus.Subscribe;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.client.render.CustomFogRenderer;
import net.minecraft.client.Camera;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientRenderingEvent {

    @SubscribeEvent
    public static void bclib_fogDensity(EntityViewRenderEvent.RenderFogEvent event) {
        Camera pActiveRenderInfo = event.getCamera();
        float pFarPlaneDistance = event.getFarPlaneDistance();
        boolean pNearFog = event.getNearPlaneDistance() > 0; //I have no idea how to use this
        if (CustomFogRenderer.applyFogDensity(pActiveRenderInfo, pFarPlaneDistance, pNearFog) && event.isCancelable()) {
            event.setNearPlaneDistance(CustomFogRenderer.fogStart);
            event.setFarPlaneDistance(CustomFogRenderer.fogEnd);
            event.setCanceled(true);
        }
    }
}