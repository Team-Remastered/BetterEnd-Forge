package ru.betterend.config;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.config.EntryConfig;
import ru.betterend.bclib.config.IdConfig;
import ru.betterend.bclib.config.PathConfig;
import ru.betterend.BetterEndForge;

public class Configs {
	public static final PathConfig ENTITY_CONFIG = new PathConfig(BetterEndForge.MOD_ID, "entities");
	public static final PathConfig BLOCK_CONFIG = new PathConfig(BetterEndForge.MOD_ID, "blocks");
	public static final PathConfig ITEM_CONFIG = new PathConfig(BetterEndForge.MOD_ID, "items");
	public static final IdConfig BIOME_CONFIG = new EntryConfig(BetterEndForge.MOD_ID, "biomes");
	public static final PathConfig GENERATOR_CONFIG = new PathConfig(BetterEndForge.MOD_ID, "generator", false);
	public static final PathConfig RECIPE_CONFIG = new PathConfig(BetterEndForge.MOD_ID, "recipes");
	public static final PathConfig ENCHANTMENT_CONFIG = new PathConfig(BetterEndForge.MOD_ID, "enchantments");
	
	@OnlyIn(Dist.CLIENT)
	public static final PathConfig CLENT_CONFIG = new PathConfig(BetterEndForge.MOD_ID, "client", false);
	
	public static void saveConfigs() {
		ENTITY_CONFIG.saveChanges();
		BLOCK_CONFIG.saveChanges();
		BIOME_CONFIG.saveChanges();
		ITEM_CONFIG.saveChanges();
		GENERATOR_CONFIG.saveChanges();
		RECIPE_CONFIG.saveChanges();
		ENCHANTMENT_CONFIG.saveChanges();
		
		if (BCLib.isClient()) {
			CLENT_CONFIG.saveChanges();
		}
	}
}
