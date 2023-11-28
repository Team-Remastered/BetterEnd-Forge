package com.teamremastered.betterendforge.bclib.interfaces;

import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiome;

public interface BiomeChunk {
	void setBiome(int x, int z, BCLBiome biome);
	BCLBiome getBiome(int x, int z);
	int getSide();
}
