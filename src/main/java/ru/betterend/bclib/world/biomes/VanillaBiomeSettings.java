package ru.betterend.bclib.world.biomes;


public class VanillaBiomeSettings extends BCLBiomeSettings{
	public static class Builder extends BCLBiomeSettings.CommonBuilder<VanillaBiomeSettings, Builder>{
		public Builder(){
			super(new VanillaBiomeSettings());
		}
	}
	
	public static Builder createVanilla(){
		return new Builder();
	}
}
