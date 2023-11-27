package ru.betterend.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.BetterEndForge;
import ru.betterend.effects.status.EndVeilEffect;

public class EndStatusEffects {

	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		MOB_EFFECTS.register(eventBus);
	}

	public final static MobEffectInstance CRYSTALITE_HEALTH_REGEN = new MobEffectInstance(MobEffects.REGENERATION, 80, 0, true, false, true);
	public final static MobEffectInstance CRYSTALITE_DIG_SPEED = new MobEffectInstance(MobEffects.DIG_SPEED, 80, 0, true, false, true);
	public final static MobEffectInstance CRYSTALITE_MOVE_SPEED = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 80, 0, true, false, true);
	
	public final static RegistryObject<MobEffect> END_VEIL = MOB_EFFECTS.register("end_veil", EndVeilEffect::new);

}
