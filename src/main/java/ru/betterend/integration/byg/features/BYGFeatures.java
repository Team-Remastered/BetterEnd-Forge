package ru.betterend.integration.byg.features;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import ru.betterend.bclib.api.features.BCLCommonFeatures;
import ru.betterend.bclib.world.features.BCLFeature;
import ru.betterend.BetterEndForge;
import ru.betterend.integration.Integrations;
import ru.betterend.integration.byg.BYGBlocks;
import ru.betterend.world.features.SinglePlantFeature;
import ru.betterend.world.features.VineFeature;
import ru.betterend.world.features.WallPlantFeature;
import ru.betterend.world.features.WallPlantOnLogFeature;

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
		new VineFeature(BYGBlocks.IVIS_VINE, 24),
		5
	);
	public static final BCLFeature IVIS_MOSS = registerVegetation(
		"ivis_moss",
		new WallPlantFeature(BYGBlocks.IVIS_MOSS, 6),
		1
	);
	public static final BCLFeature IVIS_MOSS_WOOD = registerVegetation(
		"ivis_moss_wood",
		new WallPlantOnLogFeature(BYGBlocks.IVIS_MOSS, 6),
		15
	);
	public static final BCLFeature NIGHTSHADE_MOSS = registerVegetation(
		"nightshade_moss",
		new WallPlantFeature(BYGBlocks.NIGHTSHADE_MOSS, 5),
		2
	);
	public static final BCLFeature NIGHTSHADE_MOSS_WOOD = registerVegetation(
		"nightshade_moss_wood",
		new WallPlantOnLogFeature(BYGBlocks.NIGHTSHADE_MOSS, 5),
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