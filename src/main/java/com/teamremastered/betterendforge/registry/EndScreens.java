package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.client.gui.EndStoneSmelterScreenHandler;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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