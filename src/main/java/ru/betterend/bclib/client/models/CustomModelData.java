package ru.betterend.bclib.client.models;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public class CustomModelData {
	private static final Set<ResourceLocation> TRANSPARENT_EMISSION = Sets.newConcurrentHashSet();
	
	public static void clear() {
		TRANSPARENT_EMISSION.clear();
	}
	
	public static void addTransparent(ResourceLocation blockID) {
		TRANSPARENT_EMISSION.add(blockID);
	}
	
	public static boolean isTransparentEmissive(ResourceLocation rawLocation) {
		String name = rawLocation.getPath().replace("materialmaps/block/", "").replace(".json", "");
		return TRANSPARENT_EMISSION.contains(new ResourceLocation(rawLocation.getNamespace(), name));
	}
}
