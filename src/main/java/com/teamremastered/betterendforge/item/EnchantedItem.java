package com.teamremastered.betterendforge.item;

import com.teamremastered.betterendforge.bclib.items.ModelProviderItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.registry.EndItems;

public class EnchantedItem extends ModelProviderItem {
	
	private final Item source;
	
	public EnchantedItem(Item source) {
		super(EndItems.makeEndItemSettings().rarity(Rarity.RARE).stacksTo(16));
		this.source = source;
	}
	
	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		ResourceLocation sourceId = Registry.ITEM.getKey(source);
		return ModelsHelper.createItemModel(sourceId);
	}
}
