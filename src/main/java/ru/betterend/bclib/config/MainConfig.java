package ru.betterend.bclib.config;

import ru.betterend.bclib.BCLib;

public class MainConfig  extends NamedPathConfig {
	public static final ConfigToken<Boolean> APPLY_PATCHES = ConfigToken.Boolean(true, "applyPatches", Configs.MAIN_PATCH_CATEGORY);

	@ConfigUI(leftPadding = 8)
	public static final ConfigToken<Boolean> REPAIR_BIOMES = DependendConfigToken.Boolean(true, "repairBiomesOnLoad", Configs.MAIN_PATCH_CATEGORY, (config) -> config.get(APPLY_PATCHES));
	
	public MainConfig() {
		super(BCLib.MOD_ID, "main", true, true);
	}
	
	public boolean applyPatches() {
		return get(APPLY_PATCHES);
	}
	
	public boolean repairBiomes() {
		return get(REPAIR_BIOMES);
	}
}
