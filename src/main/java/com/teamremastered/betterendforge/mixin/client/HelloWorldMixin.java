package com.teamremastered.betterendforge.mixin.client;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class HelloWorldMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        BetterEndForge.LOGGER.info("Hello World from a mixin");
    }
}