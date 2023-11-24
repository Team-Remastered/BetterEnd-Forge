package ru.betterend.bclib.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.main.GameConfig;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.WorldStem;
import net.minecraft.world.level.LevelSettings;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.LevelStorageSource.LevelStorageAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.betterend.bclib.api.LifeCycleAPI;
import ru.betterend.bclib.api.biomes.BiomeAPI;
import ru.betterend.bclib.api.dataexchange.DataExchangeAPI;
import ru.betterend.bclib.api.datafixer.DataFixerAPI;
import ru.betterend.bclib.config.Configs;
import ru.betterend.bclib.interfaces.CustomColorProvider;

import java.util.function.Function;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
	@Final
	@Shadow
	private BlockColors blockColors;
	
	@Final
	@Shadow
	private ItemColors itemColors;
	
	@Inject(method = "<init>*", at = @At("TAIL"))
	private void bclib_onMCInit(GameConfig args, CallbackInfo info) {
		Registry.BLOCK.forEach(block -> {
			if (block instanceof CustomColorProvider provider) {
				blockColors.register(provider.getProvider(), block);
				itemColors.register(provider.getItemProvider(), block.asItem());
			}
		});
	}

	@Shadow protected abstract void doLoadLevel(String string, Function<LevelStorageAccess, WorldStem.DataPackConfigSupplier> function, Function<LevelStorageAccess, WorldStem.WorldDataSupplier> function2, boolean bl, Minecraft.ExperimentalDialogType experimentalDialogType);

	@Shadow
	@Final
	private LevelStorageSource levelSource;
	
	@Inject(method = "loadLevel", cancellable = true, at = @At("HEAD"))
	private void bclib_callFixerOnLoad(String levelID, CallbackInfo ci) {
		DataExchangeAPI.prepareServerside();
		BiomeAPI.prepareNewLevel();
		
		if (DataFixerAPI.fixData(this.levelSource, levelID, true, (appliedFixes) -> {
			LifeCycleAPI._runBeforeLevelLoad();
			this.doLoadLevel(levelID, WorldStem.DataPackConfigSupplier::loadFromWorld, WorldStem.WorldDataSupplier::loadFromWorld, false, appliedFixes ? Minecraft.ExperimentalDialogType.NONE : Minecraft.ExperimentalDialogType.BACKUP);
		})) {
			//cancle call when fix-screen is presented
			ci.cancel();
		}
		else {
			LifeCycleAPI._runBeforeLevelLoad();
			if (Configs.CLIENT_CONFIG.suppressExperimentalDialog()) {
				this.doLoadLevel(levelID, WorldStem.DataPackConfigSupplier::loadFromWorld, WorldStem.WorldDataSupplier::loadFromWorld, false, Minecraft.ExperimentalDialogType.NONE);
				//cancle call as we manually start the level load here
				ci.cancel();
			}
		}
	}
	
	@Inject(method = "createLevel", at = @At("HEAD"))
	private void bclib_initPatchData(String levelID, LevelSettings levelSettings, RegistryAccess registryAccess, WorldGenSettings worldGenSettings, CallbackInfo ci) {
		DataExchangeAPI.prepareServerside();
		BiomeAPI.prepareNewLevel();
		
		DataFixerAPI.initializeWorldData(this.levelSource, levelID, true);
		LifeCycleAPI._runBeforeLevelLoad();
	}
}
