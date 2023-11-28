package com.teamremastered.betterendforge.mixin.common.bclib.shears;

import com.teamremastered.betterendforge.bclib.items.tool.BaseShearsItem;
import com.teamremastered.betterendforge.bclib.util.MethodReplace;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TripWireBlock.class)
public class TripWireBlockMixin {
	@Inject(method = "playerWillDestroy(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/entity/player/Player;)V", at = @At("HEAD"))
	private void bclib_isShears(Level level, BlockPos blockPos, BlockState blockState, Player player, CallbackInfo info) {
		MethodReplace.addItemReplace(Items.SHEARS, BaseShearsItem::isShear);
	}
}
