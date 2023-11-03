package ru.betterend.bclib.integration;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.world.features.BCLFeature;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ModIntegration {
	private final String modID;
	
	public void init() {}
	
	public ModIntegration(String modID) {
		this.modID = modID;
	}
	
	public ResourceLocation getID(String name) {
		return new ResourceLocation(modID, name);
	}

	public ResourceKey<PlacedFeature> getFeatureKey(String name) {
		return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, getID(name));
	}
	
	public Block getBlock(String name) {
		return Registry.BLOCK.get(getID(name));
	}
	
	public Item getItem(String name) {
		return Registry.ITEM.get(getID(name));
	}
	
	public BlockState getDefaultState(String name) {
		return getBlock(name).defaultBlockState();
	}
	
	public ResourceKey<Biome> getKey(String name) {
		return ResourceKey.create(Registry.BIOME_REGISTRY, getID(name));
	}
	
	public boolean modIsInstalled() {
		return FabricLoader.getInstance().isModLoaded(modID);
	}
	
	public BCLFeature getFeature(String featureID, String placedFeatureID, GenerationStep.Decoration featureStep) {
		ResourceLocation id = getID(featureID);
		Feature<?> feature = Registry.FEATURE.get(id);
		Holder<PlacedFeature> featurePlaced = BuiltinRegistries.PLACED_FEATURE.getHolder(getFeatureKey(placedFeatureID)).orElse(null);
		return new BCLFeature(id, feature, featureStep, featurePlaced);
	}
	
	public BCLFeature getFeature(String name, GenerationStep.Decoration featureStep) {
		return getFeature(name, name, featureStep);
	}
	
	public ConfiguredFeature<?, ?> getConfiguredFeature(String name) {
		return BuiltinRegistries.CONFIGURED_FEATURE.get(getID(name));
	}
	
	public Holder<Biome> getBiome(String name) {
		return BuiltinRegistries.BIOME.getHolder(getKey(name)).orElseThrow();
	}
	
	public Class<?> getClass(String path) {
		Class<?> cl = null;
		try {
			cl = Class.forName(path);
		}
		catch (ClassNotFoundException e) {
			BCLib.LOGGER.error(e.getMessage());
			if (BCLib.isDevEnvironment()) {
				e.printStackTrace();
			}
		}
		return cl;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Object> T getStaticFieldValue(Class<?> cl, String name) {
		if (cl != null) {
			try {
				Field field = cl.getDeclaredField(name);
				if (field != null) {
					return (T) field.get(null);
				}
			}
			catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Object getFieldValue(Class<?> cl, String name, Object classInstance) {
		if (cl != null) {
			try {
				Field field = cl.getDeclaredField(name);
				if (field != null) {
					return field.get(classInstance);
				}
			}
			catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Method getMethod(Class<?> cl, String functionName, Class<?>... args) {
		if (cl != null) {
			try {
				return cl.getMethod(functionName, args);
			}
			catch (NoSuchMethodException | SecurityException e) {
				BCLib.LOGGER.error(e.getMessage());
				if (BCLib.isDevEnvironment()) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public Object executeMethod(Object instance, Method method, Object... args) {
		if (method != null) {
			try {
				return method.invoke(instance, args);
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				BCLib.LOGGER.error(e.getMessage());
				if (BCLib.isDevEnvironment()) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public Object getAndExecuteStatic(Class<?> cl, String functionName, Object... args) {
		if (cl != null) {
			Class<?>[] classes = new Class<?>[args.length];
			for (int i = 0; i < args.length; i++) {
				classes[i] = args[i].getClass();
			}
			Method method = getMethod(cl, functionName, classes);
			return executeMethod(null, method, args);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Object> T getAndExecuteRuntime(Class<?> cl, Object instance, String functionName, Object... args) {
		if (instance != null) {
			Class<?>[] classes = new Class<?>[args.length];
			for (int i = 0; i < args.length; i++) {
				classes[i] = args[i].getClass();
			}
			Method method = getMethod(cl, functionName, classes);
			return (T) executeMethod(instance, method, args);
		}
		return null;
	}
	
	public Object newInstance(Class<?> cl, Object... args) {
		if (cl != null) {
			for (Constructor<?> constructor : cl.getConstructors()) {
				if (constructor.getParameterCount() == args.length) {
					try {
						return constructor.newInstance(args);
					}
					catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						BCLib.LOGGER.error(e.getMessage());
						if (BCLib.isDevEnvironment()) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}
	
	public TagKey<Item> getItemTag(String name) {
		ResourceLocation id = getID(name);
		return TagAPI.makeItemTag(id);
	}
	
	public TagKey<Block> getBlockTag(String name) {
		ResourceLocation id = getID(name);
		return TagAPI.makeBlockTag(id);
	}
}
