package com.teamremastered.betterendforge.bclib.items.tool;

import com.teamremastered.betterendforge.bclib.api.tag.CommonItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;

public class BaseShearsItem extends ShearsItem {
	public BaseShearsItem(Properties properties) {
		super(properties);
	}

	public static boolean isShear(ItemStack tool){
		return tool.is(Items.SHEARS) | tool.is(CommonItemTags.SHEARS);
	}	//FIXME: Add a way to check if an item is an instance of a shear cause now only vanilla shears work

	public static boolean isShear(ItemStack itemStack, Item item){
		if (item == Items.SHEARS){
			return itemStack.is(item) | itemStack.is(CommonItemTags.SHEARS);
		} else {
			return itemStack.is(item);
		}
	}
}
