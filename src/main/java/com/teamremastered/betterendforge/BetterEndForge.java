package com.teamremastered.betterendforge;

import com.teamremastered.betterendforge.bclib.BCLib;
import com.teamremastered.betterendforge.bclib.api.WorldDataAPI;
import com.teamremastered.betterendforge.bclib.client.BCLibClient;
import com.teamremastered.betterendforge.bclib.recipes.BCLRecipeProvider;
import com.teamremastered.betterendforge.bclib.util.Logger;
import com.teamremastered.betterendforge.client.BetterEndClient;
import com.teamremastered.betterendforge.config.EndConfig;
import com.teamremastered.betterendforge.registry.EndBlockEntities;
import com.teamremastered.betterendforge.render.BCLBlockStateProvider;
import com.teamremastered.betterendforge.render.BCLItemModelProvider;
import com.teamremastered.betterendforge.util.LootTableUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.teamremastered.betterendforge.registry.EndPotions;
import com.teamremastered.betterendforge.integration.Integrations;
import com.teamremastered.betterendforge.registry.EndAttributes;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndEnchantments;
import com.teamremastered.betterendforge.registry.EndEntities;
import com.teamremastered.betterendforge.registry.EndItems;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndPortals;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.registry.EndStatusEffects;
import com.teamremastered.betterendforge.world.generator.GeneratorOptions;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.io.IOException;

@Mod(BetterEndForge.MOD_ID)
public class BetterEndForge {
	public static final String MOD_ID = "betterendforge";
	public static final Logger LOGGER = new Logger(MOD_ID);
	public static final String CONFIG_FILE = String.format("%s.toml", MOD_ID);
	public static final boolean RUNS_FALL_FLYING_LIB = ModList.get().isLoaded("fallflyinglib");

	public BetterEndForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		EndBlocks.initRegister(modEventBus);
		EndItems.initRegister(modEventBus);
		EndBlockEntities.initRegister(modEventBus);
		EndAttributes.initregister(modEventBus);
		EndSounds.initRegister(modEventBus);
		EndParticles.initRegister(modEventBus);
		EndEntities.initRegister(modEventBus);

		EndEnchantments.initRegister(modEventBus);
		EndStatusEffects.initRegister(modEventBus);
		EndPotions.initRegister(modEventBus);

		BCLib.loadBCLib();
		WorldDataAPI.registerModCache(MOD_ID);
		EndPortals.loadPortals();
//		EndBiomes.register();
//		EndTags.register();
//		CraftingRecipes.register();
//		FurnaceRecipes.register();
//		AlloyingRecipes.register();
//		AnvilRecipes.register();
//		SmithingRecipes.register();
//		InfusionRecipes.register();
//		BonemealPlants.init();
		GeneratorOptions.init();
		LootTableUtil.init();
		// FabricLoader.getInstance().getEntrypoints("betterend", BetterEndPlugin.class).forEach(BetterEndPlugin::register);
		Integrations.init();
		EndConfig.load();

//		if (GeneratorOptions.useNewGenerator()) {
//			ru.betterend.bclib.world.generator.GeneratorOptions.setFarEndBiomes(GeneratorOptions.getIslandDistBlock());
//			ru.betterend.bclib.world.generator.GeneratorOptions.setEndLandFunction((pos) -> TerrainGenerator.isLand(pos.x, pos.y));
//		}
//
//		BiomeAPI.registerEndBiomeModification((biomeID, biome) -> {
//			if (!biomeID.equals(Biomes.THE_VOID.location())) {
//				EndStructures.addBiomeStructures(biomeID, biome);
//				EndFeatures.addBiomeFeatures(biomeID, biome);
//			}
//		});

		modEventBus.addListener(this::onClientSetup);
		modEventBus.addListener(this::onServerSetup);
		modEventBus.addListener(this::generateData);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);

	}

	private void generateData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		generator.addProvider(new BCLRecipeProvider(generator));
		generator.addProvider(new BCLBlockStateProvider(generator, event.getExistingFileHelper()));
		generator.addProvider(new BCLItemModelProvider(generator, MOD_ID ,event.getExistingFileHelper()));
		try {
			generator.run();
		} catch (IOException ex) {
			System.out.println("IO Error on generateData()");
			ex.printStackTrace(System.out);
		}
	}

	private void onClientSetup(FMLClientSetupEvent event) {
		BetterEndClient.initializeClient();
		BCLibClient.onInitializeClient();
	}

	private void onServerSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			EndEntities.registerSpawnPlacement();
		});
	}



	public static ResourceLocation makeID(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
	
}
