package com.teamremastered.betterendforge.mixin.common;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/** Copied from FabricAPI **/
@Mixin(SpawnPlacements.class)
public class SpawnRestrictionAccessor {
    @Invoker
    public static <T extends Mob> void callRegister(EntityType<T> type, SpawnPlacements.Type location, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        throw new AssertionError("This should not occur!");
    }
}
