package com.teamremastered.betterendforge.mixin.common.bclib;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.teamremastered.betterendforge.bclib.recipes.BCLRecipeManager;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
	@Shadow
	private MinecraftServer.ReloadableResources resources;

	@Final
	@Shadow
	private Map<ResourceKey<Level>, ServerLevel> levels;

	@Final
	@Shadow
	protected WorldData worldData;

	@Inject(method = "reloadResources", at = @At(value = "RETURN"), cancellable = true)
	private void bclib_reloadResources(Collection<String> collection, CallbackInfoReturnable<CompletableFuture<Void>> info) {
		bclib_injectRecipes();
	}

	@Inject(method = "loadLevel", at = @At(value = "RETURN"), cancellable = true)
	private void bclib_loadLevel(CallbackInfo info) {
		bclib_injectRecipes();
	}

	private void bclib_injectRecipes() {
		RecipeManagerAccessor accessor = (RecipeManagerAccessor) resources.managers().getRecipeManager();
		accessor.bclib_setRecipesByName(BCLRecipeManager.getMapByName(accessor.bclib_getRecipesByName()));
		accessor.bclib_setRecipes(BCLRecipeManager.getMap(accessor.bclib_getRecipes()));
	}
}
