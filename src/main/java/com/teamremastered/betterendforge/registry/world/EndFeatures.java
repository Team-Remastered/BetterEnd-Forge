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
	public static final BCLFeature PYTHADENDRON_TREE = registerVegetation("pythadendron_tree", new PythadendronTreeFeature(), 1);
	public static final BCLFeature LACUGROVE = registerVegetation("lacugrove", new LacugroveFeature(), 4);
	public static final BCLFeature DRAGON_TREE = registerVegetation("dragon_tree", new DragonTreeFeature(), 2);
	public static final BCLFeature TENANEA = registerVegetation("tenanea", new TenaneaFeature(), 2);
	public static final BCLFeature HELIX_TREE = registerVegetation("helix_tree", new HelixTreeFeature(), 1);
	public static final BCLFeature UMBRELLA_TREE = registerVegetation("umbrella_tree", new UmbrellaTreeFeature(), 2);
	public static final BCLFeature JELLYSHROOM = registerVegetation("jellyshroom", new JellyshroomFeature(), 2);
	public static final BCLFeature GIGANTIC_AMARANITA = registerVegetation("gigantic_amaranita", new GiganticAmaranitaFeature(), 1);
	public static final BCLFeature LUCERNIA = registerVegetation("lucernia", new LucerniaFeature(), 3);

	// Bushes //
	public static final BCLFeature DRAGON_TREE_BUSH = registerVegetation("dragon_tree_bush", new BushFeature(EndBlocks.DRAGON_TREE_LEAVES.get(), EndBlocks.DRAGON_TREE.getBark()), 5);
	public static final BCLFeature TENANEA_BUSH = registerVegetation("tenanea_bush", new TenaneaBushFeature(), 6);
	public static final BCLFeature LUMECORN = registerVegetation("lumecorn", new Lumecorn(), 5);
	public static final BCLFeature LARGE_AMARANITA = registerVegetation("large_amaranita", new LargeAmaranitaFeature(), 5);
	public static final BCLFeature LUCERNIA_BUSH = registerVegetation("lucernia_bush", new BushWithOuterFeature(EndBlocks.LUCERNIA_LEAVES.get(), EndBlocks.LUCERNIA_OUTER_LEAVES.get(), EndBlocks.LUCERNIA.getBark()), 10);
	public static final BCLFeature LUCERNIA_BUSH_RARE = registerVegetation("lucernia_bush_rare", new BushWithOuterFeature(EndBlocks.LUCERNIA_LEAVES.get(), EndBlocks.LUCERNIA_OUTER_LEAVES.get(), EndBlocks.LUCERNIA.getBark()), 1);
	public static final BCLFeature NEON_CACTUS = registerVegetation("neon_cactus", new NeonCactusFeature(), 2);

	// Plants //

	// Vines //
	public static final BCLFeature TWISTED_VINE = registerVegetation("twisted_vine", new VineFeature(EndBlocks.TWISTED_VINE.get(), 24), 1);
	public static final BCLFeature BULB_VINE = registerVegetation("bulb_vine", new VineFeature(EndBlocks.BULB_VINE.get(), 24), 3);
	public static final BCLFeature JUNGLE_VINE = registerVegetation("jungle_vine", new VineFeature(EndBlocks.JUNGLE_VINE.get(), 24), 5);

	// Ceil plants
	public static final BCLFeature SMALL_JELLYSHROOM_CEIL = registerVegetation("small_jellyshroom_ceil", new SingleInvertedScatterFeature(EndBlocks.SMALL_JELLYSHROOM.get(), 8), 8);

	// Wall Plants //
