package ru.betterend.registry;

import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import ru.betterend.client.render.PedestalItemRenderer;

@OnlyIn(Dist.CLIENT)
public class EndBlockEntityRenders {
	public static void register() {
		BlockEntityRendererRegistry.register(EndBlockEntities.PEDESTAL, PedestalItemRenderer::new);
		BlockEntityRendererRegistry.register(EndBlockEntities.ETERNAL_PEDESTAL, PedestalItemRenderer::new);
		BlockEntityRendererRegistry.register(EndBlockEntities.INFUSION_PEDESTAL, PedestalItemRenderer::new);
	}
}
