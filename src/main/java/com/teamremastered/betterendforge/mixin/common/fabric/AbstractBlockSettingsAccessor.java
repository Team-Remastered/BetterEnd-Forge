package com.teamremastered.betterendforge.mixin.common.fabric;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockBehaviour.Properties.class)
public interface AbstractBlockSettingsAccessor {
    /* GETTERS */
    @Accessor
    Material getMaterial();

    @Accessor
    boolean getIsAir();


    /* SETTERS */
    @Accessor
    void setMaterial(Material material);

    @Accessor
    void setIsAir(boolean isAir);


}
