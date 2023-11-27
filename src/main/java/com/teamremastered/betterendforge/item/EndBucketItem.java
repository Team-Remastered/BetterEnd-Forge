package com.teamremastered.betterendforge.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluids;
import com.teamremastered.betterendforge.bclib.interfaces.ItemModelProvider;
import com.teamremastered.betterendforge.registry.EndItems;

public class EndBucketItem extends MobBucketItem implements ItemModelProvider {
	public EndBucketItem(java.util.function.Supplier<? extends EntityType<?>> type) {
		super(type, ()-> Fluids.WATER, ()-> SoundEvents.BUCKET_EMPTY, EndItems.makeEndItemSettings().stacksTo(1));
	}
}