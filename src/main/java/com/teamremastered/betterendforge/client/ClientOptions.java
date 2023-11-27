package com.teamremastered.betterendforge.client;

public class ClientOptions {
	private static boolean customSky;
	private static boolean useFogDensity;
	private static boolean blendBiomeMusic;
	private static boolean sulfurWaterColor;
	
	public static void init() {
		customSky = true;
		useFogDensity = true;
		blendBiomeMusic = true;
		sulfurWaterColor = true;
		//FIXME: I just put the default values here, needs to be replaced with config options
	}
	
	public static boolean isCustomSky() {
		return customSky;
	}
	
	public static void setCustomSky(boolean customSky) {
		ClientOptions.customSky = customSky;
	}
	
	public static boolean useFogDensity() {
		return useFogDensity;
	}
	
	public static void setUseFogDensity(boolean useFogDensity) {
		ClientOptions.useFogDensity = useFogDensity;
	}
	
	public static boolean blendBiomeMusic() {
		return blendBiomeMusic;
	}
	
	public static void setBlendBiomeMusic(boolean blendBiomeMusic) {
		ClientOptions.blendBiomeMusic = blendBiomeMusic;
	}
	
	public static boolean useSulfurWaterColor() {
		return sulfurWaterColor;
	}
	
	public static void setSulfurWaterColor(boolean sulfurWaterColor) {
		ClientOptions.sulfurWaterColor = sulfurWaterColor;
	}
}
