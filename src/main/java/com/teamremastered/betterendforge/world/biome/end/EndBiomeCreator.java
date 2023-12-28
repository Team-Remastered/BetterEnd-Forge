package com.teamremastered.betterendforge.world.biome.end;

import com.teamremastered.betterendforge.bclib.util.ColorUtil;
import com.teamremastered.betterendforge.mixin.common.VanillaBiomeAccess;
import com.teamremastered.betterendforge.registry.EndParticles;
import com.teamremastered.betterendforge.registry.EndSounds;
import com.teamremastered.betterendforge.registry.world.EndPlacedFeatures;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EndBiomeCreator {

    public static Biome FoggyMushroomlandBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(41, 122, 173))
                .foliageColorOverride(ColorUtil.color(73, 210, 209))
                .waterColor(ColorUtil.color(119, 227, 250))
                .waterFogColor(ColorUtil.color(119, 227, 250))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.GLOWING_SPHERE.get(), 0.001F))
                .ambientLoopSound(EndSounds.AMBIENT_FOGGY_MUSHROOMLAND.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_FOREST.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome DustWastelands() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(45, 45, 45))
                .waterColor(ColorUtil.color(192, 180, 131))
                .waterFogColor(ColorUtil.color(192, 180, 131))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01F))
                .ambientLoopSound(EndSounds.AMBIENT_DUST_WASTELANDS.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome ShadowForestBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(45, 45, 45))
                .foliageColorOverride(ColorUtil.color(73, 210, 209))
                .waterColor(ColorUtil.color(42, 45, 80))
                .waterFogColor(ColorUtil.color(42, 45, 80))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.MYCELIUM, 0.01F))
                .ambientLoopSound(EndSounds.AMBIENT_CHORUS_FOREST.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_DARK.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome ChorusForestBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(87, 26, 87))
                .foliageColorOverride(ColorUtil.color(122, 45, 122))
                .waterColor(ColorUtil.color(73, 30, 73))
                .waterFogColor(ColorUtil.color(73, 30, 73))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.PORTAL, 0.01F))
                .ambientLoopSound(EndSounds.AMBIENT_CHORUS_FOREST.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_DARK.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EndPlacements.CHORUS_PLANT)
                .build()).build();
    }

    public static Biome MegalakeBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(178, 209, 248))
                .foliageColorOverride(ColorUtil.color(73, 210, 209))
                .waterColor(ColorUtil.color(96, 163, 255))
                .waterFogColor(ColorUtil.color(96, 163, 255))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.PORTAL, 0.01F))
                .ambientLoopSound(EndSounds.AMBIENT_MEGALAKE.get())
//              .terrainHeight(0F) //need to find a way to change the terrain height
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_WATER.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome MegalakeGroveBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(178, 209, 248))
                .foliageColorOverride(ColorUtil.color(73, 210, 209))
                .waterColor(ColorUtil.color(96, 163, 255))
                .waterFogColor(ColorUtil.color(96, 163, 255))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.GLOWING_SPHERE.get(), 0.001F))
                .ambientLoopSound(EndSounds.AMBIENT_MEGALAKE_GROVE.get())
