package ru.betterend.registry;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.betterend.BetterEndForge;
import ru.betterend.client.render.PedestalItemRenderer;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class EndBlockEntityRenders {
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(EndBlockEntities.PEDESTAL.get(), PedestalItemRenderer::new);
		event.registerBlockEntityRenderer(EndBlockEntities.ETERNAL_PEDESTAL.get(), PedestalItemRenderer::new);
		event.registerBlockEntityRenderer(EndBlockEntities.INFUSION_PEDESTAL.get(), PedestalItemRenderer::new);
	}

}
