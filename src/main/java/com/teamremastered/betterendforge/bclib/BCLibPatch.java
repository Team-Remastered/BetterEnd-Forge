package com.teamremastered.betterendforge.bclib;

import com.teamremastered.betterendforge.bclib.api.datafixer.DataFixerAPI;
import com.teamremastered.betterendforge.bclib.api.datafixer.ForcedLevelPatch;
import com.teamremastered.betterendforge.bclib.api.datafixer.MigrationProfile;
import com.teamremastered.betterendforge.bclib.world.generator.GeneratorOptions;
import net.minecraft.nbt.CompoundTag;

public final class BCLibPatch {
	public static void register() {
		// TODO separate values in config on client side (config screen)
		//FIXME: I put temp variable here that needs to be changed with a config
		boolean repairBiomes = true;
		if (repairBiomes && (GeneratorOptions.fixEndBiomeSource() || GeneratorOptions.fixNetherBiomeSource())) {
			DataFixerAPI.registerPatch(BiomeSourcePatch::new);
		}
	}
}

final class BiomeSourcePatch extends ForcedLevelPatch {
	private static final String NETHER_BIOME_SOURCE = "bclib:nether_biome_source";
	private static final String END_BIOME_SOURCE = "bclib:end_biome_source";
	private static final String MC_NETHER = "minecraft:the_nether";
	private static final String MC_END = "minecraft:the_end";
	
	protected BiomeSourcePatch() {
		super(BCLib.MOD_ID, "1.2.1");
	}
	
	@Override
	protected Boolean runLevelDatPatch(CompoundTag root, MigrationProfile profile) {
		CompoundTag worldGenSettings = root.getCompound("Data").getCompound("WorldGenSettings");
		CompoundTag dimensions = worldGenSettings.getCompound("dimensions");
		long seed = worldGenSettings.getLong("seed");
		boolean result = false;
		
		if (GeneratorOptions.fixNetherBiomeSource()) {
			if (!dimensions.contains(MC_NETHER) || !isBCLibEntry(dimensions.getCompound(MC_NETHER))) {
				CompoundTag dimRoot = new CompoundTag();
				dimRoot.put("generator", makeNetherGenerator(seed));
				dimRoot.putString("type", MC_NETHER);
				dimensions.put(MC_NETHER, dimRoot);
				result = true;
			}
		}
		
		if (GeneratorOptions.fixEndBiomeSource()) {
			if (!dimensions.contains(MC_END) || !isBCLibEntry(dimensions.getCompound(MC_END))) {
				CompoundTag dimRoot = new CompoundTag();
				dimRoot.put("generator", makeEndGenerator(seed));
				dimRoot.putString("type", MC_END);
				dimensions.put(MC_END, dimRoot);
				result = true;
			}
		}
		
		return result;
	}
	
	private boolean isBCLibEntry(CompoundTag dimRoot) {
		String type = dimRoot.getCompound("generator").getCompound("biome_source").getString("type");
		if (type.isEmpty() || type.length() < 5) {
			return false;
		}
		return type.startsWith("bclib");
	}
	
	public static CompoundTag makeNetherGenerator(long seed) {
		CompoundTag generator = new CompoundTag();
		generator.putString("type", "minecraft:noise");
		generator.putString("settings", "minecraft:nether");
		generator.putLong("seed", seed);
		
		CompoundTag biomeSource = new CompoundTag();
		biomeSource.putString("type", NETHER_BIOME_SOURCE);
		biomeSource.putLong("seed", seed);
		generator.put("biome_source", biomeSource);
		
		return generator;
	}
	
	public static CompoundTag makeEndGenerator(long seed) {
		CompoundTag generator = new CompoundTag();
		generator.putString("type", "minecraft:noise");
		generator.putString("settings", "minecraft:end");
		generator.putLong("seed", seed);
		
		CompoundTag biomeSource = new CompoundTag();
		biomeSource.putString("type", END_BIOME_SOURCE);
		biomeSource.putLong("seed", seed);
		generator.put("biome_source", biomeSource);
		
		return generator;
	}
}
