package ru.betterend.bclib.client;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.api.ModIntegrationAPI;
import ru.betterend.bclib.api.PostInitAPI;
import ru.betterend.bclib.api.dataexchange.DataExchangeAPI;
import ru.betterend.bclib.client.models.CustomModelBakery;
import ru.betterend.bclib.registry.BaseBlockEntityRenders;

public class BCLibClient {
	public static CustomModelBakery modelBakery;

	public void onInitializeClient() {
		ModIntegrationAPI.registerAll();
		DataExchangeAPI.prepareClientside();
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
