package ru.betterend.world.generator;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
//FIXME: Review this class to add the config options since I just put default values
public class GeneratorOptions {
	private static int biomeSizeCaves;
	private static boolean hasPortal;
	private static boolean hasPillars;
	private static boolean hasDragonFights;
	private static boolean changeChorusPlant;
	private static boolean newGenerator;
	private static boolean generateCentralIsland;
	private static boolean generateObsidianPlatform;
	private static int endCityFailChance;
	public static LayerOptions bigOptions;
	public static LayerOptions mediumOptions;
	public static LayerOptions smallOptions;
	private static boolean changeSpawn;
	private static BlockPos spawn;
	private static boolean replacePortal;
	private static boolean replacePillars;
	private static int islandDistChunk;
	private static boolean directSpikeHeight;
	private static int circleRadius = 1000;
	private static int circleRadiusSqr;
	
	public static void init() {
		biomeSizeCaves = 32;
		hasPortal = true;
		hasPillars = true;
		hasDragonFights = true;
		changeChorusPlant = true;
		newGenerator = true;
		generateCentralIsland = true;
		endCityFailChance = 5;
		generateObsidianPlatform = true;
		bigOptions = new LayerOptions(
			"customGenerator.layers.bigIslands",
			300,
			200,
			70,
			10,
			false
		);
		mediumOptions = new LayerOptions(
			"customGenerator.layers.mediumIslands",
			150,
			100,
			70,
			20,
			true
		);
		smallOptions = new LayerOptions(
			"customGenerator.layers.smallIslands",
			60,
			50,
			70,
			30,
			false
		);
		changeSpawn = false;
		spawn = new BlockPos(
			20,
			65,
			0
		);
		replacePortal = true;
		replacePillars = true;
		circleRadius = 1000;
		circleRadiusSqr = circleRadius * circleRadius;
		islandDistChunk = (circleRadius >> 3); // Twice bigger than normal
	}
	
	public static int getBiomeSizeCaves() {
		return Mth.clamp(biomeSizeCaves, 1, 8192);
	}
	
	public static boolean hasPortal() {
		return hasPortal;
	}
	
	public static boolean hasPillars() {
		return hasPillars;
	}
	
	public static boolean hasDragonFights() {
		return hasDragonFights;
	}
	
	public static boolean changeChorusPlant() {
		return changeChorusPlant;
	}
	
	public static boolean useNewGenerator() {
		return newGenerator;
	}
	
	public static boolean hasCentralIsland() {
		return generateCentralIsland;
	}
	
	public static boolean generateObsidianPlatform() {
		return generateObsidianPlatform;
	}
	
	public static int getEndCityFailChance() {
		return endCityFailChance;
	}
	
	public static boolean changeSpawn() {
		return changeSpawn;
	}
	
	public static BlockPos getSpawn() {
		return spawn;
	}
	
	public static boolean replacePortal() {
		return replacePortal;
	}
	
	public static boolean replacePillars() {
		return replacePillars;
	}
	
	public static int getIslandDistBlock() {
		return circleRadius;
	}
	
	public static int getIslandDistBlockSqr() {
		return circleRadiusSqr;
	}
	
	public static int getIslandDistChunk() {
		return islandDistChunk;
	}
	
	public static void setDirectSpikeHeight() {
		directSpikeHeight = true;
	}
	
	public static boolean isDirectSpikeHeight() {
		boolean height = directSpikeHeight;
		directSpikeHeight = false;
		return height;
	}
}
