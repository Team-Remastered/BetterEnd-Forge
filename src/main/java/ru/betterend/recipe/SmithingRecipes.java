package ru.betterend.recipe;

import net.minecraft.world.item.Items;
import ru.betterend.bclib.recipes.SmithingTableRecipe;
import ru.betterend.BetterEndForge;
import ru.betterend.config.Configs;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndItems;

public class SmithingRecipes {
	
	public static void register() {
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_sword_handle")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_SWORD_HANDLE.get())
						   .setBase(EndBlocks.TERMINITE.ingot)
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_sword")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_SWORD.get())
						   .setBase(EndItems.AETERNIUM_SWORD_BLADE.get())
						   .setAddition(EndItems.AETERNIUM_SWORD_HANDLE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_pickaxe")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_PICKAXE.get())
						   .setBase(EndItems.AETERNIUM_PICKAXE_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_axe")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_AXE.get())
						   .setBase(EndItems.AETERNIUM_AXE_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_shovel")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_SHOVEL.get())
						   .setBase(EndItems.AETERNIUM_SHOVEL_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_hoe")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_HOE.get())
						   .setBase(EndItems.AETERNIUM_HOE_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_hammer")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_HAMMER.get())
						   .setBase(EndItems.AETERNIUM_HAMMER_HEAD.get())
						   .setAddition(EndItems.LEATHER_WRAPPED_STICK.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "netherite_hammer")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.NETHERITE_HAMMER.get())
						   .setBase(EndItems.DIAMOND_HAMMER.get())
						   .setAddition(Items.NETHERITE_INGOT)
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_helmet")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_HELMET.get())
						   .setBase(EndBlocks.TERMINITE.helmet)
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_chestplate")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_CHESTPLATE.get())
						   .setBase(EndBlocks.TERMINITE.chestplate)
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_leggings")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_LEGGINGS.get())
						   .setBase(EndBlocks.TERMINITE.leggings)
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "aeternium_boots")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.AETERNIUM_BOOTS.get())
						   .setBase(EndBlocks.TERMINITE.boots)
						   .setAddition(EndItems.AETERNIUM_FORGED_PLATE.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "thallasium_anvil_updrade")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndBlocks.TERMINITE.anvilBlock.asItem())
						   .setBase(EndBlocks.THALLASIUM.anvilBlock.asItem())
						   .setAddition(EndBlocks.TERMINITE.block)
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "terminite_anvil_updrade")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndBlocks.AETERNIUM_ANVIL.get().asItem())
						   .setBase(EndBlocks.TERMINITE.anvilBlock.asItem())
						   .setAddition(EndItems.AETERNIUM_INGOT.get())
						   .build();
		
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, "armored_elytra")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(EndItems.ARMORED_ELYTRA.get())
						   .setBase(Items.ELYTRA)
						   .setAddition(EndItems.AETERNIUM_INGOT.get())
						   .build();
	}
}
