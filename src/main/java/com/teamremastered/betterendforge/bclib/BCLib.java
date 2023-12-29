package com.teamremastered.betterendforge.bclib;

import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.world.generator.BCLibEndBiomeSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
import com.teamremastered.betterendforge.bclib.api.WorldDataAPI;
import com.teamremastered.betterendforge.bclib.recipes.CraftingRecipes;
import com.teamremastered.betterendforge.bclib.registry.BaseRegistry;
import com.teamremastered.betterendforge.bclib.util.Logger;
import com.teamremastered.betterendforge.bclib.world.generator.GeneratorOptions;

public class BCLib {
	public static final String MOD_ID = "bclib";
	public static final Logger LOGGER = new Logger(MOD_ID);

	public static void loadBCLib() {
//		BaseRegistry.register();
//		GeneratorOptions.init();
	//	BaseBlockEntities.register();
//	    BCLibEndBiomeSource.register();
		TagAPI.init();
		CraftingRecipes.init();
//		WorldDataAPI.registerModCache(MOD_ID);
//		AnvilRecipe.register();
		
//		BCLibPatch.register();
	}

	public static boolean isDevEnvironment() {
		return !FMLEnvironment.production;
	}

	public static boolean isClient() {
		return FMLEnvironment.dist == Dist.CLIENT;
	}
	
	public static ResourceLocation makeID(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
