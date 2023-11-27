package com.teamremastered.betterendforge.bclib.interfaces;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

public interface ItemModelProvider {
	@OnlyIn(Dist.CLIENT)
	default BlockModel getItemModel(ResourceLocation resourceLocation) {
		return ModelsHelper.createItemModel(resourceLocation);
	}
}