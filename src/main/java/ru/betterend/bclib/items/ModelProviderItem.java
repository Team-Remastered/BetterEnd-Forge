package ru.betterend.bclib.items;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.interfaces.ItemModelProvider;

public class ModelProviderItem extends Item implements ItemModelProvider {
	public ModelProviderItem(Properties settings) {
		super(settings);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return ModelsHelper.createItemModel(resourceLocation);
	}
}
