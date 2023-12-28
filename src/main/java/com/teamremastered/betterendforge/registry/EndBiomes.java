package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.world.generator.BiomePicker;
import com.teamremastered.betterendforge.bclib.world.generator.map.hex.HexBiomeMap;
import com.teamremastered.betterendforge.world.biome.cave.EndCaveBiome;
import com.teamremastered.betterendforge.world.biome.end.EndBiomeCreator;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

//FIXME: CONFIG
public class EndBiomes {
	public static final BiomePicker CAVE_BIOMES = new BiomePicker();
	private static HexBiomeMap caveBiomeMap;
	private static long lastSeed;

	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		BIOMES.register(eventBus);
	}

	// Better End Land
	public static final RegistryObject<Biome> FOGGY_MUSHROOMLAND = registerBiome("foggy_mushroomland", EndBiomeCreator::FoggyMushroomlandBiome);
	public static final RegistryObject<Biome> CHORUS_FOREST = registerBiome("chorus_forest", EndBiomeCreator::ChorusForestBiome);

		public static final RegistryObject<Biome> DUST_WASTELANDS = registerBiome("dust_wastelands", EndBiomeCreator::DustWastelands);
	public static final RegistryObject<Biome> MEGALAKE = registerBiome("megalake", EndBiomeCreator::MegalakeBiome);

	//FIXME: Convert to sub biome
	public static final RegistryObject<Biome> MEGALAKE_GROVE = registerBiome("megalake_grove", EndBiomeCreator::MegalakeGroveBiome);

	public static final RegistryObject<Biome> CRYSTAL_MOUNTAINS = registerBiome("crystal_mountains", EndBiomeCreator::CrystalMountains);
	public static final RegistryObject<Biome> PAINTED_MOUNTAINS = registerSubBiome("painted_mountains", EndBiomeCreator::PaintedMountains);
	public static final RegistryObject<Biome> SHADOW_FOREST = registerBiome("shadow_forest", EndBiomeCreator::ShadowForestBiome);

	public static final RegistryObject<Biome> AMBER_LAND = registerBiome("amber_land", EndBiomeCreator::AmberLandBiome);
	public static final RegistryObject<Biome> BLOSSOMING_SPIRES = registerBiome("blossoming_spires", EndBiomeCreator::BlossomingSpiresBiome);

	public static final RegistryObject<Biome> SULPHUR_SPRINGS = registerBiome("sulphur_springs", EndBiomeCreator::SulphurSpringsBiome);
	public static final RegistryObject<Biome> UMBRELLA_JUNGLE = registerBiome("umbrella_jungle", EndBiomeCreator::UmbrellaJungleBiome);
	public static final RegistryObject<Biome> GLOWING_GRASSLANDS = registerBiome("glowing_grasslands", EndBiomeCreator::GlowingGrasslandsBiome);

	public static final RegistryObject<Biome> DRAGON_GRAVEYARDS = registerBiome("dragon_graveyards", EndBiomeCreator::DragonGraveyards);
	public static final RegistryObject<Biome> DRY_SHRUBLAND = registerBiome("dry_shrubland", EndBiomeCreator::DryShrubland);
	public static final RegistryObject<Biome> LANTERN_WOODS = registerBiome("lantern_woods", EndBiomeCreator::LanternWoodsBiome);

	public static final RegistryObject<Biome> NEON_OASIS = registerSubBiome("neon_oasis", EndBiomeCreator::NeonOasis);
	public static final RegistryObject<Biome> UMBRA_VALLEY = registerBiome("umbra_valley", EndBiomeCreator::UmbraValley);
//
//	// Better End Void
//	public static final EndBiome ICE_STARFIELD = registerBiome(new BiomeIceStarfield(), BiomeType.VOID);
//
//	// Better End Caves
//	public static final EndCaveBiome EMPTY_END_CAVE = registerCaveBiome(new EmptyEndCaveBiome());
//	public static final EndCaveBiome EMPTY_SMARAGDANT_CAVE = registerCaveBiome(new EmptySmaragdantCaveBiome());
//	public static final EndCaveBiome LUSH_SMARAGDANT_CAVE = registerCaveBiome(new LushSmaragdantCaveBiome());
//	public static final EndCaveBiome EMPTY_AURORA_CAVE = registerCaveBiome(new EmptyAuroraCaveBiome());
//	public static final EndCaveBiome LUSH_AURORA_CAVE = registerCaveBiome(new LushAuroraCaveBiome());
//	public static final EndCaveBiome JADE_CAVE = registerCaveBiome(new JadeCaveBiome());

//	public static RegistryObject<Biome> registerBiome(String biomeID, Supplier<? extends Biome> biome) {
//		BiomeAPI.ID_MAP.put()
//	}

	public static RegistryObject<Biome> registerBiome(String name, final Supplier<? extends Biome> biome) {
		RegistryObject<Biome> registeredBiome = BIOMES.register(name, biome);
		return registeredBiome;
	}

	public static RegistryObject<Biome> registerSubBiome(String name, final Supplier<? extends Biome> biome) {
		//TODO: make it actually register the biome as a sub biome
		RegistryObject<Biome> registeredBiome = BIOMES.register(name, biome);
		return registeredBiome;
	}
	
	public static EndCaveBiome getCaveBiome(int x, int z) {
		return (EndCaveBiome) caveBiomeMap.getBiome(x, 5, z);
	}
}
