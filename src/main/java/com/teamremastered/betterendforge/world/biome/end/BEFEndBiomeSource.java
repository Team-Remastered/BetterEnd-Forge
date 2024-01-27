package com.teamremastered.betterendforge.world.biome.end;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiPredicate;

import static com.teamremastered.betterendforge.world.util.WorldUtil.createBiomesFromBiomeData;
import static net.minecraft.world.level.biome.TheEndBiomeSource.getHeightValue;

public abstract class BEFEndBiomeSource extends BiomeSource {
    public static final ResourceLocation LOCATION = new ResourceLocation(BetterEndForge.MOD_ID, "end");
    private final SimplexNoise islandNoise;
    private final Registry<Biome> biomeRegistry;
    private final BiomeResolver islandBiomeResolver;
    private final BiomeResolver voidBiomeResolver;
    private final BiomeResolver skyBiomeResolver;
    private final int skyLayersStartY;
    private final long seed;
    private final int skyLayerStart = 180;

    protected BEFEndBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(getPossibleBiomes(biomeRegistry));
        this.biomeRegistry = biomeRegistry;
        this.seed = seed;


        WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(seed));
        worldgenrandom.consumeCount(17292);
        this.islandNoise = new SimplexNoise(worldgenrandom);

        this.islandBiomeResolver = getIslandBiomeResolver(biomeRegistry, seed, LayersBiomeData.DEFAULT_END_ISLANDS);
        this.voidBiomeResolver = getVoidBiomeResolver(biomeRegistry, seed, LayersBiomeData.DEFAULT_END_VOID);
        this.skyBiomeResolver = getSkyBiomeResolver(biomeRegistry, seed, LayersBiomeData.DEFAULT_END_SKY);
        this.skyLayersStartY = QuartPos.fromBlock(skyLayerStart);
    }

    public abstract BiomeResolver getIslandBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData);

    public abstract BiomeResolver getVoidBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData);

    public abstract BiomeResolver getSkyBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData);


    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        int chunkX = x >> 2;
        int chunkZ = z >> 2;
        if ((long) chunkX * (long) chunkX + (long) chunkZ * (long) chunkZ <= 4096L) {
            return this.biomeRegistry.getHolderOrThrow(Biomes.THE_END);
        } else {
            if (y > this.skyLayersStartY) {
                return this.skyBiomeResolver.getNoiseBiome(x, y, z, sampler);
            } else {

                float heightValue = getHeightValue(this.islandNoise, chunkX * 2 + 1, chunkZ * 2 + 1);
                if (heightValue > 40.0F) {
                    return this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                } else if (heightValue >= 0.0F) {
                    return this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                } else {
                    return heightValue < -20.0F ? this.voidBiomeResolver.getNoiseBiome(x, y, z, sampler) : this.islandBiomeResolver.getNoiseBiome(x, y, z, sampler);
                }
            }
        }
    }

    protected Registry<Biome> getBiomeRegistry() {
        return biomeRegistry;
    }

    protected long getSeed() {
        return seed;
    }

    @NotNull
    private static List<Holder<Biome>> getPossibleBiomes(Registry<Biome> biomeRegistry) {

        Set<String> missingBiomes = new TreeSet<>();
        BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> {
            boolean biomeRegistryHas = biomeRegistry.containsKey(added);

            if (!biomeRegistryHas) {
                missingBiomes.add(added.location().toString());
            }

            return !existing.contains(added) && biomeRegistryHas;
        };

        LayersBiomeData usedIslandLayer = LayersBiomeData.DEFAULT_END_ISLANDS;
        LayersBiomeData usedVoidLayer = LayersBiomeData.DEFAULT_END_VOID;
        LayersBiomeData usedSkyLayer = LayersBiomeData.DEFAULT_END_SKY;

        List<Holder<Biome>> biomesFromBiomeData = createBiomesFromBiomeData(biomeRegistry, usedIslandLayer, usedVoidLayer, usedSkyLayer);
        biomesFromBiomeData.add(biomeRegistry.getHolderOrThrow(Biomes.THE_END));
        return biomesFromBiomeData;
    }
}