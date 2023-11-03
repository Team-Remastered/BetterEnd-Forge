package ru.betterend.bclib.registry;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import ru.betterend.bclib.client.render.BaseChestBlockEntityRenderer;
import ru.betterend.bclib.client.render.BaseSignBlockEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class BaseBlockEntityRenders {
	public static void register() {
		BlockEntityRendererRegistry.register(BaseBlockEntities.CHEST, BaseChestBlockEntityRenderer::new);
		BlockEntityRendererRegistry.register(BaseBlockEntities.SIGN, BaseSignBlockEntityRenderer::new);
	}
}
