package com.teamremastered.betterendforge.bclib.api;

import com.google.common.collect.Lists;
import com.teamremastered.betterendforge.bclib.integration.ModIntegration;
import net.minecraftforge.fml.ModList;

import java.util.List;

public class ModIntegrationAPI {
	private static final List<ModIntegration> INTEGRATIONS = Lists.newArrayList();
	private static final boolean HAS_CANVAS = ModList.get().isLoaded("canvas");
	
	/**
	 * Registers mod integration
	 *
	 * @param integration
	 * @return
	 */
	public static ModIntegration register(ModIntegration integration) {
		INTEGRATIONS.add(integration);
		return integration;
	}
	
	/**
	 * Get all registered mod integrations.
	 *
	 * @return {@link List} of {@link ModIntegration}.
	 */
	public static List<ModIntegration> getIntegrations() {
		return INTEGRATIONS;
	}
	
	/**
	 * Initialize all integrations, only for internal usage.
	 */
	public static void registerAll() {
		INTEGRATIONS.forEach(integration -> {
			if (integration.modIsInstalled()) {
				integration.init();
			}
		});
	}
	
	public static boolean hasCanvas() {
		return HAS_CANVAS;
	}
}
