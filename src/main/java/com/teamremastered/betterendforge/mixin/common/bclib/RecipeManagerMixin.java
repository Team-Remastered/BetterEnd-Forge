package com.teamremastered.betterendforge.mixin.common.bclib;

import com.teamremastered.betterendforge.bclib.recipes.BCLRecipeManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Optional;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {
	@Shadow
	private <C extends Container, T extends Recipe<C>> Map<ResourceLocation, Recipe<C>> byType(RecipeType<T> type) {
		return null;
	}
	
	@Inject(method = "getRecipeFor", at = @At(value = "HEAD"), cancellable = true)
	private <C extends Container, T extends Recipe<C>> void bclib_getRecipeFor(RecipeType<T> type, C inventory, Level level, CallbackInfoReturnable<Optional<T>> info) {
		info.setReturnValue(BCLRecipeManager.getSortedRecipe(type, inventory, level, this::byType));
	}
}