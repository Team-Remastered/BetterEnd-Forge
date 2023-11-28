package com.teamremastered.betterendforge.bclib.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.RecordItem;
import com.teamremastered.betterendforge.bclib.interfaces.ItemModelProvider;

public class BaseDiscItem extends RecordItem implements ItemModelProvider {
	public BaseDiscItem(int comparatorOutput, SoundEvent sound, Properties settings) {
		super(comparatorOutput, sound, settings);
	}
}
