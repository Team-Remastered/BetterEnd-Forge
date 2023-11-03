package ru.betterend.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import ru.betterend.BetterEnd;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndItems;

public class CreativeTabs {
	public static final CreativeModeTab TAB_BLOCKS;
	public static final CreativeModeTab TAB_ITEMS;

	/**
	 * We can't organize the blocks and items inside the TABs like it is done
	 * on the Fabric version in 1.18.2 AFAIK, so we just have to live with it.
    **/
	static {
		 TAB_BLOCKS = new CreativeModeTab(BetterEnd.MOD_ID) {
			@Override
			public @NotNull ItemStack makeIcon() {
				return new ItemStack(EndBlocks.END_MYCELIUM);
			}
		};

		 TAB_ITEMS = new CreativeModeTab(BetterEnd.MOD_ID) {
			@Override
			public @NotNull ItemStack makeIcon() {
				return new ItemStack(EndItems.ETERNAL_CRYSTAL);
			}
		};
	}
}