package ru.betterend.registry;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import ru.betterend.bclib.blocks.BaseFurnaceBlock;
import ru.betterend.bclib.blocks.BaseOreBlock;
import ru.betterend.bclib.blocks.BasePathBlock;
import ru.betterend.bclib.blocks.BaseRotatedPillarBlock;
import ru.betterend.bclib.blocks.BaseSlabBlock;
import ru.betterend.bclib.blocks.BaseStairsBlock;
import ru.betterend.bclib.blocks.BaseVineBlock;
import ru.betterend.bclib.blocks.SimpleLeavesBlock;
import ru.betterend.bclib.blocks.StalactiteBlock;
import ru.betterend.bclib.registry.BlockRegistry;
import ru.betterend.BetterEndForge;
import ru.betterend.blocks.AeterniumAnvil;
import ru.betterend.blocks.AeterniumBlock;
import ru.betterend.blocks.AmaranitaCapBlock;
import ru.betterend.blocks.AmaranitaHymenophoreBlock;
import ru.betterend.blocks.AmaranitaStemBlock;
import ru.betterend.blocks.AmberBlock;
import ru.betterend.blocks.AncientEmeraldIceBlock;
import ru.betterend.blocks.AuroraCrystalBlock;
import ru.betterend.blocks.BlueVineBlock;
import ru.betterend.blocks.BlueVineLanternBlock;
import ru.betterend.blocks.BlueVineSeedBlock;
import ru.betterend.blocks.BoluxMushroomBlock;
import ru.betterend.blocks.BrimstoneBlock;
import ru.betterend.blocks.BubbleCoralBlock;
import ru.betterend.blocks.BulbVineBlock;
import ru.betterend.blocks.BulbVineLanternBlock;
import ru.betterend.blocks.BulbVineLanternColoredBlock;
import ru.betterend.blocks.BulbVineSeedBlock;
import ru.betterend.blocks.CavePumpkinBlock;
import ru.betterend.blocks.CavePumpkinVineBlock;
import ru.betterend.blocks.ChandelierBlock;
import ru.betterend.blocks.CharcoalBlock;
import ru.betterend.blocks.CharniaBlock;
import ru.betterend.blocks.ChorusGrassBlock;
import ru.betterend.blocks.DenseEmeraldIceBlock;
import ru.betterend.blocks.DenseSnowBlock;
import ru.betterend.blocks.DragonTreeSaplingBlock;
import ru.betterend.blocks.EmeraldIceBlock;
import ru.betterend.blocks.EndLilyBlock;
import ru.betterend.blocks.EndLilySeedBlock;
import ru.betterend.blocks.EndLotusFlowerBlock;
import ru.betterend.blocks.EndLotusLeafBlock;
import ru.betterend.blocks.EndLotusSeedBlock;
import ru.betterend.blocks.EndLotusStemBlock;
import ru.betterend.blocks.EndPortalBlock;
import ru.betterend.blocks.EndStoneSmelter;
import ru.betterend.blocks.EnderBlock;
import ru.betterend.blocks.EndstoneDustBlock;
import ru.betterend.blocks.EternalPedestal;
import ru.betterend.blocks.FilaluxBlock;
import ru.betterend.blocks.FilaluxLanternBlock;
import ru.betterend.blocks.FilaluxWingsBlock;
import ru.betterend.blocks.FlamaeaBlock;
import ru.betterend.blocks.FlammalixBlock;
import ru.betterend.blocks.FlowerPotBlock;
import ru.betterend.blocks.GlowingHymenophoreBlock;
import ru.betterend.blocks.GlowingMossBlock;
import ru.betterend.blocks.GlowingPillarLuminophorBlock;
import ru.betterend.blocks.GlowingPillarRootsBlock;
import ru.betterend.blocks.GlowingPillarSeedBlock;
import ru.betterend.blocks.HelixTreeLeavesBlock;
import ru.betterend.blocks.HelixTreeSaplingBlock;
import ru.betterend.blocks.HydraluxBlock;
import ru.betterend.blocks.HydraluxPetalBlock;
import ru.betterend.blocks.HydraluxPetalColoredBlock;
import ru.betterend.blocks.HydraluxSaplingBlock;
import ru.betterend.blocks.HydrothermalVentBlock;
import ru.betterend.blocks.InfusionPedestal;
import ru.betterend.blocks.JellyshroomCapBlock;
import ru.betterend.blocks.LacugroveSaplingBlock;
import ru.betterend.blocks.LanceleafBlock;
import ru.betterend.blocks.LanceleafSeedBlock;
import ru.betterend.blocks.LargeAmaranitaBlock;
import ru.betterend.blocks.LucerniaSaplingBlock;
import ru.betterend.blocks.LumecornBlock;
import ru.betterend.blocks.LumecornSeedBlock;
import ru.betterend.blocks.MengerSpongeBlock;
import ru.betterend.blocks.MengerSpongeWetBlock;
import ru.betterend.blocks.MissingTileBlock;
import ru.betterend.blocks.MossyDragonBoneBlock;
import ru.betterend.blocks.MossyGlowshroomCapBlock;
import ru.betterend.blocks.MossyGlowshroomSaplingBlock;
import ru.betterend.blocks.MossyObsidian;
import ru.betterend.blocks.MurkweedBlock;
import ru.betterend.blocks.NeedlegrassBlock;
import ru.betterend.blocks.NeonCactusBlock;
import ru.betterend.blocks.NeonCactusPlantBlock;
import ru.betterend.blocks.PallidiumBlock;
import ru.betterend.blocks.PedestalVanilla;
import ru.betterend.blocks.PondAnemoneBlock;
import ru.betterend.blocks.PythadendronSaplingBlock;
import ru.betterend.blocks.RespawnObeliskBlock;
import ru.betterend.blocks.RunedFlavolite;
import ru.betterend.blocks.ShadowBerryBlock;
import ru.betterend.blocks.ShadowGrassBlock;
import ru.betterend.blocks.SilkMothHiveBlock;
import ru.betterend.blocks.SilkMothNestBlock;
import ru.betterend.blocks.SmallAmaranitaBlock;
import ru.betterend.blocks.SmallJellyshroomBlock;
import ru.betterend.blocks.SmaragdantCrystalBlock;
import ru.betterend.blocks.SmaragdantCrystalShardBlock;
import ru.betterend.blocks.SulphurCrystalBlock;
import ru.betterend.blocks.TenaneaFlowersBlock;
import ru.betterend.blocks.TenaneaSaplingBlock;
import ru.betterend.blocks.TerrainPlantBlock;
import ru.betterend.blocks.TwistedUmbrellaMossBlock;
import ru.betterend.blocks.TwistedUmbrellaMossTallBlock;
import ru.betterend.blocks.UmbrellaMossBlock;
import ru.betterend.blocks.UmbrellaMossTallBlock;
import ru.betterend.blocks.UmbrellaTreeClusterBlock;
import ru.betterend.blocks.UmbrellaTreeClusterEmptyBlock;
import ru.betterend.blocks.UmbrellaTreeMembraneBlock;
import ru.betterend.blocks.UmbrellaTreeSaplingBlock;
import ru.betterend.blocks.VentBubbleColumnBlock;
import ru.betterend.blocks.basis.EndTerrainBlock;
import ru.betterend.blocks.basis.EndTripleTerrain;
import ru.betterend.blocks.basis.EndUnderwaterWallPlantBlock;
import ru.betterend.blocks.basis.EndWallMushroom;
import ru.betterend.blocks.basis.EndWallPlantBlock;
import ru.betterend.blocks.basis.FurBlock;
import ru.betterend.blocks.basis.PottableCropBlock;
import ru.betterend.blocks.basis.PottableLeavesBlock;
import ru.betterend.blocks.basis.StoneLanternBlock;
import ru.betterend.complexmaterials.ColoredMaterial;
import ru.betterend.complexmaterials.CrystalSubblocksMaterial;
import ru.betterend.complexmaterials.EndWoodenComplexMaterial;
import ru.betterend.complexmaterials.MetalMaterial;
import ru.betterend.complexmaterials.StoneMaterial;
import ru.betterend.item.material.EndArmorMaterial;
import ru.betterend.item.material.EndToolMaterial;
import ru.betterend.tab.CreativeTabs;

