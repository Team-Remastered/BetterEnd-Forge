package com.teamremastered.betterendforge.world.biome.end;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamremastered.betterendforge.world.util.Area;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;

import static com.teamremastered.betterendforge.world.util.LayerUtil.createLayers;

public class BEFForgeEndBiomeSource extends BEFEndBiomeSource {

    public static final Codec<BEFForgeEndBiomeSource> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getBiomeRegistry();
        }), Codec.LONG.fieldOf("seed").stable().forGetter((bygEndBiomeSource) -> {
            return bygEndBiomeSource.getSeed();
        })).apply(builder, builder.stable(BEFForgeEndBiomeSource::new));
    });

    public BEFForgeEndBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(biomeRegistry, seed);
    }

    @Override
    public BiomeResolver getIslandBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData islandLayersBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, islandLayersBiomeData.biomeWeights(), islandLayersBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getVoidBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData voidLayersBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, voidLayersBiomeData.biomeWeights(), voidLayersBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    public BiomeResolver getSkyBiomeResolver(Registry<Biome> biomeRegistry, long seed, LayersBiomeData skyLayersBiomeData) {
        Area layers = createLayers(biomeRegistry, seed, skyLayersBiomeData.biomeWeights(), skyLayersBiomeData.biomeSize());
        return (x, y, z, sampler) -> biomeRegistry.getHolder(layers.get(x, z)).orElseThrow();
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long l) {
        return new BEFForgeEndBiomeSource(getBiomeRegistry(), l);
    }

}