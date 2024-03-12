package com.teamremastered.betterendforge.registry.world;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.api.features.BCLCommonFeatures;
import com.teamremastered.betterendforge.bclib.api.features.BCLFeatureBuilder;
import com.teamremastered.betterendforge.bclib.util.JsonFactory;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiome;
import com.teamremastered.betterendforge.bclib.world.features.BCLFeature;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import com.teamremastered.betterendforge.bclib.world.features.ListFeature;
import com.teamremastered.betterendforge.bclib.world.features.NBTStructureFeature;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.biome.land.UmbraValleyBiome;
import com.teamremastered.betterendforge.world.features.bushes.BushFeature;
import com.teamremastered.betterendforge.world.features.bushes.BushWithOuterFeature;
import com.teamremastered.betterendforge.world.features.bushes.LargeAmaranitaFeature;
import com.teamremastered.betterendforge.world.features.bushes.Lumecorn;
import com.teamremastered.betterendforge.world.features.bushes.TenaneaBushFeature;
import com.teamremastered.betterendforge.world.features.terrain.caves.RoundCaveFeature;
import com.teamremastered.betterendforge.world.features.terrain.caves.TunelCaveFeature;
import com.teamremastered.betterendforge.world.features.trees.DragonTreeFeature;
import com.teamremastered.betterendforge.world.features.trees.GiganticAmaranitaFeature;
import com.teamremastered.betterendforge.world.features.trees.HelixTreeFeature;
import com.teamremastered.betterendforge.world.features.trees.JellyshroomFeature;
import com.teamremastered.betterendforge.world.features.trees.LacugroveFeature;
import com.teamremastered.betterendforge.world.features.trees.LucerniaFeature;
import com.teamremastered.betterendforge.world.features.trees.MossyGlowshroomFeature;
import com.teamremastered.betterendforge.world.features.trees.PythadendronTreeFeature;
import com.teamremastered.betterendforge.world.features.trees.TenaneaFeature;
import com.teamremastered.betterendforge.world.features.trees.UmbrellaTreeFeature;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import com.teamremastered.betterendforge.complexmaterials.StoneMaterial;
import com.teamremastered.betterendforge.world.features.BiomeIslandFeature;
import com.teamremastered.betterendforge.world.features.BlueVineFeature;
import com.teamremastered.betterendforge.world.features.BuildingListFeature;
import com.teamremastered.betterendforge.world.features.CavePumpkinFeature;
import com.teamremastered.betterendforge.world.features.CharniaFeature;
import com.teamremastered.betterendforge.world.features.CrashedShipFeature;
import com.teamremastered.betterendforge.world.features.DoublePlantFeature;
import com.teamremastered.betterendforge.world.features.EndLilyFeature;
import com.teamremastered.betterendforge.world.features.EndLotusFeature;
import com.teamremastered.betterendforge.world.features.EndLotusLeafFeature;
import com.teamremastered.betterendforge.world.features.FilaluxFeature;
import com.teamremastered.betterendforge.world.features.GlowPillarFeature;
import com.teamremastered.betterendforge.world.features.HydraluxFeature;
import com.teamremastered.betterendforge.world.features.LanceleafFeature;
import com.teamremastered.betterendforge.world.features.MengerSpongeFeature;
import com.teamremastered.betterendforge.world.features.NeonCactusFeature;
import com.teamremastered.betterendforge.world.features.SilkMothNestFeature;
import com.teamremastered.betterendforge.world.features.SingleInvertedScatterFeature;
import com.teamremastered.betterendforge.world.features.SinglePlantFeature;
import com.teamremastered.betterendforge.world.features.UnderwaterPlantFeature;
import com.teamremastered.betterendforge.world.features.VineFeature;
import com.teamremastered.betterendforge.world.features.WallPlantFeature;
import com.teamremastered.betterendforge.world.features.WallPlantOnLogFeature;
import com.teamremastered.betterendforge.world.features.terrain.ArchFeature;
import com.teamremastered.betterendforge.world.features.terrain.BigAuroraCrystalFeature;
import com.teamremastered.betterendforge.world.features.terrain.DesertLakeFeature;
import com.teamremastered.betterendforge.world.features.terrain.EndLakeFeature;
import com.teamremastered.betterendforge.world.features.terrain.FallenPillarFeature;
import com.teamremastered.betterendforge.world.features.terrain.FloatingSpireFeature;
import com.teamremastered.betterendforge.world.features.terrain.GeyserFeature;
import com.teamremastered.betterendforge.world.features.terrain.IceStarFeature;
import com.teamremastered.betterendforge.world.features.terrain.ObsidianBoulderFeature;
import com.teamremastered.betterendforge.world.features.terrain.ObsidianPillarBasementFeature;
import com.teamremastered.betterendforge.world.features.terrain.OreLayerFeature;
import com.teamremastered.betterendforge.world.features.terrain.SingleBlockFeature;
import com.teamremastered.betterendforge.world.features.terrain.SmaragdantCrystalFeature;
import com.teamremastered.betterendforge.world.features.terrain.SpireFeature;
import com.teamremastered.betterendforge.world.features.terrain.StalactiteFeature;
import com.teamremastered.betterendforge.world.features.terrain.SulphurHillFeature;
import com.teamremastered.betterendforge.world.features.terrain.SulphuricCaveFeature;
import com.teamremastered.betterendforge.world.features.terrain.SulphuricLakeFeature;
import com.teamremastered.betterendforge.world.features.terrain.SurfaceVentFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.io.InputStream;
import java.util.List;

