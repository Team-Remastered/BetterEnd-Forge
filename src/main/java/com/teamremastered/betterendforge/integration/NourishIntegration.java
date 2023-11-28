package com.teamremastered.betterendforge.integration;

import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.integration.ModIntegration;
import com.teamremastered.betterendforge.registry.EndItems;
import net.minecraft.world.item.Item;

public class NourishIntegration extends ModIntegration {
	public NourishIntegration() {
		super("nourish");
	}
	
	@Override
	public void init() {
		TagAPI.TagLocation<Item> fats = TagAPI.TagLocation.of(getItemTag("fats"));
		TagAPI.TagLocation<Item> fruit = TagAPI.TagLocation.of(getItemTag("fruit"));
		TagAPI.TagLocation<Item> protein = TagAPI.TagLocation.of(getItemTag("protein"));
		TagAPI.TagLocation<Item> sweets = TagAPI.TagLocation.of(getItemTag("sweets"));
		
		TagAPI.addItemTag(fats, EndItems.END_FISH_RAW.get(), EndItems.END_FISH_COOKED.get());
		TagAPI.addItemTag(
			fruit,
			EndItems.SHADOW_BERRY_RAW.get(),
			EndItems.SHADOW_BERRY_COOKED.get(),
			EndItems.BLOSSOM_BERRY.get(),
			EndItems.SHADOW_BERRY_JELLY.get(),
			EndItems.SWEET_BERRY_JELLY.get(),
			EndItems.BLOSSOM_BERRY_JELLY.get(),
			EndItems.AMBER_ROOT_RAW.get(),
			EndItems.CHORUS_MUSHROOM_RAW.get(),
			EndItems.CHORUS_MUSHROOM_COOKED.get(),
			EndItems.BOLUX_MUSHROOM_COOKED.get()
		);
		TagAPI.addItemTag(
			protein,
			EndItems.END_FISH_RAW.get(),
			EndItems.END_FISH_COOKED.get(),
			EndItems.CHORUS_MUSHROOM_COOKED.get(),
			EndItems.BOLUX_MUSHROOM_COOKED.get(),
			EndItems.CAVE_PUMPKIN_PIE.get()
		);
		TagAPI.addItemTag(
			sweets,
			EndItems.SHADOW_BERRY_JELLY.get(),
			EndItems.SWEET_BERRY_JELLY.get(),
			EndItems.BLOSSOM_BERRY_JELLY.get(),
			EndItems.CAVE_PUMPKIN_PIE.get()
		);
	}
}
