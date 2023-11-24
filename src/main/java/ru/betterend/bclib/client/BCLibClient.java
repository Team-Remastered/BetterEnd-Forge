package ru.betterend.bclib.client;

import ru.betterend.bclib.api.ModIntegrationAPI;
import ru.betterend.bclib.api.PostInitAPI;
import ru.betterend.bclib.client.models.CustomModelBakery;

public class BCLibClient {
	public static CustomModelBakery modelBakery;

	public void onInitializeClient() {
		ModIntegrationAPI.registerAll();
		PostInitAPI.postInit(true);
		modelBakery = new CustomModelBakery();
//		ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> this);
//		ModelLoadingRegistry.INSTANCE.registerVariantProvider(rm -> this);
		//FIXME: No idea if this is used
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
	//FIXME: No idea if this is used
}
