package com.teamremastered.betterendforge.bclib.api.biomes;

import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import com.google.common.base.Preconditions;
import org.jetbrains.annotations.ApiStatus;

/**
 * Internal data for modding Vanilla's {@link TheEndBiomeSource}.
 */
@ApiStatus.Internal
public final class TheEndBiomeData {
    private static final Map<ResourceKey<Biome>, WeightedPicker<ResourceKey<Biome>>> END_BIOMES_MAP = new IdentityHashMap<>();
    private static final Map<ResourceKey<Biome>, WeightedPicker<ResourceKey<Biome>>> END_MIDLANDS_MAP = new IdentityHashMap<>();
    private static final Map<ResourceKey<Biome>, WeightedPicker<ResourceKey<Biome>>> END_BARRENS_MAP = new IdentityHashMap<>();

    static {
        END_BIOMES_MAP.computeIfAbsent(Biomes.THE_END, key -> new WeightedPicker<>())
                .add(Biomes.THE_END, 1.0);
        END_BIOMES_MAP.computeIfAbsent(Biomes.END_HIGHLANDS, key -> new WeightedPicker<>())
                .add(Biomes.END_HIGHLANDS, 1.0);
        END_BIOMES_MAP.computeIfAbsent(Biomes.SMALL_END_ISLANDS, key -> new WeightedPicker<>())
                .add(Biomes.SMALL_END_ISLANDS, 1.0);

        END_MIDLANDS_MAP.computeIfAbsent(Biomes.END_HIGHLANDS, key -> new WeightedPicker<>())
                .add(Biomes.END_MIDLANDS, 1.0);
        END_BARRENS_MAP.computeIfAbsent(Biomes.END_HIGHLANDS, key -> new WeightedPicker<>())
                .add(Biomes.END_BARRENS, 1.0);
    }

    private TheEndBiomeData() {
    }

    public static void addEndBiomeReplacement(ResourceKey<Biome> replaced, ResourceKey<Biome> variant, double weight) {
        Preconditions.checkNotNull(replaced, "replaced entry is null");
        Preconditions.checkNotNull(variant, "variant entry is null");
        Preconditions.checkArgument(weight > 0.0, "Weight is less than or equal to 0.0 (got %s)", weight);
        END_BIOMES_MAP.computeIfAbsent(replaced, key -> new WeightedPicker<>()).add(variant, weight);
    }

    public static void addEndMidlandsReplacement(ResourceKey<Biome> highlands, ResourceKey<Biome> midlands, double weight) {
        Preconditions.checkNotNull(highlands, "highlands entry is null");
        Preconditions.checkNotNull(midlands, "midlands entry is null");
        Preconditions.checkArgument(weight > 0.0, "Weight is less than or equal to 0.0 (got %s)", weight);
        END_MIDLANDS_MAP.computeIfAbsent(highlands, key -> new WeightedPicker<>()).add(midlands, weight);
    }

    public static void addEndBarrensReplacement(ResourceKey<Biome> highlands, ResourceKey<Biome> barrens, double weight) {
        Preconditions.checkNotNull(highlands, "highlands entry is null");
        Preconditions.checkNotNull(barrens, "midlands entry is null");
        Preconditions.checkArgument(weight > 0.0, "Weight is less than or equal to 0.0 (got %s)", weight);
        END_BARRENS_MAP.computeIfAbsent(highlands, key -> new WeightedPicker<>()).add(barrens, weight);
    }

    public static Overrides createOverrides(Registry<Biome> biomeRegistry, long seed) {
        return new Overrides(biomeRegistry, seed);
    }

    /**
     * An instance of this class is attached to each {@link TheEndBiomeSource}.
     */
    public static class Overrides {
        private final ImprovedNoise sampler;

        // Vanilla entries to compare against
        private final Holder<Biome> endMidlands;
        private final Holder<Biome> endBarrens;
        private final Holder<Biome> endHighlands;

        // Maps where the keys have been resolved to actual entries
        private final Map<Holder<Biome>, WeightedPicker<Holder<Biome>>> endBiomesMap;
        private final Map<Holder<Biome>, WeightedPicker<Holder<Biome>>> endMidlandsMap;
        private final Map<Holder<Biome>, WeightedPicker<Holder<Biome>>> endBarrensMap;

        public Overrides(Registry<Biome> biomeRegistry, long seed) {
            this.sampler = new ImprovedNoise(new WorldgenRandom(new LegacyRandomSource(seed)));
            this.endMidlands = biomeRegistry.getHolderOrThrow(Biomes.END_MIDLANDS);
            this.endBarrens = biomeRegistry.getHolderOrThrow(Biomes.END_BARRENS);
            this.endHighlands = biomeRegistry.getHolderOrThrow(Biomes.END_HIGHLANDS);

            this.endBiomesMap = resolveOverrides(biomeRegistry, END_BIOMES_MAP);
            this.endMidlandsMap = resolveOverrides(biomeRegistry, END_MIDLANDS_MAP);
            this.endBarrensMap = resolveOverrides(biomeRegistry, END_BARRENS_MAP);
        }

        // Resolves all RegistryKey instances to RegistryEntries
        private Map<Holder<Biome>, WeightedPicker<Holder<Biome>>> resolveOverrides(Registry<Biome> biomeRegistry, Map<ResourceKey<Biome>, WeightedPicker<ResourceKey<Biome>>> overrides) {
            var result = new IdentityHashMap<Holder<Biome>, WeightedPicker<Holder<Biome>>>(overrides.size());

            for (Map.Entry<ResourceKey<Biome>, WeightedPicker<ResourceKey<Biome>>> entry : overrides.entrySet()) {
                result.put(biomeRegistry.getHolderOrThrow(entry.getKey()), entry.getValue().map(biomeRegistry::getHolderOrThrow));
            }

            return result;
        }

        public Holder<Biome> pick(int x, int y, int z, Holder<Biome> vanillaBiome) {
            Holder<Biome> replacementKey;

            // The x and z of the entry are divided by 64 to ensure custom biomes are large enough; going larger than this]
            // seems to make custom biomes too hard to find.
            if (vanillaBiome == endMidlands || vanillaBiome == endBarrens) {
                // Since the highlands picker is statically populated by InternalBiomeData, picker will never be null.
                WeightedPicker<Holder<Biome>> highlandsPicker = endBiomesMap.get(endHighlands);
                Holder<Biome> highlandsKey = highlandsPicker.pickFromNoise(sampler, x / 64.0, 0, z / 64.0);

                if (vanillaBiome == endMidlands) {
                    WeightedPicker<Holder<Biome>> midlandsPicker = endMidlandsMap.get(highlandsKey);
                    replacementKey = (midlandsPicker == null) ? vanillaBiome : midlandsPicker.pickFromNoise(sampler, x / 64.0, 0, z / 64.0);
                } else {
                    WeightedPicker<Holder<Biome>> barrensPicker = endBarrensMap.get(highlandsKey);
                    replacementKey = (barrensPicker == null) ? vanillaBiome : barrensPicker.pickFromNoise(sampler, x / 64.0, 0, z / 64.0);
                }
            } else {
                // Since the main island and small islands pickers are statically populated by InternalBiomeData, picker will never be null.
                WeightedPicker<Holder<Biome>> picker = endBiomesMap.get(vanillaBiome);
                replacementKey = picker.pickFromNoise(sampler, x / 64.0, 0, z / 64.0);
            }

            return replacementKey;
        }
    }
}
