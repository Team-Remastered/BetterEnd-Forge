package ru.betterend.registry;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.BetterEndForge;
import ru.betterend.client.gui.EndStoneSmelterScreen;
import ru.betterend.client.gui.EndStoneSmelterScreenHandler;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndScreens {

	private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, BetterEndForge.MOD_ID);

	public static void register(IEventBus eventBus) {
		CONTAINERS.register(eventBus);
	}

	public static final RegistryObject<MenuType<EndStoneSmelterScreenHandler>> END_STONE_SMELTER_MENU_TYPE = CONTAINERS.register("end_stone_smelter_menu_type",
			() -> IForgeMenuType.create((windowId, inv, data) -> new EndStoneSmelterScreenHandler(windowId, inv)));

//	@SubscribeEvent
//	public static void registerScreens(FMLClientSetupEvent event) {
//		MenuScreens.register(END_STONE_SMELTER_MENU_TYPE.get(), EndStoneSmelterScreen::new);
//	}
}