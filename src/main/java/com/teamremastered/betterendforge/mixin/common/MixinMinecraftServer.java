package com.teamremastered.betterendforge.mixin.common;

import com.teamremastered.betterendforge.world.surface.BEFSurfaceRules;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.teamremastered.betterendforge.world.util.AddSurfaceRulesUtil.appendSurfaceRule;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Shadow
    public abstract WorldData getWorldData();

    @Inject(method = "createLevels", at = @At("RETURN"))
    private void hackyAddSurfaceRules(ChunkProgressListener $$0, CallbackInfo ci) {
            appendSurfaceRule(this.getWorldData(), LevelStem.END, BEFSurfaceRules.END_SURFACE_RULES);
    }
}