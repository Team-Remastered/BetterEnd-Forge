package com.teamremastered.betterendforge.item;

import com.teamremastered.betterendforge.bclib.items.ModelProviderItem;
import com.teamremastered.betterendforge.interfaces.IBCLItemModelProvider;
import net.minecraft.world.level.block.Block;
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
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class EnchantedItem extends ModelProviderItem implements IBCLItemModelProvider {
	
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

	@Override
	public void createGeneratedData(ItemModelProvider modelProvider, Item item) {
		modelProvider.withExistingParent(item.getRegistryName().getPath(), source.getRegistryName());
	}
}