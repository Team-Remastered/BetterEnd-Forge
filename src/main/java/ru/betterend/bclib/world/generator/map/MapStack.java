package ru.betterend.bclib.world.generator.map;

import net.minecraft.util.Mth;
import org.apache.commons.lang3.function.TriFunction;
import ru.betterend.bclib.interfaces.BiomeChunk;
import ru.betterend.bclib.interfaces.BiomeMap;
import ru.betterend.bclib.interfaces.TriConsumer;
import ru.betterend.bclib.noise.OpenSimplexNoise;
import ru.betterend.bclib.world.biomes.BCLBiome;
import ru.betterend.bclib.world.generator.BiomePicker;

import java.util.Random;

public class MapStack implements BiomeMap {
	private final OpenSimplexNoise noise;
	private final BiomeMap[] maps;
	private final double layerDistortion;
	private final int worldHeight;
	private final int minValue;
	private final int maxValue;
	private final int maxIndex;
	
	public MapStack(long seed, int size, BiomePicker picker, int mapHeight, int worldHeight, TriFunction<Long, Integer, BiomePicker, BiomeMap> mapConstructor) {
		final int mapCount = Mth.ceil((float) worldHeight / mapHeight);
		this.maxIndex = mapCount - 1;
		this.worldHeight = worldHeight;
		this.layerDistortion = mapHeight * 0.1;
		minValue = Mth.floor(mapHeight * 0.5F + 0.5F);
		maxValue = Mth.floor(worldHeight - mapHeight * 0.5F + 0.5F);
		maps = new BiomeMap[mapCount];
		Random random = new Random(seed);
		for (int i = 0; i < mapCount; i++) {
			maps[i] = mapConstructor.apply(random.nextLong(), size, picker);
			maps[i].setChunkProcessor(this::onChunkCreation);
		}
		noise = new OpenSimplexNoise(random.nextInt());
	}
	
	@Override
	public void clearCache() {
		for (BiomeMap map: maps) {
			map.clearCache();
		}
	}
	
	@Override
	public void setChunkProcessor(TriConsumer<Integer, Integer, Integer> processor) {}
	
	@Override
	public BiomeChunk getChunk(int cx, int cz, boolean update) {
		return null;
	}
	
	@Override
	public BCLBiome getBiome(double x, double y, double z) {
		int mapIndex;
		
		if (y < minValue) {
			mapIndex = 0;
		}
		else if (y > maxValue) {
			mapIndex = maxIndex;
		}
		else {
			mapIndex = Mth.floor((y + noise.eval(x * 0.03, z * 0.03) * layerDistortion) / worldHeight * maxIndex + 0.5F);
			mapIndex = Mth.clamp(mapIndex, 0, maxIndex);
		}
		
		return maps[mapIndex].getBiome(x, y, z);
	}
	
	private void onChunkCreation(int cx, int cz, int side) {
		BCLBiome[][] biomeMap = new BCLBiome[side][side];
		BiomeChunk[] chunks = new BiomeChunk[maps.length];
		
		boolean isNoEmpty = false;
		for (int i = 0; i < maps.length; i++) {
			chunks[i] = maps[i].getChunk(cx, cz, false);
			for (int x = 0; x < side; x++) {
				for (int z = 0; z < side; z++) {
					if (biomeMap[x][z] == null) {
						BCLBiome biome = chunks[i].getBiome(x, z);
						if (biome.isVertical()) {
							biomeMap[x][z] = biome;
							isNoEmpty = true;
						}
					}
				}
			}
		}
		
		if (isNoEmpty) {
			for (int i = 0; i < maps.length; i++) {
				for (int x = 0; x < side; x++) {
					for (int z = 0; z < side; z++) {
						if (biomeMap[x][z] != null) {
							chunks[i].setBiome(x, z, biomeMap[x][z]);
						}
					}
				}
			}
		}
	}
}
