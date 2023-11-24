package ru.betterend.bclib.server;

import ru.betterend.bclib.api.ModIntegrationAPI;
import ru.betterend.bclib.api.PostInitAPI;
import ru.betterend.bclib.api.dataexchange.DataExchangeAPI;

public class BCLibServer {

	public void onInitializeServer() {
		ModIntegrationAPI.registerAll();
		DataExchangeAPI.prepareServerside();
		
		PostInitAPI.postInit(false);
	}
	//FIXME: Move to main class
}
