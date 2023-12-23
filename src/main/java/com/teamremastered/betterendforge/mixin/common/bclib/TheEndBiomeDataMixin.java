package com.teamremastered.betterendforge.mixin.common.bclib;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.teamremastered.betterendforge.bclib.api.biomes.TheEndBiomeData;
import com.teamremastered.betterendforge.bclib.world.biomes.FabricBiomesData;

@Mixin(value = TheEndBiomeData.class, remap = false)
public class TheEndBiomeDataMixin {
	@Inject(method = "addEndBiomeReplacement", at = @At(value = "HEAD"))
	private static void bclib_addEndBiomeReplacement(ResourceKey<Biome> replaced, ResourceKey<Biome> variant, double weight, CallbackInfo info) {
		if (replaced == Biomes.END_BARRENS || replaced == Biomes.SMALL_END_ISLANDS) {
			FabricBiomesData.END_VOID_BIOMES.put(variant, (float) weight);
		}
		else {
			FabricBiomesData.END_LAND_BIOMES.put(variant, (float) weight);
		}
	}

	@Inject(method = "addEndMidlandsReplacement", at = @At(value = "HEAD"))
	private static void bclib_addEndMidlandsReplacement(ResourceKey<Biome> highlands, ResourceKey<Biome> midlands, double weight, CallbackInfo info) {
		FabricBiomesData.END_LAND_BIOMES.put(midlands, (float) weight);
	}

	@Inject(method = "addEndBarrensReplacement", at = @At(value = "HEAD"))
	private static void bclib_addEndBarrensReplacement(ResourceKey<Biome> highlands, ResourceKey<Biome> barrens, double weight, CallbackInfo info) {
		FabricBiomesData.END_LAND_BIOMES.put(barrens, (float) weight);
		FabricBiomesData.END_VOID_BIOMES.put(barrens, (float) weight);
	}
}
