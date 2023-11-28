package com.teamremastered.betterendforge.bclib.interfaces;

import net.minecraft.world.level.biome.BiomeSource;

public interface SurfaceRuleProvider {
	void bclib_addBiomeSource(BiomeSource source);
	void bclib_clearBiomeSources();
}
