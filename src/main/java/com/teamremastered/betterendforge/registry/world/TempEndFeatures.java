package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.world.features.BCLFeature;
import com.teamremastered.betterendforge.bclib.world.features.DefaultFeature;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.features.BlueVineFeature;
import com.teamremastered.betterendforge.world.features.CharniaFeature;
import com.teamremastered.betterendforge.world.features.DoublePlantFeature;
import com.teamremastered.betterendforge.world.features.EndLilyFeature;
import com.teamremastered.betterendforge.world.features.ScatterFeature;
import com.teamremastered.betterendforge.world.features.SinglePlantFeature;
import com.teamremastered.betterendforge.world.features.UnderwaterPlantFeature;
import com.teamremastered.betterendforge.world.features.VineFeature;
import com.teamremastered.betterendforge.world.features.WallPlantFeature;
import com.teamremastered.betterendforge.world.features.WallPlantOnLogFeature;
import com.teamremastered.betterendforge.world.features.terrain.EndLakeFeature;
import com.teamremastered.betterendforge.world.features.trees.MossyGlowshroomFeature;
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

    /** FLOWERS **/
    public static final RegistryObject<ScatterFeature> CREEPING_MOSS = FEATURES.register("creeping_moss", () -> new SinglePlantFeature(EndBlocks.CREEPING_MOSS.get(), 5));
    public static final RegistryObject<DoublePlantFeature> UMBRELLA_MOSS = FEATURES.register("umbrella_moss", () -> new DoublePlantFeature(EndBlocks.UMBRELLA_MOSS.get(), EndBlocks.UMBRELLA_MOSS_TALL.get(), 5));

    /** WALL PLANTS **/
    public static final RegistryObject<WallPlantFeature> CYAN_MOSS = FEATURES.register("cyan_moss", () -> new WallPlantFeature(EndBlocks.CYAN_MOSS.get(), 3));
    public static final RegistryObject<WallPlantFeature> CYAN_MOSS_WOOD = FEATURES.register("cyan_moss_wood", () -> new WallPlantOnLogFeature(EndBlocks.CYAN_MOSS.get(), 4));

    /** WATER **/
    public static final RegistryObject<EndLilyFeature> END_LILY = FEATURES.register("end_lily", () -> new EndLilyFeature(6));
    public static final RegistryObject<UnderwaterPlantFeature> BUBBLE_CORAL = FEATURES.register("bubble_coral", () -> new UnderwaterPlantFeature(EndBlocks.BUBBLE_CORAL.get(), 6));
    public static final RegistryObject<UnderwaterPlantFeature> CHARNIA_CYAN = FEATURES.register("charnia_cyan", () -> new CharniaFeature(EndBlocks.CHARNIA_CYAN.get()));
    public static final RegistryObject<UnderwaterPlantFeature> CHARNIA_LIGHT_BLUE = FEATURES.register("charnia_light_blue", () -> new CharniaFeature(EndBlocks.CHARNIA_LIGHT_BLUE.get()));
    public static final RegistryObject<UnderwaterPlantFeature> CHARNIA_RED_RARE = FEATURES.register("charnia_red_rare", () -> new CharniaFeature(EndBlocks.CHARNIA_RED.get()));


    /** VINES **/
    public static final RegistryObject<BlueVineFeature> BLUE_VINE = FEATURES.register("blue_vine", () -> new BlueVineFeature());
    public static final RegistryObject<VineFeature> DENSE_VINE = FEATURES.register("dense_vine", () -> new VineFeature(EndBlocks.DENSE_VINE.get(),24));

    /** LAKES **/
    public static final RegistryObject<EndLakeFeature> END_LAKE = FEATURES.register("end_lake", () -> new EndLakeFeature());

}