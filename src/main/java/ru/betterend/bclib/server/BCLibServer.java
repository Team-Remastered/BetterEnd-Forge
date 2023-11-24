package ru.betterend.bclib.server;

import ru.betterend.bclib.api.ModIntegrationAPI;
import ru.betterend.bclib.api.PostInitAPI;
public class BCLibServer {

	public void onInitializeServer() {
		ModIntegrationAPI.registerAll();

		PostInitAPI.postInit(false);
	}
	//FIXME: Move to main class
}
