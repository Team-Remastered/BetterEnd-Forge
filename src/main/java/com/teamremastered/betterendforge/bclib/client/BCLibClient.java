package com.teamremastered.betterendforge.bclib.client;

import com.teamremastered.betterendforge.bclib.client.models.CustomModelBakery;
import com.teamremastered.betterendforge.bclib.api.ModIntegrationAPI;
import com.teamremastered.betterendforge.bclib.api.PostInitAPI;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class BCLibClient {
	public static CustomModelBakery modelBakery;

	public static void onInitializeClient() {
		ModIntegrationAPI.registerAll();
//		PostInitAPI.postInit(true); //FIXME: Tries to register inside a locked registry, should use Forge Registry
		modelBakery = new CustomModelBakery();
//		ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> this);
//		ModelLoadingRegistry.INSTANCE.registerVariantProvider(rm -> this);
		//FIXME: Used to register the models
	}
	
//	@Override
//	public @Nullable UnbakedModel loadModelResource(ResourceLocation resourceId, ModelProviderContext context) throws ModelProviderException {
//		return modelBakery.getBlockModel(resourceId);
//	}
//
//	@Override
//	public @Nullable UnbakedModel loadModelVariant(ModelResourceLocation modelId, ModelProviderContext context) throws ModelProviderException {
//		return modelId.getVariant().equals("inventory") ? modelBakery.getItemModel( modelId) : modelBakery.getBlockModel(modelId);
//	}
	//FIXME: Related to items and block models, might be impossible to port to forge
}
