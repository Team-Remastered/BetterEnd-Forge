package ru.betterend.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.BetterEndForge;
import ru.betterend.particle.FireflyParticle;
import ru.betterend.particle.InfusionParticle;
import ru.betterend.particle.InfusionParticleType;
import ru.betterend.particle.ParticleBlackSpore;
import ru.betterend.particle.ParticleGeyser;
import ru.betterend.particle.ParticleGlowingSphere;
import ru.betterend.particle.ParticleJungleSpore;
import ru.betterend.particle.ParticleSnowflake;
import ru.betterend.particle.ParticleSulphur;
import ru.betterend.particle.ParticleTenaneaPetal;
import ru.betterend.particle.PaticlePortalSphere;
import ru.betterend.particle.SmaragdantParticle;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndParticles {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, BetterEndForge.MOD_ID);

	public static void register(IEventBus eventBus) {
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

	@SubscribeEvent
	public static void registerParticuleFactory(ParticleFactoryRegisterEvent event) {
		particleEngine(GLOWING_SPHERE.get(), ParticleGlowingSphere.FactoryGlowingSphere::new);
		particleEngine(PORTAL_SPHERE.get(), PaticlePortalSphere.FactoryPortalSphere::new);
		particleEngine(INFUSION.get(), InfusionParticle.InfusionFactory::new);
		particleEngine(SULPHUR_PARTICLE.get(), ParticleSulphur.FactorySulphur::new);
		particleEngine(GEYSER_PARTICLE.get(), ParticleGeyser.FactoryGeyser::new);
		particleEngine(SNOWFLAKE.get(), ParticleSnowflake.FactorySnowflake::new);
		particleEngine(AMBER_SPHERE.get(), ParticleGlowingSphere.FactoryGlowingSphere::new);
		particleEngine(BLACK_SPORE.get(), ParticleBlackSpore.FactoryBlackSpore::new);
		particleEngine(TENANEA_PETAL.get(), ParticleTenaneaPetal.FactoryTenaneaPetal::new);
		particleEngine(JUNGLE_SPORE.get(), ParticleJungleSpore.FactoryJungleSpore::new);
		particleEngine(FIREFLY.get(), FireflyParticle.FireflyParticleFactory::new);
		particleEngine(SMARAGDANT.get(), SmaragdantParticle.SmaragdantParticleFactory::new);
	}

	private static RegistryObject<SimpleParticleType> register(String name) {
		return PARTICLE_TYPES.register(name, () -> new SimpleParticleType(false));
	}

	
	private static RegistryObject<SimpleParticleType> registerFar(String name) {
		return PARTICLE_TYPES.register(name, () -> new SimpleParticleType(true));
	}
	
	private static <T extends ParticleOptions> RegistryObject<ParticleType<T>> register(String name, ParticleType<T> type) {
		return PARTICLE_TYPES.register(name, () -> type);
	}

	private static <T extends ParticleOptions> void particleEngine(ParticleType<T> particleType, ParticleEngine.SpriteParticleRegistration<T> particleRegistration) {
		Minecraft.getInstance().particleEngine.register(particleType, particleRegistration);
	}

	public static <T extends ParticleOptions> ParticleType<T> complex(ParticleOptions.Deserializer<T> factory) {
		return complex(factory);
	}
}