//	public static final BCLFeature AURANT_POLYPORE = registerVegetation("aurant_polypore", new WallPlantOnLogFeature(EndBlocks.AURANT_POLYPORE.get(), 3), 5);
	public static final BCLFeature TWISTED_MOSS = registerVegetation("twisted_moss", new WallPlantFeature(EndBlocks.TWISTED_MOSS.get(), 6), 15);
	public static final BCLFeature TWISTED_MOSS_WOOD = registerVegetation("twisted_moss_wood", new WallPlantOnLogFeature(EndBlocks.TWISTED_MOSS.get(), 6), 25);
	public static final BCLFeature BULB_MOSS = registerVegetation("bulb_moss", new WallPlantFeature(EndBlocks.BULB_MOSS.get(), 6), 1);
	public static final BCLFeature BULB_MOSS_WOOD = registerVegetation("bulb_moss_wood", new WallPlantOnLogFeature(EndBlocks.BULB_MOSS.get(), 6), 15);
	public static final BCLFeature SMALL_JELLYSHROOM_WALL = registerVegetation("small_jellyshroom_wall", new WallPlantFeature(EndBlocks.SMALL_JELLYSHROOM.get(), 4), 4);
	public static final BCLFeature SMALL_JELLYSHROOM_WOOD = registerVegetation("small_jellyshroom_wood", new WallPlantOnLogFeature(EndBlocks.SMALL_JELLYSHROOM.get(), 4), 8);
	public static final BCLFeature JUNGLE_FERN_WOOD = registerVegetation("jungle_fern_wood", new WallPlantOnLogFeature(EndBlocks.JUNGLE_FERN.get(), 3), 12);
	public static final BCLFeature RUSCUS = registerVegetation("ruscus", new WallPlantFeature(EndBlocks.RUSCUS.get(), 6), 10);
	public static final BCLFeature RUSCUS_WOOD = registerVegetation("ruscus_wood", new WallPlantOnLogFeature(EndBlocks.RUSCUS.get(), 6), 10);

	// Sky plants
	public static final BCLFeature FILALUX = registerVegetation("filalux", new FilaluxFeature(), 1);

	// Water //

	// Terrain //
	public static final BCLFeature END_LAKE_NORMAL = registerLake("end_lake_normal", new EndLakeFeature(), 20);
	public static final BCLFeature DESERT_LAKE = registerLake("desert_lake", new DesertLakeFeature(), 8);
	public static final BCLFeature ROUND_CAVE = registerRawGen("round_cave", new RoundCaveFeature(), 2);
	public static final BCLFeature SPIRE = registerRawGen("spire", new SpireFeature(), 4);
	public static final BCLFeature FLOATING_SPIRE = registerRawGen("floating_spire", new FloatingSpireFeature(), 8);
	public static final BCLFeature GEYSER = registerRawGen("geyser", new GeyserFeature(), 8);
	public static final BCLFeature SULPHURIC_LAKE = registerLake("sulphuric_lake", new SulphuricLakeFeature(), 8);
	public static final BCLFeature SULPHURIC_CAVE = BCLCommonFeatures.makeCountFeature(BetterEndForge.makeID("sulphuric_cave"), Decoration.RAW_GENERATION, new SulphuricCaveFeature(), 2);
	public static final BCLFeature ICE_STAR = registerRawGen("ice_star", new IceStarFeature(5, 15, 10, 25), 15);
	public static final BCLFeature ICE_STAR_SMALL = registerRawGen("ice_star_small", new IceStarFeature(3, 5, 7, 12), 8);
	public static final BCLFeature SURFACE_VENT = registerChanced("surface_vent", new SurfaceVentFeature(), 4);
	public static final BCLFeature SULPHUR_HILL = registerChanced("sulphur_hill", new SulphurHillFeature(), 8);
	public static final BCLFeature OBSIDIAN_PILLAR_BASEMENT = registerChanced("obsidian_pillar_basement", new ObsidianPillarBasementFeature(), 8);
	public static final BCLFeature OBSIDIAN_BOULDER = registerChanced("obsidian_boulder", new ObsidianBoulderFeature(), 10);
	public static final BCLFeature FALLEN_PILLAR = registerChanced("fallen_pillar", new FallenPillarFeature(), 20);
	public static final BCLFeature TUNEL_CAVE = BCLCommonFeatures.makeChunkFeature(BetterEndForge.makeID("tunel_cave"), Decoration.RAW_GENERATION, new TunelCaveFeature());
	public static final BCLFeature UMBRALITH_ARCH = registerChanced("umbralith_arch", new ArchFeature(
		EndBlocks.UMBRALITH.stone.get(),
		pos -> UmbraValleyBiome.getSurface(pos.getX(), pos.getZ()).defaultBlockState()
	), 10);
//	public static final BCLFeature THIN_UMBRALITH_ARCH = registerChanced("thin_umbralith_arch", new ThinArchFeature(EndBlocks.UMBRALITH.stone.get()), 15);

	// Ores //
	public static final BCLFeature THALLASIUM_ORE = registerOre("thallasium_ore", EndBlocks.THALLASIUM.ore.get(), 24, 8);
	public static final BCLFeature ENDER_ORE = registerOre("ender_ore", EndBlocks.ENDER_ORE.get(), 12, 4);
	public static final BCLFeature AMBER_ORE = registerOre("amber_ore", EndBlocks.AMBER_ORE.get(), 60, 6);
	public static final BCLFeature DRAGON_BONE_BLOCK_ORE = registerOre("dragon_bone_ore", EndBlocks.DRAGON_BONE_BLOCK.get(), 24, 8);
	public static final BCLFeature VIOLECITE_LAYER = registerLayer("violecite_layer", EndBlocks.VIOLECITE, 15, 16, 128, 8);
	public static final BCLFeature FLAVOLITE_LAYER = registerLayer("flavolite_layer", EndBlocks.FLAVOLITE, 12, 16, 128, 6);

	// Buildings
	public static final BCLFeature CRASHED_SHIP = registerChanced("crashed_ship", new CrashedShipFeature(), 500);

	// Mobs
	public static final BCLFeature SILK_MOTH_NEST = registerChanced("silk_moth_nest", new SilkMothNestFeature(), 2);

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