import java.util.List;

public class EndBlocks {
	private static final BlockRegistry REGISTRY = new BlockRegistry(CreativeTabs.TAB_BLOCKS);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

	// Terrain //
	public static final RegistryObject<Block> ENDSTONE_DUST = registerBlock("endstone_dust", new EndstoneDustBlock());
	public static final RegistryObject<Block> END_MYCELIUM = registerBlock("end_mycelium", new EndTerrainBlock(MaterialColor.COLOR_LIGHT_BLUE));
	public static final RegistryObject<Block> END_MOSS = registerBlock("end_moss", new EndTerrainBlock(MaterialColor.COLOR_CYAN));
	public static final RegistryObject<Block> CHORUS_NYLIUM = registerBlock("chorus_nylium", new EndTerrainBlock(MaterialColor.COLOR_MAGENTA));
	public static final RegistryObject<Block> CAVE_MOSS = registerBlock("cave_moss", new EndTripleTerrain(MaterialColor.COLOR_PURPLE));
	public static final RegistryObject<Block> CRYSTAL_MOSS = registerBlock("crystal_moss", new EndTerrainBlock(MaterialColor.COLOR_PINK));
	public static final RegistryObject<Block> SHADOW_GRASS = registerBlock("shadow_grass", new ShadowGrassBlock());
	public static final RegistryObject<Block> PINK_MOSS = registerBlock("pink_moss", new EndTerrainBlock(MaterialColor.COLOR_PINK));
	public static final RegistryObject<Block> AMBER_MOSS = registerBlock("amber_moss", new EndTerrainBlock(MaterialColor.COLOR_ORANGE));
	public static final RegistryObject<Block> JUNGLE_MOSS = registerBlock("jungle_moss", new EndTerrainBlock(MaterialColor.COLOR_GREEN));
	public static final RegistryObject<Block> SANGNUM = registerBlock("sangnum", new EndTerrainBlock(MaterialColor.COLOR_RED));
	public static final RegistryObject<Block> RUTISCUS = registerBlock("rutiscus", new EndTerrainBlock(MaterialColor.COLOR_ORANGE));
	public static final RegistryObject<Block> PALLIDIUM_FULL = registerBlock("pallidium_full", new PallidiumBlock("full", null));
	public static final RegistryObject<Block> PALLIDIUM_HEAVY = registerBlock("pallidium_heavy", new PallidiumBlock("heavy", PALLIDIUM_FULL.get()));
	public static final RegistryObject<Block> PALLIDIUM_THIN = registerBlock("pallidium_thin", new PallidiumBlock("thin", PALLIDIUM_HEAVY.get()));
	public static final RegistryObject<Block> PALLIDIUM_TINY = registerBlock("pallidium_tiny", new PallidiumBlock("tiny", PALLIDIUM_THIN.get()));
	
