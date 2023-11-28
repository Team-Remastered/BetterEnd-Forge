package com.teamremastered.betterendforge.bclib.world.biomes;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.Map;
import java.util.Set;

public class FabricBiomesData {
	public static final Map<ResourceKey<Biome>, Float> END_LAND_BIOMES = Maps.newHashMap();
	public static final Map<ResourceKey<Biome>, Float> END_VOID_BIOMES = Maps.newHashMap();
	public static final Set<ResourceKey<Biome>> NETHER_BIOMES = Sets.newHashSet();
}
