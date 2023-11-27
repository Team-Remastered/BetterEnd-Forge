package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.particle.FireflyParticle;
import com.teamremastered.betterendforge.particle.InfusionParticle;
import com.teamremastered.betterendforge.particle.ParticleBlackSpore;
import com.teamremastered.betterendforge.particle.ParticleGeyser;
import com.teamremastered.betterendforge.particle.ParticleGlowingSphere;
import com.teamremastered.betterendforge.particle.ParticleJungleSpore;
import com.teamremastered.betterendforge.particle.ParticleSnowflake;
import com.teamremastered.betterendforge.particle.ParticleSulphur;
import com.teamremastered.betterendforge.particle.ParticleTenaneaPetal;
import com.teamremastered.betterendforge.particle.PaticlePortalSphere;
import com.teamremastered.betterendforge.particle.SmaragdantParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndParticuleFactory {


    @SubscribeEvent
    public static void registerParticuleFactory(ParticleFactoryRegisterEvent event) {
        particleEngine(EndParticles.GLOWING_SPHERE.get(), ParticleGlowingSphere.FactoryGlowingSphere::new);
        particleEngine(EndParticles.PORTAL_SPHERE.get(), PaticlePortalSphere.FactoryPortalSphere::new);
        particleEngine(EndParticles.INFUSION.get(), InfusionParticle.InfusionFactory::new);
        particleEngine(EndParticles.SULPHUR_PARTICLE.get(), ParticleSulphur.FactorySulphur::new);
        particleEngine(EndParticles.GEYSER_PARTICLE.get(), ParticleGeyser.FactoryGeyser::new);
        particleEngine(EndParticles.SNOWFLAKE.get(), ParticleSnowflake.FactorySnowflake::new);
        particleEngine(EndParticles.AMBER_SPHERE.get(), ParticleGlowingSphere.FactoryGlowingSphere::new);
        particleEngine(EndParticles.BLACK_SPORE.get(), ParticleBlackSpore.FactoryBlackSpore::new);
        particleEngine(EndParticles.TENANEA_PETAL.get(), ParticleTenaneaPetal.FactoryTenaneaPetal::new);
        particleEngine(EndParticles.JUNGLE_SPORE.get(), ParticleJungleSpore.FactoryJungleSpore::new);
        particleEngine(EndParticles.FIREFLY.get(), FireflyParticle.FireflyParticleFactory::new);
        particleEngine(EndParticles.SMARAGDANT.get(), SmaragdantParticle.SmaragdantParticleFactory::new);
    }

    private static <T extends ParticleOptions> void particleEngine(ParticleType<T> particleType, ParticleEngine.SpriteParticleRegistration<T> particleRegistration) {
        Minecraft.getInstance().particleEngine.register(particleType, particleRegistration);
    }

}