	// Roads //
	public static final RegistryObject<Block> END_MYCELIUM_PATH = registerBlock("end_mycelium_path", new BasePathBlock(END_MYCELIUM.get()));
	public static final RegistryObject<Block> END_MOSS_PATH = registerBlock("end_moss_path", new BasePathBlock(END_MOSS.get()));
	public static final RegistryObject<Block> CHORUS_NYLIUM_PATH = registerBlock("chorus_nylium_path", new BasePathBlock(CHORUS_NYLIUM.get()));
	public static final RegistryObject<Block> CAVE_MOSS_PATH = registerBlock("cave_moss_path", new BasePathBlock(CAVE_MOSS.get()));
	public static final RegistryObject<Block> CRYSTAL_MOSS_PATH = registerBlock("crystal_moss_path", new BasePathBlock(CRYSTAL_MOSS.get()));
	public static final RegistryObject<Block> SHADOW_GRASS_PATH = registerBlock("shadow_grass_path", new BasePathBlock(SHADOW_GRASS.get()));
	public static final RegistryObject<Block> PINK_MOSS_PATH = registerBlock("pink_moss_path", new BasePathBlock(PINK_MOSS.get()));
	public static final RegistryObject<Block> AMBER_MOSS_PATH = registerBlock("amber_moss_path", new BasePathBlock(AMBER_MOSS.get()));
	public static final RegistryObject<Block> JUNGLE_MOSS_PATH = registerBlock("jungle_moss_path", new BasePathBlock(JUNGLE_MOSS.get()));
	public static final RegistryObject<Block> SANGNUM_PATH = registerBlock("sangnum_path", new BasePathBlock(SANGNUM.get()));
	public static final RegistryObject<Block> RUTISCUS_PATH = registerBlock("rutiscus_path", new BasePathBlock(RUTISCUS.get()));
	
	public static final RegistryObject<Block> MOSSY_OBSIDIAN = registerBlock("mossy_obsidian", new MossyObsidian());
	public static final RegistryObject<Block> DRAGON_BONE_BLOCK = registerBlock("dragon_bone_block", new BaseRotatedPillarBlock(Blocks.BONE_BLOCK));
	public static final RegistryObject<Block> DRAGON_BONE_STAIRS = registerBlock("dragon_bone_stairs", new BaseStairsBlock(DRAGON_BONE_BLOCK.get()));
	public static final RegistryObject<Block> DRAGON_BONE_SLAB = registerBlock("dragon_bone_slab", new BaseSlabBlock(DRAGON_BONE_BLOCK.get()));
	public static final RegistryObject<Block> MOSSY_DRAGON_BONE = registerBlock("mossy_dragon_bone", new MossyDragonBoneBlock());
	
	// Rocks //
	public static final StoneMaterial FLAVOLITE = new StoneMaterial("flavolite", MaterialColor.SAND);
	public static final StoneMaterial VIOLECITE = new StoneMaterial("violecite", MaterialColor.COLOR_PURPLE);
	public static final StoneMaterial SULPHURIC_ROCK = new StoneMaterial("sulphuric_rock", MaterialColor.COLOR_BROWN);
	public static final StoneMaterial VIRID_JADESTONE = new StoneMaterial("virid_jadestone", MaterialColor.COLOR_GREEN);
	public static final StoneMaterial AZURE_JADESTONE = new StoneMaterial("azure_jadestone", MaterialColor.COLOR_LIGHT_BLUE);
	public static final StoneMaterial SANDY_JADESTONE = new StoneMaterial("sandy_jadestone", MaterialColor.COLOR_YELLOW);
	public static final StoneMaterial UMBRALITH = new StoneMaterial("umbralith", MaterialColor.DEEPSLATE);
	public static final RegistryObject<Block> BRIMSTONE = registerBlock("brimstone", new BrimstoneBlock());
	public static final RegistryObject<Block> SULPHUR_CRYSTAL = registerBlock("sulphur_crystal", new SulphurCrystalBlock());
	public static final RegistryObject<Block> MISSING_TILE = registerBlock("missing_tile", new MissingTileBlock());
	public static final RegistryObject<Block> ENDSTONE_FLOWER_POT = registerBlock("endstone_flower_pot", new FlowerPotBlock(Blocks.END_STONE));
	
	public static final RegistryObject<Block> FLAVOLITE_RUNED = registerBlock("flavolite_runed", new RunedFlavolite(false));
	public static final RegistryObject<Block> FLAVOLITE_RUNED_ETERNAL = registerBlock("flavolite_runed_eternal", new RunedFlavolite(true));
	
	public static final RegistryObject<Block> ANDESITE_PEDESTAL = registerBlock("andesite_pedestal", new PedestalVanilla(Blocks.ANDESITE));
	public static final RegistryObject<Block> DIORITE_PEDESTAL = registerBlock("diorite_pedestal", new PedestalVanilla(Blocks.DIORITE));
	public static final RegistryObject<Block> GRANITE_PEDESTAL = registerBlock("granite_pedestal", new PedestalVanilla(Blocks.GRANITE));
	public static final RegistryObject<Block> QUARTZ_PEDESTAL = registerBlock("quartz_pedestal", new PedestalVanilla(Blocks.QUARTZ_BLOCK));
	public static final RegistryObject<Block> PURPUR_PEDESTAL = registerBlock("purpur_pedestal", new PedestalVanilla(Blocks.PURPUR_BLOCK));
	
	public static final RegistryObject<Block> HYDROTHERMAL_VENT = registerBlock("hydrothermal_vent", new HydrothermalVentBlock());
	public static final RegistryObject<Block> VENT_BUBBLE_COLUMN = registerEndBlockOnly("vent_bubble_column", new VentBubbleColumnBlock());
	
	public static final RegistryObject<Block> DENSE_SNOW = registerBlock("dense_snow", new DenseSnowBlock());
	public static final RegistryObject<Block> EMERALD_ICE = registerBlock("emerald_ice", new EmeraldIceBlock());
	public static final RegistryObject<Block> DENSE_EMERALD_ICE = registerBlock("dense_emerald_ice", new DenseEmeraldIceBlock());
	public static final RegistryObject<Block> ANCIENT_EMERALD_ICE = registerBlock("ancient_emerald_ice", new AncientEmeraldIceBlock());
	
