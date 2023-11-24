package ru.betterend.mixin.common.bclib.shears;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.betterend.bclib.items.tool.BaseShearsItem;
import ru.betterend.bclib.util.MethodReplace;

@Mixin(Sheep.class)
public class SheepMixin {
	@Inject(method = "mobInteract(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResult;", at = @At("HEAD"))
	private void bclib_isShears(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> info) {
		MethodReplace.addItemReplace(Items.SHEARS, BaseShearsItem::isShear);
	}
}
