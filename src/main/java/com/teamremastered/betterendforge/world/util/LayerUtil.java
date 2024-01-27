package com.teamremastered.betterendforge.world.util;

import com.teamremastered.betterendforge.interfaces.AreaFactory;
import com.teamremastered.betterendforge.interfaces.ZoomLayer;
import com.teamremastered.betterendforge.mixin.common.WeightedListAccess;
import com.teamremastered.betterendforge.noise.AreaTransformer0;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

import static com.teamremastered.betterendforge.noise.LayeredNoiseUtil.zoom;

public class LayerUtil {

    public static Area createLayers(Registry<Biome> biomeRegistry, long worldSeed, SimpleWeightedRandomList<ResourceKey<Biome>> biomes, int regionSize) {
        LongFunction<AreaContext> contextFactory = (seedModifier) -> new AreaContext(25, worldSeed, seedModifier);
        AreaFactory factory = new InitLayer(biomes, biomeRegistry).run(contextFactory.apply(1L));
        factory = ZoomLayer.FUZZY.run(contextFactory.apply(2000L), factory);
        factory = zoom(2001L, ZoomLayer.FUZZY, factory, 3, contextFactory);
        factory = zoom(1001L, ZoomLayer.NORMAL, factory, regionSize, contextFactory);
        return factory.make();
    }

    @SuppressWarnings("unchecked")
    private static class InitLayer implements AreaTransformer0 {

        private final SimpleWeightedRandomList<ResourceKey<Biome>> biomes;
        private final Registry<Biome> biomeRegistry;
        private final int totalWeight;
        private final List<WeightedEntry> entries;

        public InitLayer(SimpleWeightedRandomList<ResourceKey<Biome>> biomes, Registry<Biome> biomeRegistry) {
            this.biomes = biomes;
            this.biomeRegistry = biomeRegistry;
            this.totalWeight = ((WeightedListAccess<ResourceKey<Biome>>) this.biomes).ex_getTotalWeight();
            this.entries = ((WeightedListAccess<WeightedEntry>) this.biomes).ex_getItems();
        }

        @Override
        public int apply(AreaContext areaContext, int x, int z) {
            if (totalWeight == 0) {
                return biomeRegistry.getId(biomeRegistry.get(Biomes.OCEAN));
            }
            Optional<WeightedEntry> weightedItem = WeightedRandom.getWeightedItem(this.entries, areaContext.nextRandom(this.totalWeight));
            WeightedEntry.Wrapper<ResourceKey<Biome>> resourceKeyWrapper = (WeightedEntry.Wrapper<ResourceKey<Biome>>) weightedItem.get();
            ResourceKey<Biome> key = resourceKeyWrapper.getData();
            if (!this.biomeRegistry.containsKey(key)) {
                throw new IllegalArgumentException(String.format("\"%s\" is not a valid biome in the registry, fix the ID or remove the json entry from the config: \"%s\" and relaunch Minecraft...", key));
            }

            return biomeRegistry.getId(biomeRegistry.get(key));
        }
    }
}