	public static final RegistryObject<Block> END_STONE_STALACTITE = registerBlock("end_stone_stalactite", new StalactiteBlock(Blocks.END_STONE));
	public static final RegistryObject<Block> END_STONE_STALACTITE_CAVEMOSS = registerBlock("end_stone_stalactite_cavemoss", new StalactiteBlock(CAVE_MOSS.get()));
	
	// Wooden Materials And Trees //
	public static final RegistryObject<Block> MOSSY_GLOWSHROOM_SAPLING = registerBlock("mossy_glowshroom_sapling", new MossyGlowshroomSaplingBlock());
	public static final RegistryObject<Block> MOSSY_GLOWSHROOM_CAP = registerBlock("mossy_glowshroom_cap", new MossyGlowshroomCapBlock());
	public static final RegistryObject<Block> MOSSY_GLOWSHROOM_HYMENOPHORE = registerBlock("mossy_glowshroom_hymenophore", new GlowingHymenophoreBlock());
	public static final RegistryObject<Block> MOSSY_GLOWSHROOM_FUR = registerBlock("mossy_glowshroom_fur", new FurBlock(MOSSY_GLOWSHROOM_SAPLING.get(), 15, 16, true));
	public static final EndWoodenComplexMaterial MOSSY_GLOWSHROOM = new EndWoodenComplexMaterial(
		"mossy_glowshroom",
		MaterialColor.COLOR_GRAY,
		MaterialColor.WOOD
	).init();
	
	public static final RegistryObject<Block> PYTHADENDRON_SAPLING = registerBlock("pythadendron_sapling", new PythadendronSaplingBlock());
	public static final RegistryObject<Block> PYTHADENDRON_LEAVES = registerBlock("pythadendron_leaves", new PottableLeavesBlock(PYTHADENDRON_SAPLING.get(), MaterialColor.COLOR_MAGENTA));
	public static final EndWoodenComplexMaterial PYTHADENDRON = new EndWoodenComplexMaterial(
		"pythadendron",
		MaterialColor.COLOR_MAGENTA,
		MaterialColor.COLOR_PURPLE
	).init();
	
	public static final RegistryObject<Block> END_LOTUS_SEED = registerBlock("end_lotus_seed", new EndLotusSeedBlock());
	public static final RegistryObject<Block> END_LOTUS_STEM = registerBlock("end_lotus_stem", new EndLotusStemBlock());
	public static final RegistryObject<Block> END_LOTUS_LEAF = registerEndBlockOnly("end_lotus_leaf", new EndLotusLeafBlock());
	public static final RegistryObject<Block> END_LOTUS_FLOWER = registerEndBlockOnly("end_lotus_flower", new EndLotusFlowerBlock());
	public static final EndWoodenComplexMaterial END_LOTUS = new EndWoodenComplexMaterial(
		"end_lotus",
		MaterialColor.COLOR_LIGHT_BLUE,
		MaterialColor.COLOR_CYAN
	).init();
	
	public static final RegistryObject<Block> LACUGROVE_SAPLING = registerBlock("lacugrove_sapling", new LacugroveSaplingBlock());
	public static final RegistryObject<Block> LACUGROVE_LEAVES = registerBlock("lacugrove_leaves", new PottableLeavesBlock(LACUGROVE_SAPLING.get(), MaterialColor.COLOR_CYAN));
	public static final EndWoodenComplexMaterial LACUGROVE = new EndWoodenComplexMaterial(
		"lacugrove",
		MaterialColor.COLOR_BROWN,
		MaterialColor.COLOR_YELLOW
	).init();
	
	public static final RegistryObject<Block> DRAGON_TREE_SAPLING = registerBlock("dragon_tree_sapling", new DragonTreeSaplingBlock());
	public static final RegistryObject<Block> DRAGON_TREE_LEAVES = registerBlock("dragon_tree_leaves", new PottableLeavesBlock(DRAGON_TREE_SAPLING.get(), MaterialColor.COLOR_MAGENTA));
	public static final EndWoodenComplexMaterial DRAGON_TREE = new EndWoodenComplexMaterial(
		"dragon_tree",
		MaterialColor.COLOR_BLACK,
		MaterialColor.COLOR_MAGENTA
	).init();
	
	public static final RegistryObject<Block> TENANEA_SAPLING = registerBlock("tenanea_sapling", new TenaneaSaplingBlock());
	public static final RegistryObject<Block> TENANEA_LEAVES = registerBlock("tenanea_leaves", new PottableLeavesBlock(TENANEA_SAPLING.get(), MaterialColor.COLOR_PINK));
	public static final RegistryObject<Block> TENANEA_FLOWERS = registerBlock("tenanea_flowers", new TenaneaFlowersBlock());
	public static final RegistryObject<Block> TENANEA_OUTER_LEAVES = registerBlock("tenanea_outer_leaves", new FurBlock(TENANEA_SAPLING.get(), 32));
	public static final EndWoodenComplexMaterial TENANEA = new EndWoodenComplexMaterial(
		"tenanea",
		MaterialColor.COLOR_BROWN,
		MaterialColor.COLOR_PINK
	).init();
	
	public static final RegistryObject<Block> HELIX_TREE_SAPLING = registerBlock("helix_tree_sapling", new HelixTreeSaplingBlock());
	public static final RegistryObject<Block> HELIX_TREE_LEAVES = registerBlock("helix_tree_leaves", new HelixTreeLeavesBlock());
	public static final EndWoodenComplexMaterial HELIX_TREE = new EndWoodenComplexMaterial(
		"helix_tree",
		MaterialColor.COLOR_GRAY,
		MaterialColor.COLOR_ORANGE
	).init();
	
