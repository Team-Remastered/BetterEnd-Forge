package com.teamremastered.betterendforge.integration.byg.features;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.api.features.BCLCommonFeatures;
import com.teamremastered.betterendforge.bclib.world.features.BCLFeature;
import com.teamremastered.betterendforge.integration.Integrations;
import com.teamremastered.betterendforge.integration.byg.BYGBlocks;
import com.teamremastered.betterendforge.world.features.SinglePlantFeature;
import com.teamremastered.betterendforge.world.features.VineFeature;
import com.teamremastered.betterendforge.world.features.WallPlantFeature;
import com.teamremastered.betterendforge.world.features.WallPlantOnLogFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BYGFeatures {
	public static final BCLFeature OLD_BULBIS_TREE = registerVegetation(
		"old_bulbis_tree",
		new OldBulbisTreeFeature(),
		1
	);
	public static final BCLFeature IVIS_SPROUT = registerVegetation(
		"ivis_sprout",
		new SinglePlantFeature(Integrations.BYG.getBlock("ivis_sprout"), 6, 2),
		6
	);
	public static final BCLFeature IVIS_VINE = registerVegetation(
		"ivis_vine",
		new VineFeature(BYGBlocks.IVIS_VINE.get(), 24),
		5
	);
	public static final BCLFeature IVIS_MOSS = registerVegetation(
		"ivis_moss",
		new WallPlantFeature(BYGBlocks.IVIS_MOSS.get(), 6),
		1
	);
	public static final BCLFeature IVIS_MOSS_WOOD = registerVegetation(
		"ivis_moss_wood",
		new WallPlantOnLogFeature(BYGBlocks.IVIS_MOSS.get(), 6),
		15
	);
	public static final BCLFeature NIGHTSHADE_MOSS = registerVegetation(
		"nightshade_moss",
		new WallPlantFeature(BYGBlocks.NIGHTSHADE_MOSS.get(), 5),
		2
	);
	public static final BCLFeature NIGHTSHADE_MOSS_WOOD = registerVegetation(
		"nightshade_moss_wood",
		new WallPlantOnLogFeature(BYGBlocks.NIGHTSHADE_MOSS.get(), 5),
		8
	);
	
	public static final BCLFeature NIGHTSHADE_REDWOOD_TREE = registerVegetation(
		"nightshade_redwood_tree",
		new NightshadeRedwoodTreeFeature(),
		1
	);
	public static final BCLFeature BIG_ETHER_TREE = registerVegetation("big_ether_tree", new BigEtherTreeFeature(), 1);
	
	public static void register() {
	}
	
	private static BCLFeature registerVegetation(String name, Feature<NoneFeatureConfiguration> feature, int density) {
		return BCLCommonFeatures.makeVegetationFeature(BetterEndForge.makeID(name), feature, density);
	}
}