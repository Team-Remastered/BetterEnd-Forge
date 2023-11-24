package ru.betterend.recipe;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import ru.betterend.bclib.recipes.FurnaceRecipe;
import ru.betterend.BetterEndForge;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndItems;

public class FurnaceRecipes {
	public static void register() {
		FurnaceRecipe.make(
			BetterEndForge.MOD_ID,
			"end_lily_leaf_dried",
			EndItems.END_LILY_LEAF.get(),
			EndItems.END_LILY_LEAF_DRIED.get()
		).checkConfig(Configs.RECIPE_CONFIG).build();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, "end_glass", EndBlocks.ENDSTONE_DUST.get(), Blocks.GLASS)
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .build();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, "end_berry", EndItems.SHADOW_BERRY_RAW.get(), EndItems.SHADOW_BERRY_COOKED.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .buildFoodlike();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, "end_fish", EndItems.END_FISH_RAW.get(), EndItems.END_FISH_COOKED.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .buildFoodlike();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, "slime_ball", EndBlocks.JELLYSHROOM_CAP_PURPLE.get(), Items.SLIME_BALL)
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .build();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, "menger_sponge", EndBlocks.MENGER_SPONGE_WET.get(), EndBlocks.MENGER_SPONGE.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .build();
		FurnaceRecipe.make(
			BetterEndForge.MOD_ID,
			"chorus_mushroom",
			EndItems.CHORUS_MUSHROOM_RAW.get(),
			EndItems.CHORUS_MUSHROOM_COOKED.get()
		).checkConfig(Configs.RECIPE_CONFIG).buildFoodlike();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, "bolux_mushroom", EndBlocks.BOLUX_MUSHROOM.get(), EndItems.BOLUX_MUSHROOM_COOKED.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .buildFoodlike();
	}
}
