package ru.betterend;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.api.WorldDataAPI;
import ru.betterend.bclib.api.biomes.BiomeAPI;
import ru.betterend.bclib.registry.BlockRegistry;
import ru.betterend.bclib.registry.ItemRegistry;
import ru.betterend.bclib.util.Logger;
import ru.betterend.client.BetterEndClient;
import ru.betterend.config.EndConfig;
import ru.betterend.effects.EndPotions;
import ru.betterend.integration.Integrations;
import ru.betterend.recipe.AlloyingRecipes;
import ru.betterend.recipe.AnvilRecipes;
import ru.betterend.recipe.CraftingRecipes;
import ru.betterend.recipe.FurnaceRecipes;
import ru.betterend.recipe.InfusionRecipes;
import ru.betterend.recipe.SmithingRecipes;
import ru.betterend.registry.EndBiomes;
import ru.betterend.registry.EndBlockEntities;
import ru.betterend.registry.EndEnchantments;
import ru.betterend.registry.EndEntities;
import ru.betterend.registry.EndFeatures;
import ru.betterend.registry.EndParticles;
import ru.betterend.registry.EndPortals;
import ru.betterend.registry.EndSounds;
import ru.betterend.registry.EndStructures;
import ru.betterend.registry.EndTags;
import ru.betterend.util.BonemealPlants;
import ru.betterend.util.LootTableUtil;
import ru.betterend.world.generator.GeneratorOptions;
import ru.betterend.world.generator.TerrainGenerator;

@Mod(BetterEndForge.MOD_ID)
public class BetterEndForge {
	public static final String MOD_ID = "betterendforge";
	public static final Logger LOGGER = new Logger(MOD_ID);
	public static final String CONFIG_FILE = String.format("%s.toml", MOD_ID);
	public static final boolean RUNS_FALL_FLYING_LIB = ModList.get().isLoaded("fallflyinglib");

	public void BetterEndForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BCLib.loadBCLib();
		WorldDataAPI.registerModCache(MOD_ID);
		ItemRegistry.initRegister(modEventBus);
		BlockRegistry.initRegister(modEventBus);
		EndBlockEntities.initRegister(modEventBus);
		EndPortals.loadPortals();
		EndSounds.register();
		EndBlockEntities.register();
		EndFeatures.register();
		EndEntities.register(); //probably wrong
		EndEntities.register(modEventBus);
		EndParticles.register(modEventBus);
		EndSounds.register(modEventBus);
		EndBiomes.register();
		EndTags.register();
		EndEnchantments.register();
		EndPotions.register();
		CraftingRecipes.register();
		FurnaceRecipes.register();
		AlloyingRecipes.register();
		AnvilRecipes.register();
		SmithingRecipes.register();
		InfusionRecipes.register();
		EndStructures.register();
		BonemealPlants.init();
		GeneratorOptions.init();
		LootTableUtil.init();
		// FabricLoader.getInstance().getEntrypoints("betterend", BetterEndPlugin.class).forEach(BetterEndPlugin::register);
		Integrations.init();
		EndConfig.load();

		if (GeneratorOptions.useNewGenerator()) {
			ru.betterend.bclib.world.generator.GeneratorOptions.setFarEndBiomes(GeneratorOptions.getIslandDistBlock());
			ru.betterend.bclib.world.generator.GeneratorOptions.setEndLandFunction((pos) -> TerrainGenerator.isLand(pos.x, pos.y));
		}
		
		BiomeAPI.registerEndBiomeModification((biomeID, biome) -> {
			if (!biomeID.equals(Biomes.THE_VOID.location())) {
				EndStructures.addBiomeStructures(biomeID, biome);
				EndFeatures.addBiomeFeatures(biomeID, biome);
			}
		});

	}

	private void onClientSetup(FMLClientSetupEvent event) {
		BetterEndClient.initializeClient();
	}

	public static ResourceLocation makeID(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
	
}
