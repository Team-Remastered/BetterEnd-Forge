package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.api.LifeCycleAPI;
import com.teamremastered.betterendforge.bclib.api.biomes.BiomeAPI;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiome;
import com.teamremastered.betterendforge.bclib.world.generator.BiomePicker;
import com.teamremastered.betterendforge.bclib.world.generator.map.hex.HexBiomeMap;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import com.teamremastered.betterendforge.world.biome.air.BiomeIceStarfield;
import com.teamremastered.betterendforge.world.biome.cave.EmptyAuroraCaveBiome;
import com.teamremastered.betterendforge.world.biome.cave.EmptyEndCaveBiome;
import com.teamremastered.betterendforge.world.biome.cave.EmptySmaragdantCaveBiome;
import com.teamremastered.betterendforge.world.biome.cave.EndCaveBiome;
import com.teamremastered.betterendforge.world.biome.cave.JadeCaveBiome;
import com.teamremastered.betterendforge.world.biome.cave.LushAuroraCaveBiome;
import com.teamremastered.betterendforge.world.biome.cave.LushSmaragdantCaveBiome;
import com.teamremastered.betterendforge.world.biome.end.EndBiomeTest;
import com.teamremastered.betterendforge.world.biome.land.AmberLandBiome;
import com.teamremastered.betterendforge.world.biome.land.BlossomingSpiresBiome;
import com.teamremastered.betterendforge.world.biome.land.ChorusForestBiome;
import com.teamremastered.betterendforge.world.biome.land.CrystalMountainsBiome;
import com.teamremastered.betterendforge.world.biome.land.DragonGraveyardsBiome;
import com.teamremastered.betterendforge.world.biome.land.DryShrublandBiome;
import com.teamremastered.betterendforge.world.biome.land.DustWastelandsBiome;
import com.teamremastered.betterendforge.world.biome.land.FoggyMushroomlandBiome;
import com.teamremastered.betterendforge.world.biome.land.GlowingGrasslandsBiome;
import com.teamremastered.betterendforge.world.biome.land.LanternWoodsBiome;
import com.teamremastered.betterendforge.world.biome.land.MegalakeBiome;
import com.teamremastered.betterendforge.world.biome.land.MegalakeGroveBiome;
import com.teamremastered.betterendforge.world.biome.land.NeonOasisBiome;
import com.teamremastered.betterendforge.world.biome.land.PaintedMountainsBiome;
import com.teamremastered.betterendforge.world.biome.land.ShadowForestBiome;
import com.teamremastered.betterendforge.world.biome.land.SulphurSpringsBiome;
import com.teamremastered.betterendforge.world.biome.land.UmbraValleyBiome;
import com.teamremastered.betterendforge.world.biome.land.UmbrellaJungleBiome;
import com.teamremastered.betterendforge.world.generator.BiomeType;
import com.teamremastered.betterendforge.world.generator.GeneratorOptions;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
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

	public final static RegistryObject<Biome> END_BIOME_TEST = BIOMES.register("end_biome_test", EndBiomeTest::EndMossBiome);

	// Better End Land
//	public static final EndBiome FOGGY_MUSHROOMLAND = registerBiome(new FoggyMushroomlandBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> FOGGY_MUSHROOMLAND = registerBiomeForge("foggy_mushroomland", () -> EndBiome.create(new FoggyMushroomlandBiome()).getBiome());
//	public static final EndBiome CHORUS_FOREST = registerBiome(new ChorusForestBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> CHORUS_FOREST = BIOMES.register("chorus_forest", () -> EndBiome.create(new ChorusForestBiome()).getBiome());

	//	public static final EndBiome DUST_WASTELANDS = registerBiome(new DustWastelandsBiome(), BiomeType.LAND);
//	public static final EndBiome MEGALAKE = registerBiome(new MegalakeBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> MEGALAKE = BIOMES.register("megalake", () -> EndBiome.create(new MegalakeBiome()).getBiome());

//	public static final EndBiome MEGALAKE_GROVE = registerSubBiome(new MegalakeGroveBiome(), MEGALAKE);
	//FIXME: Convert to sub biome
	public static final RegistryObject<Biome> MEGALAKE_GROVE = BIOMES.register("megalake_grove", () -> EndBiome.create(new MegalakeGroveBiome()).getBiome());

	//	public static final EndBiome CRYSTAL_MOUNTAINS = registerBiome(new CrystalMountainsBiome(), BiomeType.LAND);
//	public static final EndBiome PAINTED_MOUNTAINS = registerSubBiome(new PaintedMountainsBiome(), DUST_WASTELANDS);
//	public static final EndBiome SHADOW_FOREST = registerBiome(new ShadowForestBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> SHADOW_FOREST = BIOMES.register("shadow_forest", () -> EndBiome.create(new ShadowForestBiome()).getBiome());

//	public static final EndBiome AMBER_LAND = registerBiome(new AmberLandBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> AMBER_LAND = BIOMES.register("amber_land", () -> EndBiome.create(new AmberLandBiome()).getBiome());
//	public static final EndBiome BLOSSOMING_SPIRES = registerBiome(new BlossomingSpiresBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> BLOSSOMING_SPIRES = BIOMES.register("blossoming_spires", () -> EndBiome.create(new BlossomingSpiresBiome()).getBiome());

