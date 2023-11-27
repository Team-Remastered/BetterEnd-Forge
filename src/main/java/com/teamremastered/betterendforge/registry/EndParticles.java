package com.teamremastered.betterendforge.registry;

import com.mojang.serialization.Codec;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.particle.InfusionParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class EndParticles {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		PARTICLE_TYPES.register(eventBus);
	}

	public static final RegistryObject<SimpleParticleType> GLOWING_SPHERE = register("glowing_sphere");
	public static final RegistryObject<SimpleParticleType> PORTAL_SPHERE = register("portal_sphere");
	public static final RegistryObject<ParticleType<InfusionParticleType>> INFUSION = register("infusion", complex(InfusionParticleType.PARAMETERS_FACTORY));
	public static final RegistryObject<SimpleParticleType> SULPHUR_PARTICLE = register("sulphur_particle");
	public static final RegistryObject<SimpleParticleType> GEYSER_PARTICLE = registerFar("geyser_particle");
	public static final RegistryObject<SimpleParticleType> SNOWFLAKE = register("snowflake");
	public static final RegistryObject<SimpleParticleType> AMBER_SPHERE = register("amber_sphere");
	public static final RegistryObject<SimpleParticleType> BLACK_SPORE = register("black_spore");
	public static final RegistryObject<SimpleParticleType> TENANEA_PETAL = register("tenanea_petal");
	public static final RegistryObject<SimpleParticleType> JUNGLE_SPORE = register("jungle_spore");
	public static final RegistryObject<SimpleParticleType> FIREFLY = register("firefly");
	public static final RegistryObject<SimpleParticleType> SMARAGDANT = register("smaragdant_particle");



	private static RegistryObject<SimpleParticleType> register(String name) {
		return PARTICLE_TYPES.register(name, () -> new SimpleParticleType(false));
	}

	
	private static RegistryObject<SimpleParticleType> registerFar(String name) {
		return PARTICLE_TYPES.register(name, () -> new SimpleParticleType(true));
	}
	
	private static <T extends ParticleOptions> RegistryObject<ParticleType<T>> register(String name, ParticleType<T> type) {
		return PARTICLE_TYPES.register(name, () -> type);
	}

	/**
	 * Creates a new particle type with a custom factory for packet/data serialization.
	 *
	 * @param factory	 A factory for serializing packet data and string command parameters into a particle effect.
	 */
	public static <T extends ParticleOptions> ParticleType<T> complex(ParticleOptions.Deserializer<T> factory) {
		return complex(false, factory);
	}

	/**
	 * Creates a new particle type with a custom factory for packet/data serialization.
	 *
	 * @param alwaysSpawn True to always spawn the particle regardless of distance.
	 * @param factory	 A factory for serializing packet data and string command parameters into a particle effect.
	 */
	public static <T extends ParticleOptions> ParticleType<T> complex(boolean alwaysSpawn, ParticleOptions.Deserializer<T> factory) {
		return new ParticleType<T>(alwaysSpawn, factory) {
			@Override
			public Codec<T> codec() {
				//TODO fix me
				return null;
			}
		};
	}
}