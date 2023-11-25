package ru.betterend.registry;

import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.BetterEndForge;
import ru.betterend.item.EndAttribute;

public class EndAttributes {

	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, BetterEndForge.MOD_ID);

	public static void initregister(IEventBus eventBus) {
		ATTRIBUTES.register(eventBus);
	}

	public static final RegistryObject<Attribute> BLINDNESS_RESISTANCE = ATTRIBUTES.register("attribute.name.generic.blindness_resistance", () -> new EndAttribute("generic.blindness_resistance", 0.0));
	
//	public static AttributeSupplier.Builder addLivingEntityAttributes(AttributeSupplier.Builder builder) {
//		return builder.add(EndAttributes.BLINDNESS_RESISTANCE.get());
//	}
}