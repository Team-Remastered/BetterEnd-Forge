package com.teamremastered.betterendforge.world.biome.end;

import com.teamremastered.betterendforge.registry.EndBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public record LayersBiomeData(SimpleWeightedRandomList<ResourceKey<Biome>> biomeWeights, int biomeSize) {

    public static final LayersBiomeData DEFAULT_END_ISLANDS = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.END_MIDLANDS, 2)
            .add(Biomes.END_BARRENS, 2)
            .add(Biomes.END_HIGHLANDS, 2)
            .add(Biomes.SMALL_END_ISLANDS, 0)
            .add(EndBiomes.FOGGY_MUSHROOMLAND.getKey(), 3)
            .add(EndBiomes.CHORUS_FOREST.getKey(), 3)
            .add(EndBiomes.MEGALAKE.getKey(), 3)
            .add(EndBiomes.MEGALAKE_GROVE.getKey(), 3)
            .add(EndBiomes.SHADOW_FOREST.getKey(), 3)
            .add(EndBiomes.AMBER_LAND.getKey(), 3)
            .add(EndBiomes.BLOSSOMING_SPIRES.getKey(), 3)
            .add(EndBiomes.SULPHUR_SPRINGS.getKey(), 3)
            .add(EndBiomes.UMBRELLA_JUNGLE.getKey(), 3)
            .add(EndBiomes.GLOWING_GRASSLANDS.getKey(), 3)
            .add(EndBiomes.LANTERN_WOODS.getKey(), 3)
            .add(EndBiomes.CRYSTAL_MOUNTAINS.getKey(), 3)
            .add(EndBiomes.PAINTED_MOUNTAINS.getKey(), 3)
            .add(EndBiomes.DRAGON_GRAVEYARDS.getKey(), 3)
            .add(EndBiomes.DRY_SHRUBLAND.getKey(), 3)
            .add(EndBiomes.NEON_OASIS.getKey(), 1)
            .add(EndBiomes.UMBRA_VALLEY.getKey(), 3)
            .add(Biomes.THE_END, 0)
            .build(), 3);

    public static final LayersBiomeData DEFAULT_END_VOID = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.SMALL_END_ISLANDS, 2)
            .build(), 3);

    public static final LayersBiomeData DEFAULT_END_SKY = new LayersBiomeData(
        SimpleWeightedRandomList.<ResourceKey<Biome>>builder()
            .add(Biomes.THE_END, 9)
            .build(), 3);
}