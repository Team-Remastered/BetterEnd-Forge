package com.teamremastered.betterendforge.integration.byg;

import com.teamremastered.betterendforge.bclib.integration.ModIntegration;
import com.teamremastered.betterendforge.integration.EndBiomeIntegration;

public class BYGIntegration extends ModIntegration implements EndBiomeIntegration {
	public BYGIntegration() {
		super("byg");
	}
	
	@Override
	public void init() {
		/*Block block = Integrations.BYG.getBlock("ivis_phylium");
		if (block != null) {
			TagAPI.addTags(block, CommonBlockTags.END_STONES, CommonBlockTags.GEN_END_STONES);
		}
		BYGBlocks.register();
		BYGFeatures.register();
		BYGBiomes.register();*/
	}
	
	@Override
	public void addBiomes() {
		//BYGBiomes.addBiomes();
	}
}
