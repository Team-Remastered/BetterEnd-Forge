package com.teamremastered.betterendforge.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;

public class CreativeTabs {
	public static final CreativeModeTab TAB_BLOCKS;
	public static final CreativeModeTab TAB_ITEMS;

	/**
	 * We can't organize the blocks and items inside the TABs like it is done
	 * on the Fabric version in 1.18.2 AFAIK, so we just have to live with it.
    **/
	static {
		 TAB_BLOCKS = new CreativeModeTab(BetterEndForge.MOD_ID) {
			@Override
			public @NotNull ItemStack makeIcon() {
				return new ItemStack(EndBlocks.END_MYCELIUM.get());
			}
		};

		 TAB_ITEMS = new CreativeModeTab(BetterEndForge.MOD_ID) {
			@Override
			public @NotNull ItemStack makeIcon() {
				return new ItemStack(EndItems.ETERNAL_CRYSTAL.get());
			}
		};
	}
}