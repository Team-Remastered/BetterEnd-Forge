package ru.betterend.mixin.common.bclib.shears;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DiggingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.betterend.bclib.items.tool.BaseShearsItem;

@Mixin(DiggingEnchantment.class)
public class DiggingEnchantmentMixin {
	@Inject(method = "canEnchant(Lnet/minecraft/world/item/ItemStack;)Z", at = @At("HEAD"), cancellable = true)
	private void bclib_isShears(ItemStack itemStack, CallbackInfoReturnable<Boolean> info) {
		if (BaseShearsItem.isShear(itemStack)) info.setReturnValue(true);
	}
}
