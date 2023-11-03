package ru.betterend.bclib.config;

import ru.betterend.bclib.BCLib;

public class GeneratorConfig extends NamedPathConfig {
	public static final ConfigToken<Boolean> USE_OLD_GENERATOR = ConfigToken.Boolean(false, "useOldBiomeGenerator", "options");


	public GeneratorConfig() {
		super(BCLib.MOD_ID, "generator", false);
	}
	
	public boolean useOldGenerator() {
		return get(USE_OLD_GENERATOR);
	}
}
