package com.teamremastered.betterendforge.bclib.api;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.bclib.BCLib;
import com.teamremastered.betterendforge.bclib.api.datafixer.DataFixerAPI;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.world.level.storage.LevelStorageSource.LevelStorageAccess;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Mod-specifix data-storage for a world.
 * <p>
 * This class provides the ability for mod to store persistent data inside a world. The Storage for the world is
 * currently initialized as part of the {@link DataFixerAPI} in {@link DataFixerAPI#fixData(LevelStorageAccess, boolean, Consumer)}
 * or {@link DataFixerAPI#initializeWorldData(File, boolean)}
 */
public class WorldDataAPI {
	private static final Map<String, CompoundTag> TAGS = Maps.newHashMap();
	private static final List<String> MODS = Lists.newArrayList();
	private static File dataDir;
	
//	public static void load(File dataDir) {
//		WorldDataAPI.dataDir = dataDir;
//		MODS.stream()
//			.parallel()
//			.forEach(modID -> {
//				File file = new File(dataDir, modID + ".nbt");
//				CompoundTag root = new CompoundTag();
//				if (file.exists()) {
//					try {
//						root = NbtIo.readCompressed(file);
//					}
//					catch (IOException e) {
//						BCLib.LOGGER.error("World data loading failed", e);
//					}
//					TAGS.put(modID, root);
//				}
//				else {
//					Optional<ModContainer> optional = FabricLoader.getInstance()
//																  .getModContainer(modID);
//					if (optional.isPresent()) {
//						ModContainer modContainer = optional.get();
//						if (BCLib.isDevEnvironment()) {
//							root.putString("version", "255.255.9999");
//						}
//						else {
//							root.putString("version", modContainer.getMetadata()
//																  .getVersion()
//																  .toString());
//						}
//						TAGS.put(modID, root);
//						saveFile(modID);
//					}
//				}
//			});
//	}
	//FIXME: idk if this is worth fixing, the only place it is used is in DatafixerAPI#initializeWorldData
	
	/**
	 * Register mod cache, world cache is located in world data folder.
	 *
	 * @param modID - {@link String} modID.
	 */
	public static void registerModCache(String modID) {
		MODS.add(modID);
	}
	
	/**
	 * Get root {@link CompoundTag} for mod cache in world data folder.
	 *
	 * @param modID - {@link String} modID.
	 * @return {@link CompoundTag}
	 */
	public static CompoundTag getRootTag(String modID) {
		CompoundTag root = TAGS.get(modID);
		if (root == null) {
			root = new CompoundTag();
			TAGS.put(modID, root);
		}
		return root;
	}
	
	/**
	 * Get {@link CompoundTag} with specified path from mod cache in world data folder.
	 *
	 * @param modID - {@link String} path to tag, dot-separated.
	 * @return {@link CompoundTag}
	 */
	public static CompoundTag getCompoundTag(String modID, String path) {
		String[] parts = path.split("\\.");
		CompoundTag tag = getRootTag(modID);
		for (String part : parts) {
			if (tag.contains(part)) {
				tag = tag.getCompound(part);
			}
			else {
				CompoundTag t = new CompoundTag();
				tag.put(part, t);
				tag = t;
			}
		}
		return tag;
	}
	
	/**
	 * Forces mod cache file to be saved.
	 *
	 * @param modID {@link String} mod ID.
	 */
	public static void saveFile(String modID) {
		try {
			if (!dataDir.exists()) {
				dataDir.mkdirs();
			}
			NbtIo.writeCompressed(getRootTag(modID), new File(dataDir, modID + ".nbt"));
		}
		catch (IOException e) {
			BCLib.LOGGER.error("World data saving failed", e);
		}
	}
	
	/**
	 * Get stored mod version (only for mods with registered cache).
	 *
	 * @return {@link String} mod version.
	 */
	public static String getModVersion(String modID) {
		return getRootTag(modID).getString("version");
	}

}
