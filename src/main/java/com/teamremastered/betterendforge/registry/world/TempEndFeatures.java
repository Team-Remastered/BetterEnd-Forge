package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.api.features.BCLCommonFeatures;
import com.teamremastered.betterendforge.bclib.api.features.BCLFeatureBuilder;
import com.teamremastered.betterendforge.bclib.world.features.BCLFeature;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.biome.land.UmbraValleyBiome;
import com.teamremastered.betterendforge.world.features.*;
import com.teamremastered.betterendforge.world.features.bushes.*;
import com.teamremastered.betterendforge.world.features.terrain.*;
import com.teamremastered.betterendforge.world.features.terrain.caves.RoundCaveFeature;
import com.teamremastered.betterendforge.world.features.terrain.caves.TunelCaveFeature;
import com.teamremastered.betterendforge.world.features.trees.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TempEndFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BetterEndForge.MOD_ID);

    public static void initRegister(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }

    /** TREES **/
    public static final RegistryObject<DefaultFeature> MOSSY_GLOWSHROOM = FEATURES.register("mossy_glowshroom", MossyGlowshroomFeature::new);
    public static final RegistryObject<DefaultFeature> PYTHADENDRON_TREE = FEATURES.register("pythadendron_tree", PythadendronTreeFeature::new);

    public static final RegistryObject<DefaultFeature> LACUGROVE = FEATURES.register("lacugrove", LacugroveFeature::new);
    public static final RegistryObject<DefaultFeature> DRAGON_TREE = FEATURES.register("dragon_tree", DragonTreeFeature::new);
    public static final RegistryObject<DefaultFeature> TENANEA = FEATURES.register("tenanea", TenaneaFeature::new);
    public static final RegistryObject<DefaultFeature> HELIX_TREE = FEATURES.register("helix_tree", HelixTreeFeature::new);
    public static final RegistryObject<DefaultFeature> UMBRELLA_TREE = FEATURES.register("umbrella_tree", UmbrellaTreeFeature::new);
    public static final RegistryObject<DefaultFeature> JELLYSHROOM = FEATURES.register("jellyshroom", JellyshroomFeature::new);
    public static final RegistryObject<DefaultFeature> GIGANTIC_AMARANITA = FEATURES.register("gigantic_amaranita", GiganticAmaranitaFeature::new);
    public static final RegistryObject<DefaultFeature> LUCERNIA = FEATURES.register("lucernia", LucerniaFeature::new);

    /** FLOWERS **/
    public static final RegistryObject<ScatterFeature> CREEPING_MOSS = FEATURES.register("creeping_moss", () -> new SinglePlantFeature(EndBlocks.CREEPING_MOSS.get(), 5));
    public static final RegistryObject<DoublePlantFeature> UMBRELLA_MOSS = FEATURES.register("umbrella_moss", () -> new DoublePlantFeature(EndBlocks.UMBRELLA_MOSS.get(), EndBlocks.UMBRELLA_MOSS_TALL.get(), 5));
    public static final RegistryObject<SinglePlantFeature> CHORUS_GRASS = FEATURES.register("chorus_grass", () -> new SinglePlantFeature(EndBlocks.CHORUS_GRASS.get(), 4));
    public static final RegistryObject<SinglePlantFeature> CHORUS_MUSHROOM = FEATURES.register("chorus_mushroom", () -> new SinglePlantFeature(EndBlocks.CHORUS_MUSHROOM.get(), 3, 5));


    public static final RegistryObject<SinglePlantFeature> CRYSTAL_GRASS = FEATURES.register("crystal_grass", () -> new SinglePlantFeature(EndBlocks.CRYSTAL_GRASS.get(), 8, false));
    public static final RegistryObject<SinglePlantFeature> SHADOW_PLANT = FEATURES.register("shadow_plant", () -> new SinglePlantFeature(EndBlocks.SHADOW_PLANT.get(), 6));
    public static final RegistryObject<SinglePlantFeature> MURKWEED = FEATURES.register("murkweed", () -> new SinglePlantFeature(EndBlocks.MURKWEED.get(), 3));
    public static final RegistryObject<SinglePlantFeature> NEEDLEGRASS = FEATURES.register("needlegrass", () -> new SinglePlantFeature(EndBlocks.NEEDLEGRASS.get(), 3));
    public static final RegistryObject<SinglePlantFeature> SHADOW_BERRY = FEATURES.register("shadow_berry", () -> new SinglePlantFeature(EndBlocks.SHADOW_BERRY.get(), 2));
    public static final RegistryObject<SinglePlantFeature> BUSHY_GRASS = FEATURES.register("bushy_grass", () -> new SinglePlantFeature(EndBlocks.BUSHY_GRASS.get(), 8, false));
    public static final RegistryObject<SinglePlantFeature> BUSHY_GRASS_WG = FEATURES.register("bushy_grass_wg", () -> new SinglePlantFeature(EndBlocks.BUSHY_GRASS.get(), 5));
    public static final RegistryObject<SinglePlantFeature> AMBER_GRASS = FEATURES.register("amber_grass", () -> new SinglePlantFeature(EndBlocks.AMBER_GRASS.get(), 6));
    public static final RegistryObject<LanceleafFeature> LANCELEAF = FEATURES.register("lanceleaf", () -> new LanceleafFeature());
    public static final RegistryObject<GlowPillarFeature> GLOW_PILLAR = FEATURES.register("glow_pillar", () -> new GlowPillarFeature());
    public static final RegistryObject<DoublePlantFeature> TWISTED_UMBRELLA_MOSS = FEATURES.register("twisted_umbrella_moss", () -> new DoublePlantFeature(EndBlocks.TWISTED_UMBRELLA_MOSS.get(), EndBlocks.TWISTED_UMBRELLA_MOSS_TALL.get(), 6));
    public static final RegistryObject<SinglePlantFeature> JUNGLE_GRASS = FEATURES.register("jungle_grass", () -> new SinglePlantFeature(EndBlocks.JUNGLE_GRASS.get(), 7, 3));
    public static final RegistryObject<SinglePlantFeature> SMALL_JELLYSHROOM_FLOOR = FEATURES.register("small_jellyshroom_floor", () -> new SinglePlantFeature(EndBlocks.SMALL_JELLYSHROOM.get(), 5, 5));
    public static final RegistryObject<SinglePlantFeature> BLOSSOM_BERRY = FEATURES.register("blossom_berry", () -> new SinglePlantFeature(EndBlocks.BLOSSOM_BERRY.get(), 3, 3));
    public static final RegistryObject<SinglePlantFeature> BLOOMING_COOKSONIA = FEATURES.register("blooming_cooksonia", () -> new SinglePlantFeature(EndBlocks.BLOOMING_COOKSONIA.get(), 5));
    public static final RegistryObject<SinglePlantFeature> SALTEAGO = FEATURES.register("salteago", () -> new SinglePlantFeature(EndBlocks.SALTEAGO.get(), 5));
    public static final RegistryObject<SinglePlantFeature> VAIOLUSH_FERN = FEATURES.register("vaiolush_fern", () -> new SinglePlantFeature(EndBlocks.VAIOLUSH_FERN.get(), 5));
    public static final RegistryObject<SinglePlantFeature> FRACTURN = FEATURES.register("fracturn", () -> new SinglePlantFeature(EndBlocks.FRACTURN.get(), 5));
    public static final RegistryObject<SinglePlantFeature> UMBRELLA_MOSS_RARE = FEATURES.register("umbrella_moss_rare", () -> new SinglePlantFeature(EndBlocks.UMBRELLA_MOSS.get(), 3));
    public static final RegistryObject<SinglePlantFeature> CREEPING_MOSS_RARE = FEATURES.register("creeping_moss_rare", () -> new SinglePlantFeature(EndBlocks.CREEPING_MOSS.get(), 3));
    public static final RegistryObject<SinglePlantFeature> TWISTED_UMBRELLA_MOSS_RARE = FEATURES.register("twisted_umbrella_moss_rare", () -> new SinglePlantFeature(EndBlocks.TWISTED_UMBRELLA_MOSS.get(), 3));
    public static final RegistryObject<SinglePlantFeature> ORANGO = FEATURES.register("orango", () -> new SinglePlantFeature(EndBlocks.ORANGO.get(), 5));
    public static final RegistryObject<SinglePlantFeature> AERIDIUM = FEATURES.register("aeridium", () -> new SinglePlantFeature(EndBlocks.AERIDIUM.get(), 5, 4));
    public static final RegistryObject<SinglePlantFeature> LUTEBUS = FEATURES.register("lutebus", () -> new SinglePlantFeature(EndBlocks.LUTEBUS.get(), 5, 2));
    public static final RegistryObject<SinglePlantFeature> LAMELLARIUM = FEATURES.register("lamellarium", () -> new SinglePlantFeature(EndBlocks.LAMELLARIUM.get(), 5));
    public static final RegistryObject<SinglePlantFeature> SMALL_AMARANITA = FEATURES.register("small_amaranita", () -> new SinglePlantFeature(EndBlocks.SMALL_AMARANITA_MUSHROOM.get(), 5, 5));
    public static final RegistryObject<SinglePlantFeature> GLOBULAGUS = FEATURES.register("globulagus", () -> new SinglePlantFeature(EndBlocks.GLOBULAGUS.get(), 5, 3));
    public static final RegistryObject<SinglePlantFeature> CLAWFERN = FEATURES.register("clawfern", () -> new SinglePlantFeature(EndBlocks.CLAWFERN.get(), 5, 4));
    public static final RegistryObject<SinglePlantFeature> BOLUX_MUSHROOM = FEATURES.register("bolux_mushroom", () -> new SinglePlantFeature(EndBlocks.BOLUX_MUSHROOM.get(), 5, 5));
    public static final RegistryObject<SinglePlantFeature> AMBER_ROOT = FEATURES.register("amber_root", () -> new SinglePlantFeature(EndBlocks.AMBER_ROOT.get(), 5, 5));
    public static final RegistryObject<SinglePlantFeature> INFLEXIA = FEATURES.register("inflexia", () -> new SinglePlantFeature(EndBlocks.INFLEXIA.get(), 7, false, 3));
    public static final RegistryObject<SinglePlantFeature> FLAMMALIX = FEATURES.register("flammalix", () -> new SinglePlantFeature(EndBlocks.FLAMMALIX.get(), 3, false, 7));

    /** BUSHES **/
    public static final RegistryObject<BushFeature> PYTHADENDRON_BUSH = FEATURES.register("pythadendron_bush", () -> new BushFeature(EndBlocks.PYTHADENDRON_LEAVES.get(), EndBlocks.PYTHADENDRON.getBark()));
    public static final RegistryObject<BushFeature> DRAGON_TREE_BUSH = FEATURES.register("dragon_tree_bush", () -> new BushFeature(EndBlocks.DRAGON_TREE_LEAVES.get(), EndBlocks.DRAGON_TREE.getBark()));
    public static final RegistryObject<TenaneaBushFeature> TENANEA_BUSH = FEATURES.register("tenanea_bush", TenaneaBushFeature::new);
    public static final RegistryObject<Lumecorn> LUMECORN = FEATURES.register("lumecorn", Lumecorn::new);
    public static final RegistryObject<LargeAmaranitaFeature> LARGE_AMARANITA = FEATURES.register("large_amaranita", LargeAmaranitaFeature::new);
    public static final RegistryObject<BushWithOuterFeature> LUCERNIA_BUSH = FEATURES.register("lucernia_bush", () -> new BushWithOuterFeature(EndBlocks.LUCERNIA_LEAVES.get(), EndBlocks.LUCERNIA_OUTER_LEAVES.get(), EndBlocks.LUCERNIA.getBark()));
    public static final RegistryObject<BushWithOuterFeature> LUCERNIA_BUSH_RARE = FEATURES.register("lucernia_bush_rare", () -> new BushWithOuterFeature(EndBlocks.LUCERNIA_LEAVES.get(), EndBlocks.LUCERNIA_OUTER_LEAVES.get(), EndBlocks.LUCERNIA.getBark()));
    public static final RegistryObject<NeonCactusFeature> NEON_CACTUS = FEATURES.register("neon_cactus", NeonCactusFeature::new);

    /** WALL PLANTS **/
    public static final RegistryObject<WallPlantFeature>  TAIL_MOSS = FEATURES.register("tail_moss", () -> new WallPlantFeature(EndBlocks.TAIL_MOSS.get(), 3));
    public static final RegistryObject<WallPlantOnLogFeature> TAIL_MOSS_WOOD = FEATURES.register("tail_moss_wood", () -> new WallPlantOnLogFeature(EndBlocks.TAIL_MOSS.get(), 4));

    public static final RegistryObject<WallPlantFeature> PURPLE_POLYPORE = FEATURES.register("purple_polypore", () -> new WallPlantOnLogFeature(EndBlocks.PURPLE_POLYPORE.get(), 3));
    public static final RegistryObject<WallPlantFeature> CYAN_MOSS = FEATURES.register("cyan_moss", () -> new WallPlantFeature(EndBlocks.CYAN_MOSS.get(), 3));
    public static final RegistryObject<WallPlantFeature> CYAN_MOSS_WOOD = FEATURES.register("cyan_moss_wood", () -> new WallPlantOnLogFeature(EndBlocks.CYAN_MOSS.get(), 4));
    public static final RegistryObject<WallPlantFeature> TWISTED_MOSS = FEATURES.register("twisted_moss", () -> new WallPlantFeature(EndBlocks.TWISTED_MOSS.get(), 6));
    public static final RegistryObject<WallPlantOnLogFeature> TWISTED_MOSS_WOOD = FEATURES.register("twisted_moss_wood", () -> new WallPlantOnLogFeature(EndBlocks.TWISTED_MOSS.get(), 6));
    public static final RegistryObject<WallPlantFeature> BULB_MOSS = FEATURES.register("bulb_moss", () -> new WallPlantFeature(EndBlocks.BULB_MOSS.get(), 6));
    public static final RegistryObject<WallPlantOnLogFeature> BULB_MOSS_WOOD = FEATURES.register("bulb_moss_wood", () -> new WallPlantOnLogFeature(EndBlocks.BULB_MOSS.get(), 6));
    public static final RegistryObject<WallPlantFeature> SMALL_JELLYSHROOM_WALL = FEATURES.register("small_jellyshroom_wall",  () ->new WallPlantFeature(EndBlocks.SMALL_JELLYSHROOM.get(), 4));
    public static final RegistryObject<WallPlantOnLogFeature> SMALL_JELLYSHROOM_WOOD = FEATURES.register("small_jellyshroom_wood", () -> new WallPlantOnLogFeature(EndBlocks.SMALL_JELLYSHROOM.get(), 4));
    public static final RegistryObject<WallPlantOnLogFeature> JUNGLE_FERN_WOOD = FEATURES.register("jungle_fern_wood", () -> new WallPlantOnLogFeature(EndBlocks.JUNGLE_FERN.get(), 3));
    public static final RegistryObject<WallPlantFeature> RUSCUS = FEATURES.register("ruscus", () -> new WallPlantFeature(EndBlocks.RUSCUS.get(), 6));
    public static final RegistryObject<WallPlantOnLogFeature> RUSCUS_WOOD = FEATURES.register("ruscus_wood", () -> new WallPlantOnLogFeature(EndBlocks.RUSCUS.get(), 6));

    /** WATER **/
    public static final RegistryObject<EndLotusFeature> END_LOTUS = FEATURES.register("end_lotus", () -> new EndLotusFeature(7));
    public static final RegistryObject<EndLilyFeature> END_LILY = FEATURES.register("end_lily", () -> new EndLilyFeature(6));
    public static final RegistryObject<UnderwaterPlantFeature> BUBBLE_CORAL = FEATURES.register("bubble_coral", () -> new UnderwaterPlantFeature(EndBlocks.BUBBLE_CORAL.get(), 6));
    public static final RegistryObject<UnderwaterPlantFeature> BUBBLE_CORAL_RARE = FEATURES.register("bubble_coral_rare", () -> new UnderwaterPlantFeature(EndBlocks.BUBBLE_CORAL.get(), 3));
    public static final RegistryObject<UnderwaterPlantFeature> CHARNIA_CYAN = FEATURES.register("charnia_cyan", () -> new CharniaFeature(EndBlocks.CHARNIA_CYAN.get()));
    public static final RegistryObject<UnderwaterPlantFeature> CHARNIA_LIGHT_BLUE = FEATURES.register("charnia_light_blue", () -> new CharniaFeature(EndBlocks.CHARNIA_LIGHT_BLUE.get()));
    public static final RegistryObject<UnderwaterPlantFeature> CHARNIA_RED_RARE = FEATURES.register("charnia_red_rare", () -> new CharniaFeature(EndBlocks.CHARNIA_RED.get()));

    public static final RegistryObject<EndLilyFeature> END_LILY_RARE = FEATURES.register("end_lily_rare", () -> new EndLilyFeature(3));
    public static final RegistryObject<EndLotusLeafFeature> END_LOTUS_LEAF = FEATURES.register("end_lotus_leaf", () -> new EndLotusLeafFeature(20));
    public static final RegistryObject<HydraluxFeature> HYDRALUX = FEATURES.register("hydralux", () -> new HydraluxFeature(5));
    public static final RegistryObject<UnderwaterPlantFeature> POND_ANEMONE = FEATURES.register("pond_anemone", () -> new UnderwaterPlantFeature(EndBlocks.POND_ANEMONE.get(), 6));

    public static final RegistryObject<CharniaFeature> CHARNIA_RED = FEATURES.register("charnia_red", () -> new CharniaFeature(EndBlocks.CHARNIA_RED.get()));
    public static final RegistryObject<CharniaFeature> CHARNIA_PURPLE = FEATURES.register("charnia_purple", () -> new CharniaFeature(EndBlocks.CHARNIA_PURPLE.get()));
    public static final RegistryObject<CharniaFeature> CHARNIA_ORANGE = FEATURES.register("charnia_orange", () -> new CharniaFeature(EndBlocks.CHARNIA_ORANGE.get()));
    public static final RegistryObject<CharniaFeature> CHARNIA_GREEN = FEATURES.register("charnia_green", () -> new CharniaFeature(EndBlocks.CHARNIA_GREEN.get()));
    public static final RegistryObject<MengerSpongeFeature> MENGER_SPONGE = FEATURES.register("menger_sponge", () -> new MengerSpongeFeature(5));
    public static final RegistryObject<BiomeIslandFeature> BIOME_ISLAND = FEATURES.register("overworld_island", () -> new BiomeIslandFeature());
    public static final RegistryObject<SinglePlantFeature> FLAMAEA = FEATURES.register("flamaea", () -> new SinglePlantFeature(EndBlocks.FLAMAEA.get(), 12, false, 5));


    /** VINES **/
    public static final RegistryObject<BlueVineFeature> BLUE_VINE = FEATURES.register("blue_vine", () -> new BlueVineFeature());
    public static final RegistryObject<VineFeature> DENSE_VINE = FEATURES.register("dense_vine", () -> new VineFeature(EndBlocks.DENSE_VINE.get(),24));
    public static final RegistryObject<VineFeature> TWISTED_VINE = FEATURES.register("twisted_vine", () -> new VineFeature(EndBlocks.TWISTED_VINE.get(), 24));
    public static final RegistryObject<VineFeature> BULB_VINE = FEATURES.register("bulb_vine", () -> new VineFeature(EndBlocks.BULB_VINE.get(), 24));
    public static final RegistryObject<VineFeature> JUNGLE_VINE = FEATURES.register("jungle_vine", () -> new VineFeature(EndBlocks.JUNGLE_VINE.get(), 24));

    /** LAKES **/
    public static final RegistryObject<EndLakeFeature> END_LAKE = FEATURES.register("end_lake", () -> new EndLakeFeature());
    public static final RegistryObject<EndLakeFeature> END_LAKE_RARE = FEATURES.register("end_lake_rare", () -> new EndLakeFeature());

    /** TERRAIN **/
    public static final RegistryObject<EndLakeFeature> END_LAKE_NORMAL = FEATURES.register("end_lake_normal", EndLakeFeature::new);
    public static final RegistryObject<DesertLakeFeature> DESERT_LAKE = FEATURES.register("desert_lake", DesertLakeFeature::new);
    public static final RegistryObject<RoundCaveFeature> ROUND_CAVE = FEATURES.register("round_cave", RoundCaveFeature::new);
    public static final RegistryObject<SpireFeature> SPIRE = FEATURES.register("spire", SpireFeature::new);
    public static final RegistryObject<FloatingSpireFeature> FLOATING_SPIRE = FEATURES.register("floating_spire", FloatingSpireFeature::new);
    public static final RegistryObject<GeyserFeature> GEYSER = FEATURES.register("geyser", GeyserFeature::new);
    public static final RegistryObject<SulphuricLakeFeature> SULPHURIC_LAKE = FEATURES.register("sulphuric_lake", SulphuricLakeFeature::new);
