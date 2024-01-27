package com.teamremastered.betterendforge.mixin.common;

import com.google.common.collect.ImmutableList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(net.minecraft.util.random.WeightedRandomList.class)
public interface WeightedListAccess<E> {

    @Accessor("totalWeight")
    int ex_getTotalWeight();

    @Accessor("items")
    ImmutableList<E> ex_getItems();
}