//              .terrainHeight(0F)
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_WATER.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome AmberLandBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(255, 184, 71))
                .foliageColorOverride(ColorUtil.color(219, 115, 38))
                .waterColor(ColorUtil.color(145, 108, 72))
                .waterFogColor(ColorUtil.color(145, 108, 72))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.AMBER_SPHERE.get(), 0.001F))
                .ambientLoopSound(EndSounds.AMBIENT_AMBER_LAND.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_FOREST.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome BlossomingSpiresBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(241, 146, 229))
                .foliageColorOverride(ColorUtil.color(122, 45, 122))
                .waterColor(ColorUtil.color(145, 108, 72))
                .waterFogColor(ColorUtil.color(145, 108, 72))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.AMBER_SPHERE.get(), 0.001F))
                .ambientLoopSound(EndSounds.AMBIENT_BLOSSOMING_SPIRES.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_FOREST.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome SulphurSpringsBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(207, 194, 62))
                .foliageColorOverride(ColorUtil.color(122, 45, 122))
                .waterColor(ColorUtil.color(25, 90, 157))
                .waterFogColor(ColorUtil.color(30, 65, 61))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.SULPHUR_PARTICLE.get(), 0.001F))
                .ambientLoopSound(EndSounds.AMBIENT_SULPHUR_SPRINGS.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
//              .terrainHeight(0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome UmbrellaJungleBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(87, 223, 221))
                .foliageColorOverride(ColorUtil.color(27, 183, 194))
                .waterColor(ColorUtil.color(119, 198, 253))
                .waterFogColor(ColorUtil.color(119, 198, 253))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.JUNGLE_SPORE.get(), 0.001F))
                .ambientLoopSound(EndSounds.AMBIENT_UMBRELLA_JUNGLE.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_FOREST.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome GlowingGrasslandsBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(99, 228, 247))
                .foliageColorOverride(ColorUtil.color(73, 210, 209))
                .waterColor(ColorUtil.color(92, 250, 230))
                .waterFogColor(ColorUtil.color(92, 250, 230))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.FIREFLY.get(), 0.001F))
                .ambientLoopSound(EndSounds.AMBIENT_GLOWING_GRASSLANDS.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome LanternWoodsBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(189, 82, 70))
                .foliageColorOverride(ColorUtil.color(254, 85, 57))
                .waterColor(ColorUtil.color(171, 234, 226))
                .waterFogColor(ColorUtil.color(171, 234, 226))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.GLOWING_SPHERE.get(), 0.001F))
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_FOREST.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }
    public static Biome CrystalMountains() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(189, 82, 70))
                .foliageColorOverride(ColorUtil.color(255, 133, 211))
                .waterColor(ColorUtil.color(171, 234, 226)) //should be vanilla color
                .waterFogColor(ColorUtil.color(171, 234, 226))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome PaintedMountains() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(226, 239, 168))
                .foliageColorOverride(ColorUtil.color(254, 85, 57))
                .waterColor(ColorUtil.color(192, 180, 131))
                .waterFogColor(ColorUtil.color(192, 180, 131))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01F))
                .ambientLoopSound(EndSounds.AMBIENT_DUST_WASTELANDS.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome DragonGraveyards() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(244, 46, 79))
                .foliageColorOverride(ColorUtil.color(244, 46, 79))
                .waterColor(ColorUtil.color(203, 59, 167))
                .waterFogColor(ColorUtil.color(203, 59, 167))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.FIREFLY.get(), 0.0007F))
                .ambientLoopSound(EndSounds.AMBIENT_GLOWING_GRASSLANDS.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome DryShrubland() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(132, 35, 13))
                .foliageColorOverride(ColorUtil.color(237, 122, 66))
                .waterColor(ColorUtil.color(113, 88, 53))
                .waterFogColor(ColorUtil.color(113, 88, 53))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome NeonOasis() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(226, 239, 168))
                .waterColor(ColorUtil.color(106, 238, 215))
                .waterFogColor(ColorUtil.color(106, 238, 215))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01F))
                .ambientLoopSound(EndSounds.AMBIENT_DUST_WASTELANDS.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_OPENSPACE.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }

    public static Biome UmbraValley() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMITE, 5, 1, 2));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 60, 1, 3));
        return new Biome.BiomeBuilder()
                .specialEffects((new BiomeSpecialEffects.Builder())
                .fogColor(ColorUtil.color(100, 100, 100))
                .foliageColorOverride(ColorUtil.color(172, 189, 190))
                .waterColor(ColorUtil.color(69, 104, 134))
                .waterFogColor(ColorUtil.color(69, 104, 134))
                .skyColor(VanillaBiomeAccess.bef_invokeCalculateSkyColor(0.0F))
                .ambientParticle(new AmbientParticleSettings(EndParticles.AMBER_SPHERE.get(), 0.0001F))
                .ambientLoopSound(EndSounds.UMBRA_VALLEY.get())
                .backgroundMusic(Musics.createGameMusic(EndSounds.MUSIC_DARK.get())).build())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(1.0F)
                .downfall(0.0F)
                .biomeCategory(Biome.BiomeCategory.THEEND)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings
                .build()).build();
    }
}