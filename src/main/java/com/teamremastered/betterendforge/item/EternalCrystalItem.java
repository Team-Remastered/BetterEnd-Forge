package com.teamremastered.betterendforge.item;

import com.teamremastered.betterendforge.bclib.items.ModelProviderItem;
import net.minecraft.world.item.Rarity;
import com.teamremastered.betterendforge.registry.EndItems;

public class EternalCrystalItem extends ModelProviderItem {
	public EternalCrystalItem() {
		super(EndItems.makeEndItemSettings().stacksTo(16).rarity(Rarity.EPIC));
	}
}