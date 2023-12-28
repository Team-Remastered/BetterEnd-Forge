package com.teamremastered.betterendforge.util;

import com.teamremastered.betterendforge.bclib.api.biomes.BiomeAPI;
import com.teamremastered.betterendforge.bclib.world.biomes.BCLBiome;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.registry.world.EndBiomes;

//FIXME: Use GLMS to inject inside loot tables

public class LootTableUtil {
	private static final ResourceLocation END_CITY_TREASURE_ID = new ResourceLocation("chests/end_city_treasure");
	private static final ResourceLocation COMMON = BetterEndForge.makeID("chests/common");
	private static final ResourceLocation FOGGY_MUSHROOMLAND = BetterEndForge.makeID("chests/foggy_mushroomland");
	private static final ResourceLocation CHORUS_FOREST = BetterEndForge.makeID("chests/chorus_forest");
	private static final ResourceLocation SHADOW_FOREST = BetterEndForge.makeID("chests/shadow_forest");
	private static final ResourceLocation LANTERN_WOODS = BetterEndForge.makeID("chests/lantern_woods");
	private static final ResourceLocation UMBRELLA_JUNGLE = BetterEndForge.makeID("chests/umbrella_jungle");

	public static void init() {
//		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
//			if (END_CITY_TREASURE_ID.equals(id)) {
//				FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
//				builder.setRolls(ConstantValue.exactly(1));
//				builder.withCondition(LootItemRandomChanceCondition.randomChance(0.2f).build());
//				builder.withEntry(LootItem.lootTableItem(Items.GHAST_TEAR).build());
//				table.withPool(builder);
//
//				builder = FabricLootPoolBuilder.builder();
//				builder.setRolls(UniformGenerator.between(0, 3));
//				builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_STRANGE_AND_ALIEN.get()).build());
//				builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_GRASPING_AT_STARS.get()).build());
//				builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_ENDSEEKER.get()).build());
//				builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_EO_DRACONA.get()).build());
//				table.withPool(builder);
//			}
//			else if (id.getNamespace().equals(BetterEndForge.MOD_ID)) {
//				addCommonItems(table);
//				if (FOGGY_MUSHROOMLAND.equals(id)) {
//					FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
//					builder.setRolls(UniformGenerator.between(4, 8));
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.MOSSY_GLOWSHROOM.getBlock(WoodenComplexMaterial.BLOCK_PLANKS)).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.MOSSY_GLOWSHROOM_SAPLING.get()).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.BLUE_VINE_SEED.get()).build());
//					table.withPool(builder);
//				}
//				else if (CHORUS_FOREST.equals(id)) {
//					FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
//					builder.setRolls(UniformGenerator.between(4, 8));
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.PYTHADENDRON.getBlock(WoodenComplexMaterial.BLOCK_PLANKS)).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.PYTHADENDRON_SAPLING.get()).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.CHORUS_MUSHROOM.get()).build());
//					table.withPool(builder);
//				}
//				else if (SHADOW_FOREST.equals(id)) {
//					FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
//					builder.setRolls(UniformGenerator.between(4, 8));
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.DRAGON_TREE.getBlock(WoodenComplexMaterial.BLOCK_PLANKS)).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.DRAGON_TREE_SAPLING.get()).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.SHADOW_BERRY.get()).build());
//					builder.withEntry(LootItem.lootTableItem(EndItems.SHADOW_BERRY_RAW.get()).build());
//					table.withPool(builder);
//				}
//				else if (LANTERN_WOODS.equals(id)) {
//					FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
//					builder.setRolls(UniformGenerator.between(4, 8));
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.LUCERNIA.getBlock(WoodenComplexMaterial.BLOCK_PLANKS)).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.LUCERNIA_SAPLING.get()).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.BOLUX_MUSHROOM.get()).build());
//					table.withPool(builder);
//				}
//				else if (UMBRELLA_JUNGLE.equals(id)) {
//					FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
//					builder.setRolls(UniformGenerator.between(4, 8));
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.UMBRELLA_TREE.getBlock(WoodenComplexMaterial.BLOCK_PLANKS)).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.UMBRELLA_TREE_SAPLING.get()).build());
//					builder.withEntry(LootItem.lootTableItem(EndBlocks.SMALL_JELLYSHROOM.get()).build());
//					table.withPool(builder);
//				}
//			}
//		});
	}

	public static ResourceLocation getTable(Holder<Biome> biome) {
		BCLBiome bclBiome = BiomeAPI.getBiome(biome.value());
		if (bclBiome.getBiome() == EndBiomes.FOGGY_MUSHROOMLAND.get()) {
			return FOGGY_MUSHROOMLAND;
		}
		else if (bclBiome.getBiome() == EndBiomes.CHORUS_FOREST.get()) {
			return CHORUS_FOREST;
		}
		else if (bclBiome.getBiome() == EndBiomes.SHADOW_FOREST.get()) {
			return SHADOW_FOREST;
		}
		else if (bclBiome.getBiome() == EndBiomes.LANTERN_WOODS.get()) {
			return LANTERN_WOODS;
		}
		else if (bclBiome.getBiome() == EndBiomes.UMBRELLA_JUNGLE.get()) {
			return UMBRELLA_JUNGLE;
		}
		return COMMON;
	}

//	private static void addCommonItems(FabricLootSupplierBuilder table) {
//		FabricLootPoolBuilder builder = FabricLootPoolBuilder.builder();
//		builder.setRolls(UniformGenerator.between(0, 2));
//		builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_STRANGE_AND_ALIEN.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_GRASPING_AT_STARS.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_ENDSEEKER.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndItems.MUSIC_DISC_EO_DRACONA.get()).build());
//		table.withPool(builder);
//
//		builder = FabricLootPoolBuilder.builder();
//		builder.setRolls(UniformGenerator.between(4, 8));
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.THALLASIUM.ingot.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.THALLASIUM.rawOre.get()).build());
//		builder.withEntry(LootItem.lootTableItem(Items.ENDER_PEARL).build());
//		table.withPool(builder);
//
//		builder = FabricLootPoolBuilder.builder();
//		builder.setRolls(UniformGenerator.between(2, 4));
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.TERMINITE.ingot.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndItems.ENDER_SHARD.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.AURORA_CRYSTAL.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.THALLASIUM.axe.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.THALLASIUM.pickaxe.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.THALLASIUM.hoe.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.THALLASIUM.sword.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.THALLASIUM.shovel.get()).build());
//		builder.withEntry(LootItem.lootTableItem(Items.ENDER_EYE).build());
//		builder.withEntry(LootItem.lootTableItem(Blocks.OBSIDIAN).build());
//		table.withPool(builder);
//
//		builder = FabricLootPoolBuilder.builder();
//		builder.setRolls(UniformGenerator.between(0, 4));
//		builder.withEntry(LootItem.lootTableItem(EndBlocks.FLAVOLITE_RUNED.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndItems.AETERNIUM_INGOT.get()).build());
//		builder.withEntry(LootItem.lootTableItem(EndItems.AMBER_GEM.get()).build());
//		builder.withEntry(LootItem.lootTableItem(Items.END_CRYSTAL).build());
//		builder.withEntry(LootItem.lootTableItem(Items.GHAST_TEAR).build());
//		table.withPool(builder);
//	}
}