	public static final RegistryObject<Block> UMBRELLA_TREE_SAPLING = registerBlock("umbrella_tree_sapling", new UmbrellaTreeSaplingBlock());
	public static final RegistryObject<Block> UMBRELLA_TREE_MEMBRANE = registerBlock("umbrella_tree_membrane", new UmbrellaTreeMembraneBlock());
	public static final RegistryObject<Block> UMBRELLA_TREE_CLUSTER = registerBlock("umbrella_tree_cluster", new UmbrellaTreeClusterBlock());
	public static final RegistryObject<Block> UMBRELLA_TREE_CLUSTER_EMPTY = registerBlock("umbrella_tree_cluster_empty", new UmbrellaTreeClusterEmptyBlock());
	public static final EndWoodenComplexMaterial UMBRELLA_TREE = new EndWoodenComplexMaterial(
		"umbrella_tree",
		MaterialColor.COLOR_BLUE,
		MaterialColor.COLOR_GREEN
	).init();
	
	public static final RegistryObject<Block> JELLYSHROOM_CAP_PURPLE = registerBlock("jellyshroom_cap_purple", new JellyshroomCapBlock(217, 142, 255, 164, 0, 255));
	public static final EndWoodenComplexMaterial JELLYSHROOM = new EndWoodenComplexMaterial(
		"jellyshroom",
		MaterialColor.COLOR_PURPLE,
		MaterialColor.COLOR_LIGHT_BLUE
	).init();
	
	public static final RegistryObject<Block> LUCERNIA_SAPLING = registerBlock("lucernia_sapling", new LucerniaSaplingBlock());
	public static final RegistryObject<Block> LUCERNIA_LEAVES = registerBlock("lucernia_leaves", new PottableLeavesBlock(LUCERNIA_SAPLING.get(), MaterialColor.COLOR_ORANGE));
	public static final RegistryObject<Block> LUCERNIA_OUTER_LEAVES = registerBlock("lucernia_outer_leaves", new FurBlock(LUCERNIA_SAPLING.get(), 32));
	public static final EndWoodenComplexMaterial LUCERNIA = new EndWoodenComplexMaterial(
		"lucernia",
		MaterialColor.COLOR_ORANGE,
		MaterialColor.COLOR_ORANGE
	).init();
	
	// Small Plants //
	public static final RegistryObject<Block> UMBRELLA_MOSS = registerBlock("umbrella_moss", new UmbrellaMossBlock());
	public static final RegistryObject<Block> UMBRELLA_MOSS_TALL = registerBlock("umbrella_moss_tall", new UmbrellaMossTallBlock());
	public static final RegistryObject<Block> CREEPING_MOSS = registerBlock("creeping_moss", new GlowingMossBlock(11));
	public static final RegistryObject<Block> CHORUS_GRASS = registerBlock("chorus_grass", new ChorusGrassBlock());
	public static final RegistryObject<Block> CAVE_GRASS = registerBlock("cave_grass", new TerrainPlantBlock(CAVE_MOSS.get()));
	public static final RegistryObject<Block> CRYSTAL_GRASS = registerBlock("crystal_grass", new TerrainPlantBlock(CRYSTAL_MOSS.get()));
	public static final RegistryObject<Block> SHADOW_PLANT = registerBlock("shadow_plant", new TerrainPlantBlock(SHADOW_GRASS.get()));
	public static final RegistryObject<Block> BUSHY_GRASS = registerBlock("bushy_grass", new TerrainPlantBlock(PINK_MOSS.get()));
	public static final RegistryObject<Block> AMBER_GRASS = registerBlock("amber_grass", new TerrainPlantBlock(AMBER_MOSS.get()));
	public static final RegistryObject<Block> TWISTED_UMBRELLA_MOSS = registerBlock("twisted_umbrella_moss", new TwistedUmbrellaMossBlock());
	public static final RegistryObject<Block> TWISTED_UMBRELLA_MOSS_TALL = registerBlock("twisted_umbrella_moss_tall", new TwistedUmbrellaMossTallBlock());
	public static final RegistryObject<Block> JUNGLE_GRASS = registerBlock("jungle_grass", new TerrainPlantBlock(JUNGLE_MOSS.get()));
	public static final RegistryObject<Block> BLOOMING_COOKSONIA = registerBlock("blooming_cooksonia", new TerrainPlantBlock(END_MOSS.get()));
	public static final RegistryObject<Block> SALTEAGO = registerBlock("salteago", new TerrainPlantBlock(END_MOSS.get()));
	public static final RegistryObject<Block> VAIOLUSH_FERN = registerBlock("vaiolush_fern", new TerrainPlantBlock(END_MOSS.get()));
	public static final RegistryObject<Block> FRACTURN = registerBlock("fracturn", new TerrainPlantBlock(END_MOSS.get()));
	public static final RegistryObject<Block> CLAWFERN = registerBlock("clawfern", new TerrainPlantBlock(SANGNUM.get(), MOSSY_OBSIDIAN.get(), MOSSY_DRAGON_BONE.get()));
	public static final RegistryObject<Block> GLOBULAGUS = registerBlock("globulagus", new TerrainPlantBlock(SANGNUM.get(), MOSSY_OBSIDIAN.get(), MOSSY_DRAGON_BONE.get()));
	public static final RegistryObject<Block> ORANGO = registerBlock("orango", new TerrainPlantBlock(RUTISCUS.get()));
	public static final RegistryObject<Block> AERIDIUM = registerBlock("aeridium", new TerrainPlantBlock(RUTISCUS.get()));
	public static final RegistryObject<Block> LUTEBUS = registerBlock("lutebus", new TerrainPlantBlock(RUTISCUS.get()));
	public static final RegistryObject<Block> LAMELLARIUM = registerBlock("lamellarium", new TerrainPlantBlock(RUTISCUS.get()));
	public static final RegistryObject<Block> INFLEXIA = registerBlock("inflexia", new TerrainPlantBlock(PALLIDIUM_FULL.get(), PALLIDIUM_HEAVY.get(), PALLIDIUM_THIN.get(), PALLIDIUM_TINY.get()));
	public static final RegistryObject<Block> FLAMMALIX = registerBlock("flammalix", new FlammalixBlock());
	
