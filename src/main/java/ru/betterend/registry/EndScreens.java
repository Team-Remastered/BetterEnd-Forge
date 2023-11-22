package ru.betterend.registry;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import ru.betterend.BetterEndForge;
import ru.betterend.client.gui.EndStoneSmelterScreen;
import ru.betterend.client.gui.EndStoneSmelterScreenHandler;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndScreens {

	@SubscribeEvent
	public static void registerScreens(FMLClientSetupEvent event) {
		MenuScreens.register(EndStoneSmelterScreenHandler.HANDLER_TYPE, EndStoneSmelterScreen::new);
	}
}