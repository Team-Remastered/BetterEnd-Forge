package ru.betterend.recipe;

import net.minecraft.world.item.Items;
import ru.betterend.bclib.recipes.AnvilRecipe;
import ru.betterend.item.material.EndToolMaterial;
import ru.betterend.registry.EndItems;

public class AnvilRecipes {
	public static void register() {
		AnvilRecipe.create("ender_pearl_to_dust")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(Items.ENDER_PEARL)
				   .setOutput(EndItems.ENDER_DUST.get())
				   .setToolLevel(4)
				   .setDamage(5)
				   .build();
		AnvilRecipe.create("ender_shard_to_dust")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.ENDER_SHARD.get())
				   .setOutput(EndItems.ENDER_DUST.get())
				   .setToolLevel(0)
				   .setDamage(3)
				   .build();

		int anvilLevel = EndToolMaterial.AETERNIUM.getLevel();
		AnvilRecipe.create("aeternium_axe_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.AETERNIUM_INGOT.get())
				   .setOutput(EndItems.AETERNIUM_AXE_HEAD.get())
				   .setAnvilLevel(anvilLevel)
				   .setToolLevel(anvilLevel)
				   .setDamage(6)
				   .build();
		AnvilRecipe.create("aeternium_pickaxe_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.AETERNIUM_INGOT.get())
				   .setOutput(EndItems.AETERNIUM_PICKAXE_HEAD.get())
				   .setAnvilLevel(anvilLevel)
				   .setToolLevel(anvilLevel)
				   .setDamage(6)
				   .build();
		AnvilRecipe.create("aeternium_shovel_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.AETERNIUM_INGOT.get())
				   .setOutput(EndItems.AETERNIUM_SHOVEL_HEAD.get())
				   .setAnvilLevel(anvilLevel)
				   .setToolLevel(anvilLevel)
				   .setDamage(6)
				   .build();
		AnvilRecipe.create("aeternium_hoe_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.AETERNIUM_INGOT.get())
				   .setOutput(EndItems.AETERNIUM_HOE_HEAD.get())
				   .setAnvilLevel(anvilLevel)
				   .setToolLevel(anvilLevel)
				   .setDamage(6)
				   .build();
		AnvilRecipe.create("aeternium_hammer_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.AETERNIUM_INGOT.get())
				   .setOutput(EndItems.AETERNIUM_HAMMER_HEAD.get())
				   .setAnvilLevel(anvilLevel)
				   .setToolLevel(EndToolMaterial.THALLASIUM.getLevel())
				   .setDamage(6)
				   .build();
		AnvilRecipe.create("aeternium_sword_blade")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.AETERNIUM_INGOT.get())
				   .setOutput(EndItems.AETERNIUM_SWORD_BLADE.get())
				   .setAnvilLevel(anvilLevel)
				   .setToolLevel(anvilLevel)
				   .setDamage(6)
				   .build();
		AnvilRecipe.create("aeternium_forged_plate")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(EndItems.AETERNIUM_INGOT.get())
				   .setOutput(EndItems.AETERNIUM_FORGED_PLATE.get())
				   .setAnvilLevel(anvilLevel)
				   .setToolLevel(anvilLevel)
				   .setDamage(6)
				   .build();
	}
}
