package com.teamremastered.betterendforge.registry.world;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID)
public class WorldGenerationEvent {

    @SubscribeEvent
    public static void BiomeLoadingEvent(final BiomeLoadingEvent event) {
        if (event.getName().equals(EndBiomes.FOGGY_MUSHROOMLAND.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.MOSSY_GLOWSHROOM_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.DENSE_VINE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CREEPING_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRELLA_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BLUE_VINE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CYAN_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CYAN_MOSS_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LILY_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BUBBLE_CORAL_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_CYAN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_LIGHT_BLUE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.CHORUS_FOREST.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.PYTHADENDRON_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.PYTHADENDRON_BUSH_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.PURPLE_POLYPORE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHORUS_GRASS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHORUS_MUSHROOM_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TAIL_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TAIL_MOSS_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.DUST_WASTELANDS.getId())) { }
        else if(event.getName().equals(EndBiomes.MEGALAKE.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LOTUS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LOTUS_LEAF_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BUBBLE_CORAL_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LILY_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRELLA_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CREEPING_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_CYAN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_LIGHT_BLUE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.MENGER_SPONGE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.MEGALAKE_GROVE.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LACUGROVE_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LOTUS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LOTUS_LEAF_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BUBBLE_CORAL_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.END_LILY_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRELLA_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CREEPING_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_CYAN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_LIGHT_BLUE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.MENGER_SPONGE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.CRYSTAL_MOUNTAINS.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CRYSTAL_GRASS_PLACED);
        }
        else if(event.getName().equals(EndBiomes.PAINTED_MOUNTAINS.getId())) { }
        else if(event.getName().equals(EndBiomes.SHADOW_FOREST.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LACUGROVE_TREE_PLACED);
//            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.VIOLECITE_LAYER);
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.DRAGON_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.DRAGON_TREE_BUSH_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SHADOW_PLANT_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.MURKWEED_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.NEEDLEGRASS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SHADOW_BERRY_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TWISTED_VINE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.PURPLE_POLYPORE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TAIL_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TAIL_MOSS_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_PURPLE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);

        }
        else if(event.getName().equals(EndBiomes.AMBER_LAND.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_RARE_PLACED);
//            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.AMBER_ORE);
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.HELIX_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LANCELEAF_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.GLOW_PILLAR_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.AMBER_GRASS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.AMBER_ROOT_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BULB_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BULB_MOSS_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_ORANGE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_PLACED);
        }
        else if(event.getName().equals(EndBiomes.BLOSSOMING_SPIRES.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SPIRE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.FLOATING_SPIRE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TENANEA_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TENANEA_BUSH_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BULB_VINE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BUSHY_GRASS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BUSHY_GRASS_WG_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BLOSSOM_BERRY_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TWISTED_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TWISTED_MOSS_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SILK_MOTH_NEST_PLACED);
        }
        else if(event.getName().equals(EndBiomes.SULPHUR_SPRINGS.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.GEYSER_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SURFACE_VENT_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.SULPHURIC_LAKE_PLACED);
//            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SULPHURIC_CAVE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.HYDRALUX_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_GREEN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_ORANGE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.UMBRELLA_JUNGLE.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRELLA_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.JELLYSHROOM_TREE_PLACED);
//            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SULPHURIC_CAVE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TWISTED_UMBRELLA_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SMALL_JELLYSHROOM_FLOOR_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.JUNGLE_GRASS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CYAN_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CYAN_MOSS_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.JUNGLE_FERN_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SMALL_JELLYSHROOM_WALL_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SMALL_JELLYSHROOM_WOOD_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SMALL_JELLYSHROOM_CEIL_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.JUNGLE_VINE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_CYAN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_GREEN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_LIGHT_BLUE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.GLOWING_GRASSLANDS.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LUMECORN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BLOOMING_COOKSONIA_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SALTEAGO_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.VAIOLUSH_FERN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.FRACTURN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRELLA_MOSS_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CREEPING_MOSS_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.TWISTED_UMBRELLA_MOSS_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_CYAN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_GREEN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_LIGHT_BLUE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.DRAGON_GRAVEYARDS.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacedFeatures.OBSIDIAN_PILLAR_BASEMENT_PLACED);
//            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.DRAGON_BONE_BLOCK_ORE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacedFeatures.FALLEN_PILLAR_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacedFeatures.OBSIDIAN_BOULDER_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.GIGANTIC_AMARANITA_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LARGE_AMARANITA_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.SMALL_AMARANITA_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.GLOBULAGUS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CLAWFERN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_GREEN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_LIGHT_BLUE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_RARE_PLACED);
        }
        else if(event.getName().equals(EndBiomes.DRY_SHRUBLAND.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LUCERNIA_BUSH_RARE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.ORANGO_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.AERIDIUM_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LUTEBUS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LAMELLARIUM_PLACED);
        }
        else if(event.getName().equals(EndBiomes.LANTERN_WOODS.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.END_LAKE_NORMAL_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.FLAMAEA_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LUCERNIA_TREE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LUCERNIA_BUSH_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.FILALUX_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.AERIDIUM_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.LAMELLARIUM_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.BOLUX_MUSHROOM_PLACED);
//            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.AURANT_POLYPORE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.POND_ANEMONE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_ORANGE_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.RUSCUS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.RUSCUS_WOOD_PLACED);
        }
        else if(event.getName().equals(EndBiomes.NEON_OASIS.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.DESERT_LAKE);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.NEON_CACTUS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRELLA_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CREEPING_MOSS_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_GREEN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_CYAN_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.CHARNIA_RED_PLACED);
        }
        else if(event.getName().equals(EndBiomes.UMBRA_VALLEY.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.LAKES, EndPlacedFeatures.DESERT_LAKE);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.UMBRALITH_ARCH_PLACED);
//            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.THIN_UMBRALITH_ARCH_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.INFLEXIA_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacedFeatures.FLAMMALIX_PLACED);
        }
        else if(event.getName().equals(EndBiomes.ICE_STARFIELD.getId())) {
            event.getGeneration().addFeature(GenerationStep.Decoration.RAW_GENERATION, EndPlacedFeatures.ICE_STAR_PLACED);
            event.getGeneration().addFeature(GenerationStep.Decoration.RAW_GENERATION, EndPlacedFeatures.ICE_STAR_SMALL_PLACED);
        }
    }
}