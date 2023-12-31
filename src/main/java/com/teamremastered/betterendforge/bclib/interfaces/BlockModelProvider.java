package com.teamremastered.betterendforge.bclib.interfaces;

import com.teamremastered.betterendforge.bclib.BCLib;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;

import java.util.Map;
import java.util.Optional;

public interface BlockModelProvider extends ItemModelProvider {
	@OnlyIn(Dist.CLIENT)
	default @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		Optional<String> pattern = PatternsHelper.createBlockSimple(resourceLocation);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@OnlyIn(Dist.CLIENT)
	default UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createBlockSimple(modelId);
	}
	
	@OnlyIn(Dist.CLIENT)
	default void registerBlockModel(ResourceLocation stateId, ResourceLocation modelId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		if (!modelCache.containsKey(modelId)) {
			BlockModel model = getBlockModel(stateId, blockState);
			if (model != null) {
				model.name = modelId.toString();
				modelCache.put(modelId, model);
			}
			else {
				BCLib.LOGGER.warning("Error loading model: {}", modelId);
			}
		}
	}
}
