package com.teamremastered.betterendforge.bclib.registry;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.client.render.BaseChestBlockEntityRenderer;
import com.teamremastered.betterendforge.bclib.client.render.BaseSignBlockEntityRenderer;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class BaseBlockEntityRenders {

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(BaseBlockEntities.CHEST, BaseChestBlockEntityRenderer::new);
		event.registerBlockEntityRenderer(BaseBlockEntities.SIGN, BaseSignBlockEntityRenderer::new);
	}

}
