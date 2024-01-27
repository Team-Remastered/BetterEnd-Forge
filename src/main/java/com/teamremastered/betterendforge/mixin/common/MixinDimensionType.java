package com.teamremastered.betterendforge.mixin.common;

import com.mojang.serialization.Lifecycle;
import com.teamremastered.betterendforge.world.biome.end.BEFEndBiomeSource;
import com.teamremastered.betterendforge.world.biome.end.BEFForgeEndBiomeSource;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @Inject(method = "defaultDimensions(Lnet/minecraft/core/RegistryAccess;J)Lnet/minecraft/core/Registry;", at = @At("RETURN"), cancellable = true)
    private static void useExampleModEndBiomes(RegistryAccess registryAccess, long seed, CallbackInfoReturnable<MappedRegistry<LevelStem>> cir) {
        MappedRegistry<LevelStem> returnValue = cir.getReturnValue();
        MappedRegistry<LevelStem> newRegistry = new MappedRegistry<>(Registry.LEVEL_STEM_REGISTRY, Lifecycle.stable(), null);
        Registry<DimensionType> dimensionTypeRegistry = registryAccess.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);
        Registry<NoiseGeneratorSettings> noiseGeneratorSettingsRegistry = registryAccess.registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY);
        Registry<StructureSet> structureSetRegistry = registryAccess.registryOrThrow(Registry.STRUCTURE_SET_REGISTRY);

        Registry<Biome> biomeRegistry = registryAccess.registryOrThrow(Registry.BIOME_REGISTRY);
        Registry<NormalNoise.NoiseParameters> noiseParameters = registryAccess.registryOrThrow(Registry.NOISE_REGISTRY);

        for (LevelStem levelStem : returnValue) {
            ResourceKey<LevelStem> levelStemResourceKey = returnValue.getResourceKey(levelStem).get();
              if (levelStemResourceKey == LevelStem.END) {
                newRegistry.register(levelStemResourceKey, new LevelStem(dimensionTypeRegistry.getHolderOrThrow(DimensionType.END_LOCATION),
                    new NoiseBasedChunkGenerator(structureSetRegistry, noiseParameters,
                        new BEFForgeEndBiomeSource(biomeRegistry, seed), seed, noiseGeneratorSettingsRegistry.getHolderOrThrow(NoiseGeneratorSettings.END)
                    )
                ), Lifecycle.stable());
            } else {
                newRegistry.register(levelStemResourceKey, levelStem, Lifecycle.stable());
            }
        }
        cir.setReturnValue(newRegistry);
    }
}