public class EndFeatures {

	// Trees //

	// Bushes //

	// Plants //

	// Vines //

	// Ceil plants

	// Sky plants

	// Wall Plants //
	//	public static final BCLFeature AURANT_POLYPORE = registerVegetation("aurant_polypore", new WallPlantOnLogFeature(EndBlocks.AURANT_POLYPORE.get(), 3), 5);

	// Water //

	// Terrain //

	//	public static final BCLFeature THIN_UMBRALITH_ARCH = registerChanced("thin_umbralith_arch", new ThinArchFeature(EndBlocks.UMBRALITH.stone.get()), 15);

	// Ores //
	public static final BCLFeature THALLASIUM_ORE = registerOre("thallasium_ore", EndBlocks.THALLASIUM.ore.get(), 24, 8);
	public static final BCLFeature ENDER_ORE = registerOre("ender_ore", EndBlocks.ENDER_ORE.get(), 12, 4);
	public static final BCLFeature AMBER_ORE = registerOre("amber_ore", EndBlocks.AMBER_ORE.get(), 60, 6);
	public static final BCLFeature DRAGON_BONE_BLOCK_ORE = registerOre("dragon_bone_ore", EndBlocks.DRAGON_BONE_BLOCK.get(), 24, 8);
	public static final BCLFeature VIOLECITE_LAYER = registerLayer("violecite_layer", EndBlocks.VIOLECITE, 15, 16, 128, 8);
	public static final BCLFeature FLAVOLITE_LAYER = registerLayer("flavolite_layer", EndBlocks.FLAVOLITE, 12, 16, 128, 6);

	// Buildings

	// Mobs

	// Caves
	public static final DefaultFeature SMARAGDANT_CRYSTAL = new SmaragdantCrystalFeature();
	public static final DefaultFeature SMARAGDANT_CRYSTAL_SHARD = new SingleBlockFeature(EndBlocks.SMARAGDANT_CRYSTAL_SHARD.get());
	public static final DefaultFeature BIG_AURORA_CRYSTAL = new BigAuroraCrystalFeature();
	public static final DefaultFeature CAVE_BUSH = new BushFeature(EndBlocks.CAVE_BUSH.get(), EndBlocks.CAVE_BUSH.get());
	public static final DefaultFeature CAVE_GRASS = new SingleBlockFeature(EndBlocks.CAVE_GRASS.get());
	public static final DefaultFeature RUBINEA = new VineFeature(EndBlocks.RUBINEA.get(), 8);
	public static final DefaultFeature MAGNULA = new VineFeature(EndBlocks.MAGNULA.get(), 8);
	public static final DefaultFeature END_STONE_STALACTITE = new StalactiteFeature(
		true,
		EndBlocks.END_STONE_STALACTITE.get(),
		Blocks.END_STONE
	);
	public static final DefaultFeature END_STONE_STALAGMITE = new StalactiteFeature(
		false,
		EndBlocks.END_STONE_STALACTITE.get(),
		Blocks.END_STONE
	);
	public static final DefaultFeature END_STONE_STALACTITE_CAVEMOSS = new StalactiteFeature(
		true,
		EndBlocks.END_STONE_STALACTITE_CAVEMOSS.get(),
		Blocks.END_STONE,
		EndBlocks.CAVE_MOSS.get()
	);
	public static final DefaultFeature END_STONE_STALAGMITE_CAVEMOSS = new StalactiteFeature(
		false,
		EndBlocks.END_STONE_STALACTITE_CAVEMOSS.get(),
		EndBlocks.CAVE_MOSS.get()
	);
	public static final DefaultFeature CAVE_PUMPKIN = new CavePumpkinFeature();
	
