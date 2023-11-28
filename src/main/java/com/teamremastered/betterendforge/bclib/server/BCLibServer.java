package com.teamremastered.betterendforge.bclib.server;

import com.teamremastered.betterendforge.bclib.api.PostInitAPI;
import com.teamremastered.betterendforge.bclib.api.ModIntegrationAPI;

public class BCLibServer {

	public void onInitializeServer() {
		ModIntegrationAPI.registerAll();

		PostInitAPI.postInit(false);
	}
	//FIXME: Move to main class
}
