package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EndSounds {

	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}

	// Music
	public static final RegistryObject<SoundEvent> MUSIC_FOREST = register("music", "forest");
	public static final RegistryObject<SoundEvent> MUSIC_WATER = register("music", "water");
	public static final RegistryObject<SoundEvent> MUSIC_DARK = register("music", "dark");
	public static final RegistryObject<SoundEvent> MUSIC_OPENSPACE = register("music", "openspace");
	public static final RegistryObject<SoundEvent> MUSIC_CAVES = register("music", "caves");
	
	// Ambient
	public static final RegistryObject<SoundEvent> AMBIENT_FOGGY_MUSHROOMLAND = register("ambient", "foggy_mushroomland");
	public static final RegistryObject<SoundEvent> AMBIENT_CHORUS_FOREST = register("ambient", "chorus_forest");
	public static final RegistryObject<SoundEvent> AMBIENT_MEGALAKE = register("ambient", "megalake");
	public static final RegistryObject<SoundEvent> AMBIENT_DUST_WASTELANDS = register("ambient", "dust_wastelands");
	public static final RegistryObject<SoundEvent> AMBIENT_MEGALAKE_GROVE = register("ambient", "megalake_grove");
	public static final RegistryObject<SoundEvent> AMBIENT_BLOSSOMING_SPIRES = register("ambient", "blossoming_spires");
	public static final RegistryObject<SoundEvent> AMBIENT_SULPHUR_SPRINGS = register("ambient", "sulphur_springs");
	public static final RegistryObject<SoundEvent> AMBIENT_UMBRELLA_JUNGLE = register("ambient", "umbrella_jungle");
	public static final RegistryObject<SoundEvent> AMBIENT_GLOWING_GRASSLANDS = register("ambient", "glowing_grasslands");
	public static final RegistryObject<SoundEvent> AMBIENT_CAVES = register("ambient", "caves");
	public static final RegistryObject<SoundEvent> AMBIENT_AMBER_LAND = register("ambient", "amber_land");
	public static final RegistryObject<SoundEvent> UMBRA_VALLEY = register("ambient", "umbra_valley");
	
	// Entity
	public static final RegistryObject<SoundEvent> ENTITY_DRAGONFLY = register("entity", "dragonfly");
	public static final RegistryObject<SoundEvent> ENTITY_SHADOW_WALKER = register("entity", "shadow_walker");
	public static final RegistryObject<SoundEvent> ENTITY_SHADOW_WALKER_DAMAGE = register("entity", "shadow_walker_damage");
	public static final RegistryObject<SoundEvent> ENTITY_SHADOW_WALKER_DEATH = register("entity", "shadow_walker_death");
	
	// Records
	public static final RegistryObject<SoundEvent> RECORD_STRANGE_AND_ALIEN = register("record", "strange_and_alien");
	public static final RegistryObject<SoundEvent> RECORD_GRASPING_AT_STARS = register("record", "grasping_at_stars");
	public static final RegistryObject<SoundEvent> RECORD_ENDSEEKER = register("record", "endseeker");
	public static final RegistryObject<SoundEvent> RECORD_EO_DRACONA = register("record", "eo_dracona");

	
//	private static SoundEvent register(String type, String id) {
//		id = "betterend." + type + "." + id;
//		return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(BetterEndForge.makeID(id)));
//	}

	private static RegistryObject<SoundEvent> register(String type, String id) {
		id = "betterend." + type + "." + id;
		String finalId = id;
		return SOUND_EVENTS.register(id, () -> new SoundEvent((BetterEndForge.makeID(finalId))));
	}
}
