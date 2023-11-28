package com.teamremastered.betterendforge.mixin.common.bclib.shears;

import com.teamremastered.betterendforge.bclib.items.tool.BaseShearsItem;
import com.teamremastered.betterendforge.bclib.util.MethodReplace;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PumpkinBlock.class)
public abstract class PumpkinBlockMixin {
	@Inject(method = "use", at = @At("HEAD"))
	private void bclib_isShears(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult, CallbackInfoReturnable<InteractionResult> info) {
		MethodReplace.addItemReplace(Items.SHEARS, BaseShearsItem::isShear);
	}
}
