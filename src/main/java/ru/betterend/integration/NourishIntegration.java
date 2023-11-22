package ru.betterend.integration;

import net.minecraft.world.item.Item;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.api.tag.TagAPI.TagLocation;
import ru.betterend.bclib.integration.ModIntegration;
import ru.betterend.registry.EndItems;

public class NourishIntegration extends ModIntegration {
	public NourishIntegration() {
		super("nourish");
	}
	
	@Override
	public void init() {
		TagLocation<Item> fats = TagLocation.of(getItemTag("fats"));
		TagLocation<Item> fruit = TagLocation.of(getItemTag("fruit"));
		TagLocation<Item> protein = TagLocation.of(getItemTag("protein"));
		TagLocation<Item> sweets = TagLocation.of(getItemTag("sweets"));
		
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