	public static final RegistryObject<Block> BLUE_VINE_SEED = registerBlock("blue_vine_seed", new BlueVineSeedBlock());
	public static final RegistryObject<Block> BLUE_VINE = registerEndBlockOnly("blue_vine", new BlueVineBlock());
	public static final RegistryObject<Block> BLUE_VINE_LANTERN = registerBlock("blue_vine_lantern", new BlueVineLanternBlock());
	public static final RegistryObject<Block> BLUE_VINE_FUR = registerBlock("blue_vine_fur", new FurBlock(BLUE_VINE_SEED.get(), 15, 3, false));
	
	public static final RegistryObject<Block> LANCELEAF_SEED = registerBlock("lanceleaf_seed", new LanceleafSeedBlock());
	public static final RegistryObject<Block> LANCELEAF = registerEndBlockOnly("lanceleaf", new LanceleafBlock());
	
	public static final RegistryObject<Block> GLOWING_PILLAR_SEED = registerBlock("glowing_pillar_seed", new GlowingPillarSeedBlock());
	public static final RegistryObject<Block> GLOWING_PILLAR_ROOTS = registerEndBlockOnly("glowing_pillar_roots", new GlowingPillarRootsBlock());
	public static final RegistryObject<Block> GLOWING_PILLAR_LUMINOPHOR = registerBlock("glowing_pillar_luminophor", new GlowingPillarLuminophorBlock());
	public static final RegistryObject<Block> GLOWING_PILLAR_LEAVES = registerBlock("glowing_pillar_leaves", new FurBlock(GLOWING_PILLAR_SEED.get(), 15, 3, false));
	
	public static final RegistryObject<Block> SMALL_JELLYSHROOM = registerBlock("small_jellyshroom", new SmallJellyshroomBlock());
	public static final RegistryObject<Block> BOLUX_MUSHROOM = registerBlock("bolux_mushroom", new BoluxMushroomBlock());
	
	public static final RegistryObject<Block> LUMECORN_SEED = registerBlock("lumecorn_seed", new LumecornSeedBlock());
	public static final RegistryObject<Block> LUMECORN = registerEndBlockOnly("lumecorn", new LumecornBlock());
	
	public static final RegistryObject<Block> SMALL_AMARANITA_MUSHROOM = registerBlock("small_amaranita_mushroom", new SmallAmaranitaBlock());
	public static final RegistryObject<Block> LARGE_AMARANITA_MUSHROOM = registerEndBlockOnly("large_amaranita_mushroom", new LargeAmaranitaBlock());
	public static final RegistryObject<Block> AMARANITA_STEM = registerBlock("amaranita_stem", new AmaranitaStemBlock());
	public static final RegistryObject<Block> AMARANITA_HYPHAE = registerBlock("amaranita_hyphae", new AmaranitaStemBlock());
	public static final RegistryObject<Block> AMARANITA_HYMENOPHORE = registerBlock("amaranita_hymenophore", new AmaranitaHymenophoreBlock());
	public static final RegistryObject<Block> AMARANITA_LANTERN = registerBlock("amaranita_lantern", new GlowingHymenophoreBlock());
	public static final RegistryObject<Block> AMARANITA_FUR = registerBlock("amaranita_fur", new FurBlock(SMALL_AMARANITA_MUSHROOM.get(), 15, 4, true));
	public static final RegistryObject<Block> AMARANITA_CAP = registerBlock("amaranita_cap", new AmaranitaCapBlock());
	
	public static final RegistryObject<Block> NEON_CACTUS = registerBlock("neon_cactus", new NeonCactusPlantBlock());
	public static final RegistryObject<Block> NEON_CACTUS_BLOCK = registerBlock("neon_cactus_block", new NeonCactusBlock());
	public static final RegistryObject<Block> NEON_CACTUS_BLOCK_STAIRS = registerBlock("neon_cactus_stairs", new BaseStairsBlock(NEON_CACTUS_BLOCK.get()));
	public static final RegistryObject<Block> NEON_CACTUS_BLOCK_SLAB = registerBlock("neon_cactus_slab", new BaseSlabBlock(NEON_CACTUS_BLOCK.get()));
	
	// Crops
	public static final RegistryObject<Block> SHADOW_BERRY = registerBlock("shadow_berry", new ShadowBerryBlock());
	public static final RegistryObject<Block> BLOSSOM_BERRY = registerBlock("blossom_berry_seed", new PottableCropBlock(EndItems.BLOSSOM_BERRY.get(), PINK_MOSS.get()));
	public static final RegistryObject<Block> AMBER_ROOT = registerBlock("amber_root_seed", new PottableCropBlock(EndItems.AMBER_ROOT_RAW.get(), AMBER_MOSS.get()));
	public static final RegistryObject<Block> CHORUS_MUSHROOM = registerBlock("chorus_mushroom_seed", new PottableCropBlock(EndItems.CHORUS_MUSHROOM_RAW.get(), CHORUS_NYLIUM.get()));
	//public static final RegistryObject<Block> PEARLBERRY = registerBlock("pearlberry_seed", new PottableCropBlock(EndItems.BLOSSOM_BERRY, END_MOSS, END_MYCELIUM));
	public static final RegistryObject<Block> CAVE_PUMPKIN_SEED = registerBlock("cave_pumpkin_seed", new CavePumpkinVineBlock());
	public static final RegistryObject<Block> CAVE_PUMPKIN = registerBlock("cave_pumpkin", new CavePumpkinBlock());
	
