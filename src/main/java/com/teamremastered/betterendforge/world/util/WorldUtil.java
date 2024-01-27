package com.teamremastered.betterendforge.world.util;

import com.google.common.collect.ImmutableList;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.mixin.common.WeightedListAccess;
import com.teamremastered.betterendforge.world.biome.end.LayersBiomeData;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorldUtil {

    @SuppressWarnings("unchecked")
    public static List<Holder<Biome>> createBiomesFromBiomeData(Registry<Biome> biomeRegistry, LayersBiomeData... layersBiomeDatas) {
        List<Holder<Biome>> biomes = new ArrayList<>();
        for (LayersBiomeData layersBiomeData : layersBiomeDatas) {
            ImmutableList<WeightedEntry.Wrapper<ResourceKey<Biome>>> items = ((WeightedListAccess<WeightedEntry.Wrapper<ResourceKey<Biome>>>) layersBiomeData.biomeWeights()).ex_getItems();

            for (WeightedEntry.Wrapper<ResourceKey<Biome>> key : items) {
                ResourceKey<Biome> resourceKey = key.getData();
                Optional<Holder<Biome>> biome = biomeRegistry.getHolder(resourceKey);
                if (biome.isPresent()) {
                    biomes.add(biome.get());
                } else {
                    BetterEndForge.LOGGER.info("\"" + resourceKey.location() + "\" is not a value in the biome registry at this point, ignore this warning if the data pack containing this biome is not yet added during world creation.");
                }
            }
        }
        return biomes;
    }
}