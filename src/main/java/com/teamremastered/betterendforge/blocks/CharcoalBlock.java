package com.teamremastered.betterendforge.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CharcoalBlock extends BaseBlock {
	public CharcoalBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK));
	}

	@SubscribeEvent
	public static void FuelProperties(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().is(EndBlocks.CHARCOAL_BLOCK.get().asItem())) {
			event.setBurnTime(16000);
		}
	}
}