//    public static final RegistryObject<SulphuricCaveFeature> SULPHURIC_CAVE = BCLCommonFeatures.makeCountFeature(BetterEndForge.makeID("sulphuric_cave"), GenerationStep.Decoration.RAW_GENERATION, new SulphuricCaveFeature());
    public static final RegistryObject<IceStarFeature> ICE_STAR = FEATURES.register("ice_star", () -> new IceStarFeature(5, 15, 10, 25));
    public static final RegistryObject<IceStarFeature> ICE_STAR_SMALL = FEATURES.register("ice_star_small", () -> new IceStarFeature(3, 5, 7, 12));
    public static final RegistryObject<SurfaceVentFeature> SURFACE_VENT = FEATURES.register("surface_vent", SurfaceVentFeature::new);
    public static final RegistryObject<SulphurHillFeature> SULPHUR_HILL = FEATURES.register("sulphur_hill", SulphurHillFeature::new);
    public static final RegistryObject<ObsidianPillarBasementFeature> OBSIDIAN_PILLAR_BASEMENT = FEATURES.register("obsidian_pillar_basement", ObsidianPillarBasementFeature::new);
    public static final RegistryObject<ObsidianBoulderFeature> OBSIDIAN_BOULDER = FEATURES.register("obsidian_boulder", ObsidianBoulderFeature::new);
    public static final RegistryObject<FallenPillarFeature> FALLEN_PILLAR = FEATURES.register("fallen_pillar", FallenPillarFeature::new);
    // public static final RegistryObject<TunelCaveFeature> TUNEL_CAVE = BCLCommonFeatures.makeChunkFeature(BetterEndForge.makeID("tunel_cave"), GenerationStep.Decoration.RAW_GENERATION, new TunelCaveFeature());
    public static final RegistryObject<ArchFeature> UMBRALITH_ARCH = FEATURES.register("umbralith_arch", () -> new ArchFeature(
            EndBlocks.UMBRALITH.stone.get(), pos -> UmbraValleyBiome.getSurface(pos.getX(), pos.getZ()).defaultBlockState()));

    /** CEIL PLANTS **/
    public static final RegistryObject<SingleInvertedScatterFeature> SMALL_JELLYSHROOM_CEIL = FEATURES.register("small_jellyshroom_ceil", () -> new SingleInvertedScatterFeature(EndBlocks.SMALL_JELLYSHROOM.get(), 8));

    /** SKY PLANTS **/
    public static final RegistryObject<FilaluxFeature> FILALUX = FEATURES.register("filalux", FilaluxFeature::new);

    /** BUILDING **/
    public static final RegistryObject<CrashedShipFeature> CRASHED_SHIP = FEATURES.register("crashed_ship", CrashedShipFeature::new);

    /** MOBS **/
    public static final RegistryObject<SilkMothNestFeature> SILK_MOTH_NEST = FEATURES.register("silk_moth_nest", SilkMothNestFeature::new);

    /** ORES **/

}