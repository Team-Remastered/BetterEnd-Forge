package ru.betterend.bclib.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import ru.betterend.bclib.api.ModIntegrationAPI;
import ru.betterend.bclib.api.PostInitAPI;
import ru.betterend.bclib.api.dataexchange.DataExchangeAPI;

public class BCLibServer implements DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		ModIntegrationAPI.registerAll();
		DataExchangeAPI.prepareServerside();
		
		PostInitAPI.postInit(false);
	}
}
