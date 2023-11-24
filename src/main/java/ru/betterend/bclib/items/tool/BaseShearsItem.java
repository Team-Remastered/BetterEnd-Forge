package ru.betterend.bclib.items.tool;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import ru.betterend.bclib.api.tag.CommonItemTags;
import ru.betterend.bclib.api.tag.TagAPI;

public class BaseShearsItem extends ShearsItem {
	public BaseShearsItem(Properties properties) {
		super(properties);
	}

	public static boolean isShear(ItemStack tool){
		return tool.is(Items.SHEARS) | tool.is(CommonItemTags.SHEARS) || TagAPI.isToolWithMineableTag(tool, FabricMineableTags.SHEARS_MINEABLE);
	}	//FIXME: create a shear tag because I don't think Forge has built-in one

	public static boolean isShear(ItemStack itemStack, Item item){
		if (item == Items.SHEARS){
			return itemStack.is(item) | itemStack.is(CommonItemTags.SHEARS);
		} else {
			return itemStack.is(item);
		}
	}
}
