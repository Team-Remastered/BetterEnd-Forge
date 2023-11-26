package ru.betterend.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.BetterEndForge;
import ru.betterend.effects.enchantment.EndVeilEnchantment;

import java.util.function.Supplier;

public class EndEnchantments {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		ENCHANTMENTS.register(eventBus);
	}

	public final static RegistryObject<Enchantment> END_VEIL = registerEnchantment("end_veil", EndVeilEnchantment::new);

		public static RegistryObject<Enchantment> registerEnchantment(String name, final Supplier<? extends Enchantment> enchantment) {

			return ENCHANTMENTS.register(name, enchantment);
		}

}