	private static BCLFeature registerVegetation(String name, Feature<NoneFeatureConfiguration> feature, int density) {
		ResourceLocation id = BetterEndForge.makeID(name);
		return BCLFeatureBuilder.start(id, feature).countLayersMax(density).onlyInBiome().build();
	}
	
	private static BCLFeature registerRawGen(String name, Feature<NoneFeatureConfiguration> feature, int chance) {
		return BCLCommonFeatures.makeChancedFeature(BetterEndForge.makeID(name), Decoration.RAW_GENERATION, feature, chance);
	}
	
	private static BCLFeature registerLake(String name, Feature<NoneFeatureConfiguration> feature, int chance) {
		return BCLCommonFeatures.makeChancedFeature(BetterEndForge.makeID(name), Decoration.LAKES, feature, chance);
	}
	
	private static BCLFeature registerChanced(String name, Feature<NoneFeatureConfiguration> feature, int chance) {
		return BCLCommonFeatures.makeChancedFeature(BetterEndForge.makeID(name), Decoration.SURFACE_STRUCTURES, feature, chance);
	}
	
	private static BCLFeature registerOre(String name, Block blockOre, int veins, int veinSize) {
		return BCLCommonFeatures.makeOreFeature(BetterEndForge.makeID(name), blockOre, Blocks.END_STONE, veins, veinSize, 0, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(128)), false);
	}
	
	private static BCLFeature registerLayer(String name, Block block, float radius, int minY, int maxY, int count) {
		OreLayerFeature layer = new OreLayerFeature(block.defaultBlockState(), radius, minY, maxY);
		return BCLFeatureBuilder
				.start(BetterEndForge.makeID(name), layer)
				.decoration( GenerationStep.Decoration.UNDERGROUND_ORES)
				.modifier(CountPlacement.of(count))
				.build();
	}
	
	private static BCLFeature registerLayer(String name, StoneMaterial material, float radius, int minY, int maxY, int count) {
		return registerLayer(name, material.stone.get(), radius, minY, maxY, count);
	}
	
	private static BCLFeature getBiomeStructures(BCLBiome biome) {
		String ns = biome.getID().getNamespace();
		String nm = biome.getID().getPath();
		ResourceLocation id = new ResourceLocation(ns, nm + "_structures");
		
		if (BuiltinRegistries.PLACED_FEATURE.containsKey(id)) {
			PlacedFeature placed = BuiltinRegistries.PLACED_FEATURE.get(id);
			Feature<?> feature = Registry.FEATURE.get(id);
			return BCLFeatureBuilder
					.start(id, feature)
					.decoration(Decoration.SURFACE_STRUCTURES)
					.modifier(placed.placement())
					.build(placed.feature().value().config());
		}
		
		String path = "/data/" + ns + "/structures/biome/" + nm + "/";
		InputStream inputstream = EndFeatures.class.getResourceAsStream(path + "structures.json");
		if (inputstream != null) {
			JsonObject obj = JsonFactory.getJsonObject(inputstream);
			JsonArray structures = obj.getAsJsonArray("structures");
			if (structures != null) {
				List<ListFeature.StructureInfo> list = Lists.newArrayList();
				structures.forEach((entry) -> {
					JsonObject e = entry.getAsJsonObject();
					String structure = path + e.get("nbt").getAsString() + ".nbt";
					NBTStructureFeature.TerrainMerge terrainMerge = NBTStructureFeature.TerrainMerge.getFromString(e.get("terrainMerge").getAsString());
					int offsetY = e.get("offsetY").getAsInt();
					list.add(new ListFeature.StructureInfo(structure, offsetY, terrainMerge));
				});
				if (!list.isEmpty()) {
					return BCLCommonFeatures.makeChancedFeature(
						new ResourceLocation(ns, nm + "_structures"),
						Decoration.SURFACE_STRUCTURES,
						new BuildingListFeature(list, Blocks.END_STONE.defaultBlockState()),
						10
					);
				}
			}
		}
		return null;
	}

}
