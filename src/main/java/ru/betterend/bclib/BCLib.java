package ru.betterend.bclib;

import net.minecraftforge.api.distmarker.Dist;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import ru.betterend.bclib.api.WorldDataAPI;
import ru.betterend.bclib.api.dataexchange.DataExchangeAPI;
import ru.betterend.bclib.api.dataexchange.handler.autosync.Chunker;
import ru.betterend.bclib.api.dataexchange.handler.autosync.HelloClient;
import ru.betterend.bclib.api.dataexchange.handler.autosync.HelloServer;
import ru.betterend.bclib.api.dataexchange.handler.autosync.RequestFiles;
import ru.betterend.bclib.api.dataexchange.handler.autosync.SendFiles;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.config.Configs;
import ru.betterend.bclib.recipes.AnvilRecipe;
import ru.betterend.bclib.recipes.CraftingRecipes;
import ru.betterend.bclib.registry.BaseBlockEntities;
import ru.betterend.bclib.registry.BaseRegistry;
import ru.betterend.bclib.util.Logger;
import ru.betterend.bclib.world.generator.BCLibEndBiomeSource;
import ru.betterend.bclib.world.generator.BCLibNetherBiomeSource;
import ru.betterend.bclib.world.generator.GeneratorOptions;

import java.util.List;

public class BCLib implements ModInitializer {
	public static final String MOD_ID = "bclib";
	public static final Logger LOGGER = new Logger(MOD_ID);
	
	@Override
	public void onInitialize() {
		BaseRegistry.register();
		GeneratorOptions.init();
		BaseBlockEntities.register();
		BCLibEndBiomeSource.register();
		BCLibNetherBiomeSource.register();
		TagAPI.init();
		CraftingRecipes.init();
		WorldDataAPI.registerModCache(MOD_ID);
		DataExchangeAPI.registerMod(MOD_ID);
		AnvilRecipe.register();
		
		DataExchangeAPI.registerDescriptors(List.of(
			HelloClient.DESCRIPTOR,
			HelloServer.DESCRIPTOR,
			RequestFiles.DESCRIPTOR,
			SendFiles.DESCRIPTOR,
			Chunker.DESCRIPTOR
		));
		
		BCLibPatch.register();
		Configs.save();
	}
	
	public static boolean isDevEnvironment() {
		return FabricLoader.getInstance().isDevelopmentEnvironment();
	}
	
	public static boolean isClient() {
		return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
	}
	
	public static ResourceLocation makeID(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
