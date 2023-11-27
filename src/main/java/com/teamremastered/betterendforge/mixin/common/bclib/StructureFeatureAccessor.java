package com.teamremastered.betterendforge.mixin.common.bclib;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(StructureFeature.class)
public interface  StructureFeatureAccessor {
    @Invoker
    static <F extends StructureFeature<?>> F callRegister(String name, F structureFeature, GenerationStep.Decoration step) {
        throw new RuntimeException("Unexpected call");
    }
}
