package ru.betterend.bclib.mixin.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.FallbackResourceManager;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.api.ModIntegrationAPI;
import ru.betterend.bclib.client.render.EmissiveTextureInfo;

import java.io.IOException;
import java.util.Map;

@Mixin(MultiPackResourceManager.class)
public class MultiPackResourceManagerMixin {
	@Final
	@Shadow
	private Map<String, FallbackResourceManager> namespacedManagers;

	private ResourceLocation bclib_alphaEmissionMaterial = BCLib.makeID("materialmaps/block/alpha_emission.json");

	@Inject(method = "getResource", at = @At("HEAD"), cancellable = true)
	private void bclib_getResource(ResourceLocation resourceLocation, CallbackInfoReturnable<Resource> info) throws IOException {
		if (!ModIntegrationAPI.hasCanvas()) {
			return;
		}
		if (!resourceLocation.getPath().startsWith("materialmaps")) {
			return;
		}
		if (!resourceLocation.getPath().contains("/block/")) {
			return;
		}

		String name = resourceLocation.getPath().replace("materialmaps/block/", "").replace(".json", "");
		ResourceLocation blockID = new ResourceLocation(resourceLocation.getNamespace(), name);

		if (!EmissiveTextureInfo.isEmissiveBlock(blockID)) {
			return;
		}

		ResourceManager resourceManager = this.namespacedManagers.get(resourceLocation.getNamespace());
		if (resourceManager != null && !resourceManager.hasResource(resourceLocation)) {
			info.setReturnValue(resourceManager.getResource(bclib_alphaEmissionMaterial));
		}
	}
}
