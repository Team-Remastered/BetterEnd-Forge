package com.teamremastered.betterendforge.mixin.common;

import net.minecraft.world.level.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.teamremastered.betterendforge.world.generator.GeneratorOptions;

@Mixin(value = DimensionType.class, priority = 100)
public class DimensionTypeMixin {
	@Inject(method = "createDragonFight", at = @At("HEAD"), cancellable = true)
	private void be_hasEnderDragonFight(CallbackInfoReturnable<Boolean> info) {
		if (!GeneratorOptions.hasDragonFights()) {
			info.setReturnValue(false);
		}
	}
}