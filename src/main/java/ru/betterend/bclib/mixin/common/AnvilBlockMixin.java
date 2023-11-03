package ru.betterend.bclib.mixin.common;

import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.betterend.bclib.blocks.BaseAnvilBlock;

@Mixin(AnvilBlock.class)
public class AnvilBlockMixin {
	@Inject(method = "damage", at = @At("HEAD"), cancellable = true)
	private static void bclib_anvilDamage(BlockState state, CallbackInfoReturnable<BlockState> info) {
		if (state.getBlock() instanceof BaseAnvilBlock) {
			BaseAnvilBlock anvil = (BaseAnvilBlock) state.getBlock();
			info.setReturnValue(anvil.damageAnvilFall(state));
		}
	}
}
