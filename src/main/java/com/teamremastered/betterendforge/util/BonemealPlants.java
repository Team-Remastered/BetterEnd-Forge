package com.teamremastered.betterendforge.util;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import com.teamremastered.betterendforge.bclib.api.BonemealAPI;
import com.teamremastered.betterendforge.blocks.basis.EndTerrainBlock;
import com.teamremastered.betterendforge.registry.world.EndBiomes;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.List;

public class BonemealPlants {
	public static void init() {
		BonemealAPI.addLandGrass(EndBlocks.CREEPING_MOSS.get(), EndBlocks.END_MOSS.get());
		BonemealAPI.addLandGrass(EndBlocks.UMBRELLA_MOSS.get(), EndBlocks.END_MOSS.get());
		BonemealAPI.addLandGrass(EndBlocks.CREEPING_MOSS.get(), EndBlocks.END_MYCELIUM.get());
		BonemealAPI.addLandGrass(EndBlocks.UMBRELLA_MOSS.get(), EndBlocks.END_MYCELIUM.get());
		
		BonemealAPI.addLandGrass(EndBlocks.CAVE_GRASS.get(), EndBlocks.CAVE_MOSS.get());
		BonemealAPI.addLandGrass(EndBlocks.CHORUS_GRASS.get(), EndBlocks.CHORUS_NYLIUM.get());
		BonemealAPI.addLandGrass(EndBlocks.CRYSTAL_GRASS.get(), EndBlocks.CRYSTAL_MOSS.get());
		BonemealAPI.addLandGrass(EndBlocks.SHADOW_PLANT.get(), EndBlocks.SHADOW_GRASS.get());
		BonemealAPI.addLandGrass(EndBlocks.BUSHY_GRASS.get(), EndBlocks.PINK_MOSS.get());
		BonemealAPI.addLandGrass(EndBlocks.AMBER_GRASS.get(), EndBlocks.AMBER_MOSS.get());
		
		BonemealAPI.addLandGrass(EndBlocks.JUNGLE_GRASS.get(), EndBlocks.JUNGLE_MOSS.get());
		BonemealAPI.addLandGrass(EndBlocks.TWISTED_UMBRELLA_MOSS.get(), EndBlocks.JUNGLE_MOSS.get());
		BonemealAPI.addLandGrass(EndBlocks.SMALL_JELLYSHROOM.get(), EndBlocks.JUNGLE_MOSS.get(), 0.1F);
		
		BonemealAPI.addLandGrass(
			EndBiomes.GLOWING_GRASSLANDS.getId(),
			EndBlocks.BLOOMING_COOKSONIA.get(),
			EndBlocks.END_MOSS.get()
		);
		BonemealAPI.addLandGrass(EndBiomes.GLOWING_GRASSLANDS.getId(), EndBlocks.VAIOLUSH_FERN.get(), EndBlocks.END_MOSS.get());
		BonemealAPI.addLandGrass(EndBiomes.GLOWING_GRASSLANDS.getId(), EndBlocks.FRACTURN.get(), EndBlocks.END_MOSS.get());
		BonemealAPI.addLandGrass(EndBiomes.GLOWING_GRASSLANDS.getId(), EndBlocks.SALTEAGO.get(), EndBlocks.END_MOSS.get());
		
		BonemealAPI.addLandGrass(
			EndBiomes.GLOWING_GRASSLANDS.getId(),
			EndBlocks.CREEPING_MOSS.get(),
			EndBlocks.END_MOSS.get(),
			0.1F
		);
		BonemealAPI.addLandGrass(
			EndBiomes.GLOWING_GRASSLANDS.getId(),
			EndBlocks.UMBRELLA_MOSS.get(),
			EndBlocks.END_MOSS.get(),
			0.1F
		);
		BonemealAPI.addLandGrass(
			EndBiomes.GLOWING_GRASSLANDS.getId(),
			EndBlocks.TWISTED_UMBRELLA_MOSS.get(),
			EndBlocks.END_MOSS.get(),
			0.1F
		);
		
		BonemealAPI.addLandGrass(EndBlocks.ORANGO.get(), EndBlocks.RUTISCUS.get());
		BonemealAPI.addLandGrass(EndBlocks.AERIDIUM.get(), EndBlocks.RUTISCUS.get(), 0.2F);
		BonemealAPI.addLandGrass(EndBlocks.LUTEBUS.get(), EndBlocks.RUTISCUS.get(), 0.2F);
		BonemealAPI.addLandGrass(EndBlocks.LAMELLARIUM.get(), EndBlocks.RUTISCUS.get());
		
		BonemealAPI.addLandGrass(EndBiomes.LANTERN_WOODS.getId(), EndBlocks.AERIDIUM.get(), EndBlocks.RUTISCUS.get(), 0.2F);
		BonemealAPI.addLandGrass(EndBiomes.LANTERN_WOODS.getId(), EndBlocks.LAMELLARIUM.get(), EndBlocks.RUTISCUS.get());
		BonemealAPI.addLandGrass(EndBiomes.LANTERN_WOODS.getId(), EndBlocks.BOLUX_MUSHROOM.get(), EndBlocks.RUTISCUS.get(), 0.05F);
		
		BonemealAPI.addLandGrass(
			EndBlocks.GLOBULAGUS.get(),
			EndBlocks.SANGNUM.get(),
			EndBlocks.MOSSY_OBSIDIAN.get(),
			EndBlocks.MOSSY_DRAGON_BONE.get()
		);
		BonemealAPI.addLandGrass(
			EndBlocks.CLAWFERN.get(),
			EndBlocks.SANGNUM.get(),
			EndBlocks.MOSSY_OBSIDIAN.get(),
			EndBlocks.MOSSY_DRAGON_BONE.get()
		);
		BonemealAPI.addLandGrass(EndBlocks.SANGNUM.get(), EndBlocks.SMALL_AMARANITA_MUSHROOM.get(), 0.1F);
		BonemealAPI.addLandGrass(EndBlocks.SMALL_AMARANITA_MUSHROOM.get(), EndBlocks.MOSSY_OBSIDIAN.get(), 0.1F);
		BonemealAPI.addLandGrass(EndBlocks.SMALL_AMARANITA_MUSHROOM.get(), EndBlocks.MOSSY_DRAGON_BONE.get(), 0.1F);
		
		BonemealAPI.addLandGrass(EndBlocks.GLOBULAGUS.get(), EndBlocks.MOSSY_DRAGON_BONE.get());
		BonemealAPI.addLandGrass(EndBlocks.CLAWFERN.get(), EndBlocks.MOSSY_DRAGON_BONE.get());
		BonemealAPI.addLandGrass(EndBlocks.SMALL_AMARANITA_MUSHROOM.get(), EndBlocks.MOSSY_DRAGON_BONE.get(), 0.1F);
		
		BonemealAPI.addLandGrass(EndBlocks.GLOBULAGUS.get(), EndBlocks.MOSSY_OBSIDIAN.get());
		BonemealAPI.addLandGrass(EndBlocks.CLAWFERN.get(), EndBlocks.MOSSY_OBSIDIAN.get());
		BonemealAPI.addLandGrass(EndBlocks.SMALL_AMARANITA_MUSHROOM.get(), EndBlocks.MOSSY_OBSIDIAN.get(), 0.1F);
		
		Block[] charnias = new Block[] {
			EndBlocks.CHARNIA_CYAN.get(),
			EndBlocks.CHARNIA_GREEN.get(),
			EndBlocks.CHARNIA_ORANGE.get(),
			EndBlocks.CHARNIA_LIGHT_BLUE.get(),
			EndBlocks.CHARNIA_PURPLE.get(),
			EndBlocks.CHARNIA_RED.get()
		};
		List<Block> terrain = Lists.newArrayList();
		EndBlocks.getModBlocks().forEach(block -> {
			if (block instanceof EndTerrainBlock) {
				terrain.add(block);
			}
		});
		terrain.add(Blocks.END_STONE);
		terrain.add(EndBlocks.ENDSTONE_DUST.get());
		terrain.add(EndBlocks.CAVE_MOSS.get());
		terrain.add(EndBlocks.SULPHURIC_ROCK.stone.get());
		terrain.add(EndBlocks.VIOLECITE.stone.get());
		terrain.add(EndBlocks.FLAVOLITE.stone.get());
		terrain.add(EndBlocks.AZURE_JADESTONE.stone.get());
		terrain.add(EndBlocks.VIRID_JADESTONE.stone.get());
		terrain.add(EndBlocks.SANDY_JADESTONE.stone.get());
		terrain.add(EndBlocks.BRIMSTONE.get());
		Block[] terrainBlocks = terrain.toArray(new Block[terrain.size()]);
		for (Block charnia : charnias) {
			BonemealAPI.addWaterGrass(charnia, terrainBlocks);
		}
	}
}
