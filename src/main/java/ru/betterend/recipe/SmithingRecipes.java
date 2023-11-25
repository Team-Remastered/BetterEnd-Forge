package ru.betterend.recipe;

import net.minecraft.world.item.Items;
import ru.betterend.bclib.recipes.SmithingTableRecipe;
import ru.betterend.BetterEndForge;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndItems;

public class SmithingRecipes {
	
	public static void register() {
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_sword_handle")

						   .setResult(EndItems.AETERNIUM_SWORD_HANDLE.get())
						   .setBase(EndBlocks.TERMINITE.ingot.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_sword")

						   .setResult(EndItems.AETERNIUM_SWORD.get())
						   .setBase(EndItems.AETERNIUM_SWORD_BLADE.get())
						   .setAddition(EndItems.AETERNIUM_SWORD_HANDLE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_pickaxe")

						   .setResult(EndItems.AETERNIUM_PICKAXE.get())
						   .setBase(EndItems.AETERNIUM_PICKAXE_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_axe")

						   .setResult(EndItems.AETERNIUM_AXE.get())
						   .setBase(EndItems.AETERNIUM_AXE_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_shovel")

						   .setResult(EndItems.AETERNIUM_SHOVEL.get())
						   .setBase(EndItems.AETERNIUM_SHOVEL_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_hoe")

						   .setResult(EndItems.AETERNIUM_HOE.get())
						   .setBase(EndItems.AETERNIUM_HOE_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_hammer")

						   .setResult(EndItems.AETERNIUM_HAMMER.get())
						   .setBase(EndItems.AETERNIUM_HAMMER_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "netherite_hammer")

						   .setResult(EndItems.NETHERITE_HAMMER.get())
						   .setBase(EndItems.DIAMOND_HAMMER.get())
						   .setAddition(Items.NETHERITE_INGOT)
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_helmet")

						   .setResult(EndItems.AETERNIUM_HELMET.get())
						   .setBase(EndBlocks.TERMINITE.helmet.get())
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_chestplate")

						   .setResult(EndItems.AETERNIUM_CHESTPLATE.get())
						   .setBase(EndBlocks.TERMINITE.chestplate.get())
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_leggings")

						   .setResult(EndItems.AETERNIUM_LEGGINGS.get())
						   .setBase(EndBlocks.TERMINITE.leggings.get())
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_boots")

						   .setResult(EndItems.AETERNIUM_BOOTS.get())
						   .setBase(EndBlocks.TERMINITE.boots.get())
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "thallasium_anvil_updrade")

						   .setResult(EndBlocks.TERMINITE.anvilBlock.get().asItem())
						   .setBase(EndBlocks.THALLASIUM.anvilBlock.get().asItem())
						   .setAddition(EndBlocks.TERMINITE.block.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "terminite_anvil_updrade")

						   .setResult(EndBlocks.AETERNIUM_ANVIL.get().asItem())
						   .setBase(EndBlocks.TERMINITE.anvilBlock.get().asItem())
						   .setAddition(EndItems.AETERNIUM_INGOT.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "armored_elytra")

						   .setResult(EndItems.ARMORED_ELYTRA.get())
						   .setBase(Items.ELYTRA)
						   .setAddition(EndItems.AETERNIUM_INGOT.get())
						   .build();
	}
}