	// Water plants
	public static final RegistryObject<Block> BUBBLE_CORAL = registerBlock("bubble_coral", new BubbleCoralBlock());
	public static final RegistryObject<Block> MENGER_SPONGE = registerBlock("menger_sponge", new MengerSpongeBlock());
	public static final RegistryObject<Block> MENGER_SPONGE_WET = registerBlock("menger_sponge_wet", new MengerSpongeWetBlock());
	public static final RegistryObject<Block> CHARNIA_RED = registerBlock("charnia_red", new CharniaBlock());
	public static final RegistryObject<Block> CHARNIA_PURPLE = registerBlock("charnia_purple", new CharniaBlock());
	public static final RegistryObject<Block> CHARNIA_ORANGE = registerBlock("charnia_orange", new CharniaBlock());
	public static final RegistryObject<Block> CHARNIA_LIGHT_BLUE = registerBlock("charnia_light_blue", new CharniaBlock());
	public static final RegistryObject<Block> CHARNIA_CYAN = registerBlock("charnia_cyan", new CharniaBlock());
	public static final RegistryObject<Block> CHARNIA_GREEN = registerBlock("charnia_green", new CharniaBlock());
	
	public static final RegistryObject<Block> END_LILY = registerEndBlockOnly("end_lily", new EndLilyBlock());
	public static final RegistryObject<Block> END_LILY_SEED = registerBlock("end_lily_seed", new EndLilySeedBlock());
	
	public static final RegistryObject<Block> HYDRALUX_SAPLING = registerBlock("hydralux_sapling", new HydraluxSaplingBlock());
	public static final RegistryObject<Block> HYDRALUX = registerEndBlockOnly("hydralux", new HydraluxBlock());
	public static final RegistryObject<Block> HYDRALUX_PETAL_BLOCK = registerBlock("hydralux_petal_block", new HydraluxPetalBlock());
	public static final ColoredMaterial HYDRALUX_PETAL_BLOCK_COLORED = new ColoredMaterial(HydraluxPetalColoredBlock::new, HYDRALUX_PETAL_BLOCK.get(), true);
	
	public static final RegistryObject<Block> POND_ANEMONE = registerBlock("pond_anemone", new PondAnemoneBlock());
	
	public static final RegistryObject<Block> FLAMAEA = registerBlock("flamaea", new FlamaeaBlock());
	
	public static final RegistryObject<Block> CAVE_BUSH = registerBlock("cave_bush", new SimpleLeavesBlock(MaterialColor.COLOR_MAGENTA));
	
	public static final RegistryObject<Block> MURKWEED = registerBlock("murkweed", new MurkweedBlock());
	public static final RegistryObject<Block> NEEDLEGRASS = registerBlock("needlegrass", new NeedlegrassBlock());
	
	// Wall Plants //
	public static final RegistryObject<Block> PURPLE_POLYPORE = registerBlock("purple_polypore", new EndWallMushroom(13));
	public static final RegistryObject<Block> AURANT_POLYPORE = registerBlock("aurant_polypore", new EndWallMushroom(13));
	public static final RegistryObject<Block> TAIL_MOSS = registerBlock("tail_moss", new EndWallPlantBlock());
	public static final RegistryObject<Block> CYAN_MOSS = registerBlock("cyan_moss", new EndWallPlantBlock());
	public static final RegistryObject<Block> TWISTED_MOSS = registerBlock("twisted_moss", new EndWallPlantBlock());
	public static final RegistryObject<Block> TUBE_WORM = registerBlock("tube_worm", new EndUnderwaterWallPlantBlock());
	public static final RegistryObject<Block> BULB_MOSS = registerBlock("bulb_moss", new EndWallPlantBlock(12));
	public static final RegistryObject<Block> JUNGLE_FERN = registerBlock("jungle_fern", new EndWallPlantBlock());
	public static final RegistryObject<Block> RUSCUS = registerBlock("ruscus", new EndWallPlantBlock());
	
	// Vines //
	public static final RegistryObject<Block> DENSE_VINE = registerBlock("dense_vine", new BaseVineBlock(15, true));
	public static final RegistryObject<Block> TWISTED_VINE = registerBlock("twisted_vine", new BaseVineBlock());
	public static final RegistryObject<Block> BULB_VINE_SEED = registerBlock("bulb_vine_seed", new BulbVineSeedBlock());
	public static final RegistryObject<Block> BULB_VINE = registerBlock("bulb_vine", new BulbVineBlock());
	public static final RegistryObject<Block> JUNGLE_VINE = registerBlock("jungle_vine", new BaseVineBlock());
	public static final RegistryObject<Block> RUBINEA = registerBlock("rubinea", new BaseVineBlock());
	public static final RegistryObject<Block> MAGNULA = registerBlock("magnula", new BaseVineBlock());
	public static final RegistryObject<Block> FILALUX = registerBlock("filalux", new FilaluxBlock());
	public static final RegistryObject<Block> FILALUX_WINGS = registerBlock("filalux_wings", new FilaluxWingsBlock());
	public static final RegistryObject<Block> FILALUX_LANTERN = registerBlock("filalux_lantern", new FilaluxLanternBlock());
	
	// Mob-Related
	public static final RegistryObject<Block> SILK_MOTH_NEST = registerBlock("silk_moth_nest", new SilkMothNestBlock());
	public static final RegistryObject<Block> SILK_MOTH_HIVE = registerBlock("silk_moth_hive", new SilkMothHiveBlock());
	
	// Ores //
	public static final RegistryObject<Block> ENDER_ORE = registerBlock("ender_ore", new BaseOreBlock(()->EndItems.ENDER_SHARD.get(), 1, 3, 5));
	public static final RegistryObject<Block> AMBER_ORE = registerBlock("amber_ore", new BaseOreBlock(()->EndItems.RAW_AMBER.get(), 1, 2, 4));
	
