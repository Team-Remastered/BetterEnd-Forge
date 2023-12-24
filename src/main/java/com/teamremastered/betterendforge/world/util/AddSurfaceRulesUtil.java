package com.teamremastered.betterendforge.world.util;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.mixin.common.NoiseBasedChunkGeneratorAccessor;
import com.teamremastered.betterendforge.mixin.common.NoiseGeneratorSettingsAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.storage.WorldData;

public class AddSurfaceRulesUtil {

    public static void appendSurfaceRule(WorldData worldData, ResourceKey<LevelStem> levelStemKey, SurfaceRules.RuleSource ruleSource) {
        if (worldData == null) { // For some reason mods can make world data null as seen in some user crash logs, this makes that issue clearer for us.
            throw new NullPointerException("Minecraft server's world data is null, this should be impossible...");
        }
        LevelStem levelStem = worldData.worldGenSettings().dimensions().get(levelStemKey);
        if (levelStem == null) {
            BetterEndForge.LOGGER.error(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, Oh The Biomes You'll Go cannot support this operation.\nNot adding surface rules....", levelStemKey));
            return;
        }
        ChunkGenerator chunkGenerator = levelStem.generator();

        boolean hasBYGBiome = chunkGenerator.getBiomeSource().possibleBiomes().stream().anyMatch(biomeHolder -> biomeHolder.unwrapKey().orElseThrow().location().getNamespace().equals(BetterEndForge.MOD_ID));
        if (hasBYGBiome) {

            if (chunkGenerator instanceof NoiseBasedChunkGenerator) {
                NoiseGeneratorSettings noiseGeneratorSettings = ((NoiseBasedChunkGeneratorAccessor) chunkGenerator).be_getSettings().value();
                    ((NoiseGeneratorSettingsAccess) (Object) noiseGeneratorSettings).ex_setSurfaceRule(SurfaceRules.sequence(ruleSource, noiseGeneratorSettings.surfaceRule()));
            }
            else {
                throw new IllegalStateException(String.format("Surface rules for \"%s\" are required to load. Fix the Surface Rule config file found at: \"%s\""));
            }
        }
    }
}
