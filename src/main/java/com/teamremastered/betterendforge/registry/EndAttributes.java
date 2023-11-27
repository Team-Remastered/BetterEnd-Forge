package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.item.EndAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EndAttributes {

	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, BetterEndForge.MOD_ID);

	public static void initregister(IEventBus eventBus) {
		ATTRIBUTES.register(eventBus);
	}

	public static final RegistryObject<Attribute> BLINDNESS_RESISTANCE = ATTRIBUTES.register("attribute.name.generic.blindness_resistance", () -> new EndAttribute("generic.blindness_resistance", 0.0));

}