	// Materials //
	public static final MetalMaterial THALLASIUM = MetalMaterial.makeNormal(
		"thallasium",
		MaterialColor.COLOR_BLUE,
		EndToolMaterial.THALLASIUM,
		EndArmorMaterial.THALLASIUM
	);
	public static final MetalMaterial TERMINITE = MetalMaterial.makeOreless(
		"terminite",
		MaterialColor.WARPED_WART_BLOCK,
		7F,
		9F,
		EndToolMaterial.TERMINITE,
		EndArmorMaterial.TERMINITE
	);
	public static final RegistryObject<Block> AETERNIUM_BLOCK = registerBlock("aeternium_block", new AeterniumBlock());
	public static final RegistryObject<Block> CHARCOAL_BLOCK = registerBlock("charcoal_block", new CharcoalBlock());
	
	public static final RegistryObject<Block> ENDER_BLOCK = registerBlock("ender_block", new EnderBlock());
	public static final RegistryObject<Block> AURORA_CRYSTAL = registerBlock("aurora_crystal", new AuroraCrystalBlock());
	public static final RegistryObject<Block> AMBER_BLOCK = registerBlock("amber_block", new AmberBlock());
	public static final RegistryObject<Block> SMARAGDANT_CRYSTAL_SHARD = registerBlock(
		"smaragdant_crystal_shard",
		new SmaragdantCrystalShardBlock()
	);
	public static final RegistryObject<Block> SMARAGDANT_CRYSTAL = registerBlock("smaragdant_crystal", new SmaragdantCrystalBlock());
	public static final CrystalSubblocksMaterial SMARAGDANT_SUBBLOCKS = new CrystalSubblocksMaterial(
		"smaragdant_crystal",
		SMARAGDANT_CRYSTAL.get()
	);
	
	public static final RegistryObject<Block> RESPAWN_OBELISK = registerBlock("respawn_obelisk", new RespawnObeliskBlock());
	
	// Lanterns
	public static final RegistryObject<Block> ANDESITE_LANTERN = registerBlock(
		"andesite_lantern",
		new StoneLanternBlock(Blocks.ANDESITE)
	);
	public static final RegistryObject<Block> DIORITE_LANTERN = registerBlock("diorite_lantern", new StoneLanternBlock(Blocks.DIORITE));
	public static final RegistryObject<Block> GRANITE_LANTERN = registerBlock("granite_lantern", new StoneLanternBlock(Blocks.GRANITE));
	public static final RegistryObject<Block> QUARTZ_LANTERN = registerBlock(
		"quartz_lantern",
		new StoneLanternBlock(Blocks.QUARTZ_BLOCK)
	);
	public static final RegistryObject<Block> PURPUR_LANTERN = registerBlock(
		"purpur_lantern",
		new StoneLanternBlock(Blocks.PURPUR_BLOCK)
	);
	public static final RegistryObject<Block> END_STONE_LANTERN = registerBlock(
		"end_stone_lantern",
		new StoneLanternBlock(Blocks.END_STONE)
	);
	public static final RegistryObject<Block> BLACKSTONE_LANTERN = registerBlock(
		"blackstone_lantern",
		new StoneLanternBlock(Blocks.BLACKSTONE)
	);
	
	public static final RegistryObject<Block> IRON_BULB_LANTERN = registerBlock("iron_bulb_lantern", new BulbVineLanternBlock());
	public static final ColoredMaterial IRON_BULB_LANTERN_COLORED = new ColoredMaterial(
		BulbVineLanternColoredBlock::new,
		IRON_BULB_LANTERN.get(),
		false
	);
	
	public static final RegistryObject<Block> IRON_CHANDELIER = EndBlocks.registerBlock(
		"iron_chandelier",
		new ChandelierBlock(Blocks.GOLD_BLOCK)
	);
	public static final RegistryObject<Block> GOLD_CHANDELIER = EndBlocks.registerBlock(
		"gold_chandelier",
		new ChandelierBlock(Blocks.GOLD_BLOCK)
	);
	
	// Blocks With Entity //
	public static final RegistryObject<Block> END_STONE_FURNACE = registerBlock(
		"end_stone_furnace",
		new BaseFurnaceBlock(Blocks.END_STONE)
	);
	public static final RegistryObject<Block> END_STONE_SMELTER = registerBlock("end_stone_smelter", new EndStoneSmelter());
	public static final RegistryObject<Block> ETERNAL_PEDESTAL = registerBlock("eternal_pedestal", new EternalPedestal());
	public static final RegistryObject<Block> INFUSION_PEDESTAL = registerBlock("infusion_pedestal", new InfusionPedestal());
	public static final RegistryObject<Block> AETERNIUM_ANVIL = registerBlock("aeternium_anvil", new AeterniumAnvil());
	
	// Technical
	public static final RegistryObject<Block> END_PORTAL_BLOCK = registerEndBlockOnly("end_portal_block", new EndPortalBlock());
	
	public static List<Block> getModBlocks() {
		return BlockRegistry.getModBlocks(BetterEndForge.MOD_ID);
	}
	
	public static List<Item> getModBlockItems() {
		return BlockRegistry.getModBlockItems(BetterEndForge.MOD_ID);
	}

	public static RegistryObject<Block> registerBlock(ResourceLocation id, Block block) {
		if (true) { //FIXME: CONFIG might remove completely
			getBlockRegistry().register(id, block);
		}
		return BLOCKS.register(id.getPath(), () -> block);
	}
	
	public static RegistryObject<Block> registerBlock(String name, Block block) {
		registerBlock(BetterEndForge.makeID(name), block);
		return BLOCKS.register(name, () -> block);
	}

	public static RegistryObject<Block> registerEndBlockOnly(String name, Block block) {
		getBlockRegistry().registerBlockOnly(BetterEndForge.makeID(name), block);
		return BLOCKS.register(name, () -> block);
	}
	/** We register the block items directly inside the BlockRegistry class, we might want to move it here tho **/

	public static Item.Properties makeBlockItemSettings() {
		return getBlockRegistry().makeItemSettings();
	}
	
	@NotNull
	public static BlockRegistry getBlockRegistry() {
		return REGISTRY;
	}
}
