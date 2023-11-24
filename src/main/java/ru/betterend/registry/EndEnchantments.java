package ru.betterend.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.BetterEndForge;
import ru.betterend.effects.enchantment.EndVeilEnchantment;

public class EndEnchantments {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BetterEndForge.MOD_ID);

	public final static RegistryObject<Enchantment> END_VEIL = registerEnchantment("end_veil", new EndVeilEnchantment());

		public static RegistryObject<Enchantment> registerEnchantment(String name, Enchantment enchantment) {
			if (Configs.ENCHANTMENT_CONFIG.getBooleanRoot(name, true)) {
				Registry.register(Registry.ENCHANTMENT, BetterEndForge.makeID(name), enchantment);
			}
			return ENCHANTMENTS.register(name, () -> enchantment);
		}
	
	public static void register() {}
}