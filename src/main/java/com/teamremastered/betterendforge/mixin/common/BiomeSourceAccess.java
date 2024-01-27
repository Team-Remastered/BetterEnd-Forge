package com.teamremastered.betterendforge.mixin.common;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(BiomeSource.class)
public interface BiomeSourceAccess {

    @Accessor("possibleBiomes")
    Set<Holder<Biome>> ex_getPossibleBiomes();
}