//	public static final EndBiome SULPHUR_SPRINGS = registerBiome(new SulphurSpringsBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> SULPHUR_SPRINGS = BIOMES.register("sulphur_springs", () -> EndBiome.create(new SulphurSpringsBiome()).getBiome());
//	public static final EndBiome UMBRELLA_JUNGLE = registerBiome(new UmbrellaJungleBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> UMBRELLA_JUNGLE = BIOMES.register("umbrella_jungle", () -> EndBiome.create(new UmbrellaJungleBiome()).getBiome());
//	public static final EndBiome GLOWING_GRASSLANDS = registerBiome(new GlowingGrasslandsBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> GLOWING_GRASSLANDS = BIOMES.register("glowing_grasslands", () -> EndBiome.create(new GlowingGrasslandsBiome()).getBiome());

	//	public static final EndBiome DRAGON_GRAVEYARDS = registerBiome(new DragonGraveyardsBiome(), BiomeType.LAND);
//	public static final EndBiome DRY_SHRUBLAND = registerBiome(new DryShrublandBiome(), BiomeType.LAND);
//	public static final EndBiome LANTERN_WOODS = registerBiome(new LanternWoodsBiome(), BiomeType.LAND);
	public static final RegistryObject<Biome> LANTERN_WOODS = BIOMES.register("lantern_woods", () -> EndBiome.create(new LanternWoodsBiome()).getBiome());

//	public static final EndBiome NEON_OASIS = registerSubBiome(new NeonOasisBiome(), DUST_WASTELANDS);
//	public static final EndBiome UMBRA_VALLEY = registerBiome(new UmbraValleyBiome(), BiomeType.LAND);
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
	
	public static void register() {
		LifeCycleAPI.onLevelLoad(EndBiomes::onWorldLoad);
	}

//	public static RegistryObject<Biome> registerBiome(String biomeID, Supplier<? extends Biome> biome) {
//		BiomeAPI.ID_MAP.put()
//	}

	public static RegistryObject<Biome> registerBiomeForge(String name, final Supplier<? extends Biome> biome) {
		RegistryObject<Biome> registeredBiome = BIOMES.register(name, biome);
		return registeredBiome;
	}
	
	private static void onWorldLoad(ServerLevel level, long seed, Registry<Biome> registry) {
		CAVE_BIOMES.getBiomes().forEach(biome -> biome.updateActualBiomes(registry));
		CAVE_BIOMES.rebuild();
		if (caveBiomeMap == null || lastSeed != seed) {
			caveBiomeMap = new HexBiomeMap(seed, GeneratorOptions.getBiomeSizeCaves(), CAVE_BIOMES);
			lastSeed = seed;
		}
	}
	
	/**
	 * Put existing {@link EndBiome} as a sub-biome into selected parent.
	 *
	 * @param biomeConfig  - {@link EndBiome.Config} instance
	 * @param parent - {@link EndBiome} to be linked with
	 * @return registered {@link EndBiome}
	 */
	public static EndBiome registerSubBiome(EndBiome.Config biomeConfig, EndBiome parent) {
		final EndBiome biome = EndBiome.create(biomeConfig);

//		if (true) {
//			BiomeAPI.registerSubBiome(parent, biome);
//		}
		return biome;
	}
	
	/**
	 * Registers {@link EndBiome} and adds it into worldgen.
	 *
	 * @param biomeConfig - {@link EndBiome.Config} instance
	 * @param type  - {@link BiomeType}
	 * @return registered {@link EndBiome}
	 */
	public static EndBiome registerBiome(EndBiome.Config biomeConfig, BiomeType type) {
		final EndBiome biome = EndBiome.create(biomeConfig);
//		if (true) {
//			if (type == BiomeType.LAND) {
//				BiomeAPI.registerEndLandBiome(biome);
//			}
//			else {
//				BiomeAPI.registerEndVoidBiome(biome);
//			}
//		}
		return biome;
	}
	
	/**
	 * Put integration sub-biome {@link EndBiome} into subbiomes list and registers it.
	 *
	 * @param biomeConfig - {@link EndBiome.Config} instance
	 * @return registered {@link EndBiome}
	 */
	public static EndBiome registerSubBiomeIntegration(EndBiome.Config biomeConfig) {
		EndBiome biome = EndBiome.create(biomeConfig);
//		if (true) {
//			BiomeAPI.registerBiome(biome);
//		}
		return biome;
	}
	
	/**
	 * Link integration sub-biome with parent.
	 *
	 * @param biome  - {@link EndBiome} instance
	 * @param parent - {@link ResourceLocation} parent id
	 */
	public static void addSubBiomeIntegration(EndBiome biome, ResourceLocation parent) {
		if (true) {
			BCLBiome parentBiome = BiomeAPI.getBiome(parent);
			if (parentBiome != null && !parentBiome.containsSubBiome(biome)) {
				parentBiome.addSubBiome(biome);
			}
		}
	}
	
	public static EndCaveBiome registerCaveBiome(EndCaveBiome.Config biomeConfig) {
		final EndCaveBiome biome = EndCaveBiome.create(biomeConfig);
		if (true) {
			BiomeAPI.registerBiome(biome);
			CAVE_BIOMES.addBiome(biome);
		}
		return biome;
	}
	
	public static EndCaveBiome getCaveBiome(int x, int z) {
		return (EndCaveBiome) caveBiomeMap.getBiome(x, 5, z);
	}
}
