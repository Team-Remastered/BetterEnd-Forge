package ru.betterend.bclib.interfaces;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;

public interface CustomItemProvider {
	/**
	 * Used to replace default Block Item when block is registered.
	 *
	 * @return {@link BlockItem}
	 */
	BlockItem getCustomItem(ResourceLocation blockID, Item.Properties settings);
}
