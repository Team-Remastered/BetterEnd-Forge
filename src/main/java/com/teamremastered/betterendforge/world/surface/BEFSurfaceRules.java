package com.teamremastered.betterendforge.world.surface;

import com.teamremastered.betterendforge.registry.world.EndBiomes;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class BEFSurfaceRules {

    public static final SurfaceRules.ConditionSource WATER_CHECK = SurfaceRules.waterBlockCheck(-1, 0);

    protected static final SurfaceRules.RuleSource FOGGY_MUSHROOMLAND = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.FOGGY_MUSHROOMLAND.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource CHORUS_FOREST = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.CHORUS_FOREST.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.CHORUS_NYLIUM.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource DUST_WASTELANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.DUST_WASTELANDS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource CRYSTAL_MOUNTAINS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.CRYSTAL_MOUNTAINS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.CRYSTAL_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource PAINTED_MOUNTAINS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.PAINTED_MOUNTAINS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState())))));

    protected static final SurfaceRules.RuleSource MEGALAKE = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.MEGALAKE.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource MEGALAKE_GROVE = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.MEGALAKE_GROVE.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource SHADOW_FOREST = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.SHADOW_FOREST.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.SHADOW_GRASS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource AMBER_LAND = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.AMBER_LAND.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.AMBER_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource BLOSSOMING_SPIRES = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.BLOSSOMING_SPIRES.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.PINK_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource SULPHUR_SPRINGS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.SULPHUR_SPRINGS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.SULPHURIC_ROCK.stone.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource UMBRELLA_JUNGLE = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.UMBRELLA_JUNGLE.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.JUNGLE_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource GLOWING_GRASSLANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.GLOWING_GRASSLANDS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource LANTERN_WOODS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.LANTERN_WOODS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.RUTISCUS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource DRAGON_GRAVEYARDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.DRAGON_GRAVEYARDS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.SANGNUM.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource DRY_SHRUBLAND = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.DRY_SHRUBLAND.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.RUTISCUS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource NEON_OASIS = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.NEON_OASIS.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource UMBRA_VALLEY = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.UMBRA_VALLEY.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.UMBRALITH.stone.get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(EndBlocks.UMBRALITH.stone.get().defaultBlockState()))));

    protected static final SurfaceRules.RuleSource END_STONE = SurfaceRules.state(EndBiome.DefaultSurfaceMaterialProvider.END_STONE);
    protected static final SurfaceRules.RuleSource ENDSTONE_DUST = SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource END_MYCELIUM = SurfaceRules.state(EndBlocks.END_MYCELIUM.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource SULPHURIC_ROCK =SurfaceRules.state(EndBlocks.SULPHURIC_ROCK.stone.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource BRIMSTONE =SurfaceRules.state(EndBlocks.BRIMSTONE.get().defaultBlockState());
    public static final SurfaceRules.RuleSource END_SURFACE_RULES = SurfaceRules.sequence(FOGGY_MUSHROOMLAND, CHORUS_FOREST, MEGALAKE, MEGALAKE_GROVE, SHADOW_FOREST, AMBER_LAND, BLOSSOMING_SPIRES, SULPHUR_SPRINGS, UMBRELLA_JUNGLE, GLOWING_GRASSLANDS, LANTERN_WOODS, DUST_WASTELANDS, CRYSTAL_MOUNTAINS, PAINTED_MOUNTAINS, DRAGON_GRAVEYARDS, DRY_SHRUBLAND, NEON_OASIS, UMBRA_VALLEY);

}