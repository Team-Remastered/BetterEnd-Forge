package ru.betterend.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.mixin.common.bclib.PotionBrewingAccessor;
import ru.betterend.BetterEndForge;

import java.util.function.Supplier;

public class EndPotions {

	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		POTIONS.register(eventBus);
	}

	public final static RegistryObject<Potion> END_VEIL = POTIONS.register("end_veil",
			() -> new Potion(new MobEffectInstance(EndStatusEffects.END_VEIL.get(), 3600)));
	public final static RegistryObject<Potion> LONG_END_VEIL = POTIONS.register("long_end_veil",
			() -> new Potion(new MobEffectInstance(EndStatusEffects.END_VEIL.get(), 9600)));

}
