package com.teamremastered.betterendforge.bclib.world.generator;

import net.minecraft.util.Mth;

import java.awt.*;
import java.util.function.Function;

public class GeneratorOptions {
	private static int biomeSizeNether;
	private static int biomeVSizeNether;
	private static int biomeSizeEndLand;
	private static int biomeSizeEndVoid;
	private static Function<Point, Boolean> endLandFunction;
	private static boolean customNetherBiomeSource = true;
	private static boolean customEndBiomeSource = true;
	private static boolean addNetherBiomesByCategory = false;
	private static boolean addEndBiomesByCategory = false;
	private static boolean useOldBiomeGenerator = false;
	private static boolean verticalBiomes = true;
	private static long farEndBiomesSqr = 1000000;
	private static boolean fixEndBiomeSource = true;
	private static boolean fixNetherBiomeSource = true;
	
	public static void init() {

		biomeSizeEndLand = 256;
		biomeSizeEndVoid = 256;
		customNetherBiomeSource = true;
		customEndBiomeSource = true;
		addEndBiomesByCategory = false;
		useOldBiomeGenerator = false;
		verticalBiomes = true;
		fixEndBiomeSource = true;
		//FIXME: I just put the default values here, needs to be replaced with config options
	}
	
	public static int getBiomeSizeEndLand() {
		return Mth.clamp(biomeSizeEndLand, 1, 8192);
	}
	
	public static int getBiomeSizeEndVoid() {
		return Mth.clamp(biomeSizeEndVoid, 1, 8192);
	}
	
	public static void setEndLandFunction(Function<Point, Boolean> endLandFunction) {
		GeneratorOptions.endLandFunction = endLandFunction;
	}
	
	public static Function<Point, Boolean> getEndLandFunction() {
		return endLandFunction;
	}
	
	public static long getFarEndBiomes() {
		return farEndBiomesSqr;
	}
	
	/**
	 * Set distance of far End biomes generation, in blocks
	 * @param distance
	 */
	public static void setFarEndBiomes(int distance) {
		GeneratorOptions.farEndBiomesSqr = (long) distance * (long) distance;
	}
	
	/**
	 * Set distance of far End biomes generation, in blocks^2
	 * @param distanceSqr the distance squared
	 */
	public static void setFarEndBiomesSqr(long distanceSqr) {
		GeneratorOptions.farEndBiomesSqr = distanceSqr;
	}
	
	public static boolean customNetherBiomeSource() {
		return customNetherBiomeSource;
	}
	
	public static boolean customEndBiomeSource() {
		return customEndBiomeSource;
	}
	
	public static boolean addNetherBiomesByCategory() {
		return addNetherBiomesByCategory;
	}
	
	public static boolean addEndBiomesByCategory() {
		return addEndBiomesByCategory;
	}
	
	public static boolean useOldBiomeGenerator() {
		return useOldBiomeGenerator;
	}
	
	public static boolean useVerticalBiomes() {
		return verticalBiomes;
	}
	
	public static boolean fixEndBiomeSource() {
		return fixEndBiomeSource;
	}
	
	public static boolean fixNetherBiomeSource() {
		return fixNetherBiomeSource;
	}
}
