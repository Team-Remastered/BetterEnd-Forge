package ru.betterend.bclib.mixin.client;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.client.render.EmissiveTextureInfo;

import java.io.IOException;

@Mixin(TextureAtlas.class)
public class TextureAtlasMixin {
	private static final int EMISSIVE_ALPHA = 254 << 24;
	private boolean bclib_modifyAtlas;
	
	@Inject(method = "<init>*", at = @At("TAIL"))
	private void bclib_onAtlasInit(ResourceLocation resourceLocation, CallbackInfo info) {
		boolean hasOptifine = ModList.get().isLoaded("optifabric"); //Will probably never be loaded
		bclib_modifyAtlas = !hasOptifine && resourceLocation.toString().equals("minecraft:textures/atlas/blocks.png");
		if (bclib_modifyAtlas) {
			EmissiveTextureInfo.clear();
		}
	}
	
	@Inject(method = "load(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/client/renderer/texture/TextureAtlasSprite$Info;IIIII)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;", at = @At("HEAD"), cancellable = true)
	private void bclib_loadSprite(ResourceManager resourceManager, TextureAtlasSprite.Info spriteInfo, int atlasWidth, int atlasHeight, int maxLevel, int posX, int posY, CallbackInfoReturnable<TextureAtlasSprite> info) {
		if (!bclib_modifyAtlas) {
			return;
		}
		
		ResourceLocation location = spriteInfo.name();
		if (!location.getPath().startsWith("block")) {
			return;
		}
		
		ResourceLocation emissiveLocation = new ResourceLocation(
			location.getNamespace(),
			"textures/" + location.getPath() + "_e.png"
		);
		if (resourceManager.hasResource(emissiveLocation)) {
			NativeImage sprite = null;
			NativeImage emission = null;
			try {
				ResourceLocation spriteLocation = new ResourceLocation(
					location.getNamespace(),
					"textures/" + location.getPath() + ".png"
				);
				Resource resource = resourceManager.getResource(spriteLocation);
				sprite = NativeImage.read(resource.getInputStream());
				resource.close();
				
				resource = resourceManager.getResource(emissiveLocation);
				emission = NativeImage.read(resource.getInputStream());
				resource.close();
			}
			catch (IOException e) {
				BCLib.LOGGER.warning(e.getMessage());
			}
			if (sprite != null && emission != null) {
				int width = Math.min(sprite.getWidth(), emission.getWidth());
				int height = Math.min(sprite.getHeight(), emission.getHeight());
				for (int x = 0; x < width; x++) {
					for (int y = 0; y < height; y++) {
						int argb = emission.getPixelRGBA(x, y);
						int alpha = (argb >> 24) & 255;
						if (alpha > 127) {
							int r = (argb >> 16) & 255;
							int g = (argb >> 8) & 255;
							int b = argb & 255;
							if (r > 0 || g > 0 || b > 0) {
								argb = (argb & 0x00FFFFFF) | EMISSIVE_ALPHA;
								sprite.setPixelRGBA(x, y, argb);
							}
						}
					}
				}
				TextureAtlas self = (TextureAtlas) (Object) this;
				FabricSprite result = new FabricSprite(
					self,
					spriteInfo,
					maxLevel,
					atlasWidth,
					atlasHeight,
					posX,
					posY,
					sprite
				);
				EmissiveTextureInfo.addTexture(location);
				info.setReturnValue(result);
			}
		}
	}
}
