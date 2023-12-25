package com.teamremastered.betterendforge.world.surface;

import com.teamremastered.betterendforge.registry.EndBiomes;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class BEFSurfaceRules {

    public static final SurfaceRules.ConditionSource WATER_CHECK = SurfaceRules.waterBlockCheck(-1, 0);

    protected static final SurfaceRules.RuleSource END_STONE = SurfaceRules.state(EndBiome.DefaultSurfaceMaterialProvider.END_STONE);
    protected static final SurfaceRules.RuleSource END_MOSS = SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource END_MOSS_TEST = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.FOGGY_MUSHROOMLAND.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.END_MOSS.get().defaultBlockState())))));
    protected static final SurfaceRules.RuleSource END_OTHER_TEST = SurfaceRules.ifTrue(SurfaceRules.isBiome(EndBiomes.END_BIOME_TEST.getKey()), SurfaceRules.sequence(SurfaceRules.ifTrue(WATER_CHECK, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(EndBlocks.END_MYCELIUM.get().defaultBlockState())))));

    protected static final SurfaceRules.RuleSource ENDSTONE_DUST = SurfaceRules.state(EndBlocks.ENDSTONE_DUST.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource END_MYCELIUM = SurfaceRules.state(EndBlocks.END_MYCELIUM.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource FLAVOLITE =SurfaceRules.state(EndBlocks.FLAVOLITE.stone.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource SULPHURIC_ROCK =SurfaceRules.state(EndBlocks.SULPHURIC_ROCK.stone.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource BRIMSTONE =SurfaceRules.state(EndBlocks.BRIMSTONE.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource PALLIDIUM_FULL =SurfaceRules.state(EndBlocks.PALLIDIUM_FULL.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource PALLIDIUM_HEAVY =SurfaceRules.state(EndBlocks.PALLIDIUM_HEAVY.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource PALLIDIUM_THIN =SurfaceRules.state(EndBlocks.PALLIDIUM_THIN.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource PALLIDIUM_TINY =SurfaceRules.state(EndBlocks.PALLIDIUM_TINY.get().defaultBlockState());
    protected static final SurfaceRules.RuleSource UMBRALITH =SurfaceRules.state(EndBlocks.UMBRALITH.stone.get().defaultBlockState());
    public static final SurfaceRules.RuleSource END_SURFACE_RULES = SurfaceRules.sequence(END_MOSS_TEST, END_OTHER_TEST);

}