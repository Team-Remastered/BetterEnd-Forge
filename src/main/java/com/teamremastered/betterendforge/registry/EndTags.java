package com.teamremastered.betterendforge.registry;

import com.google.common.collect.Lists;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.api.BonemealAPI;
import com.teamremastered.betterendforge.bclib.api.ComposterAPI;
import com.teamremastered.betterendforge.bclib.api.tag.NamedBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonItemTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedItemTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedMineableTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.blocks.BaseVineBlock;
import com.teamremastered.betterendforge.bclib.blocks.SimpleLeavesBlock;
import com.teamremastered.betterendforge.blocks.basis.EndTerrainBlock;
import com.teamremastered.betterendforge.blocks.basis.PedestalBlock;
import com.teamremastered.betterendforge.item.tool.EndHammerItem;
import com.teamremastered.betterendforge.mixin.common.fabric.AbstractBlockSettingsAccessor;
import com.teamremastered.betterendforge.world.biome.EndBiome;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.material.Material;

import java.util.List;

public class EndTags {
	// Table with common (c) tags:
	// https://fabricmc.net/wiki/tutorial:tags
	
	// Block Tags
	public static final TagKey<Block> PEDESTALS = TagAPI.makeBlockTag(BetterEndForge.MOD_ID, "pedestal");

	// Item Tags
	public static final TagKey<Item> ALLOYING_IRON = TagAPI.makeItemTag(BetterEndForge.MOD_ID, "alloying_iron");
	public static final TagKey<Item> ALLOYING_GOLD = TagAPI.makeItemTag(BetterEndForge.MOD_ID, "alloying_gold");
	public static final TagKey<Item> ALLOYING_COPPER = TagAPI.makeItemTag(BetterEndForge.MOD_ID, "alloying_copper");
	
	public static void register() {
		addEndGround(EndBlocks.THALLASIUM.ore.get());
		addEndGround(EndBlocks.ENDSTONE_DUST.get());
		addEndGround(EndBlocks.AMBER_ORE.get());
		
		EndBlocks.getModBlocks().forEach(block -> {
		//	Properties properties = ((AbstractBlockAccessor) block).getSettings();
			Material material = ((AbstractBlockSettingsAccessor) block).getMaterial();
			final Item item = block.asItem();
			
			if (material.equals(Material.STONE) || material.equals(Material.METAL) || material.equals(Material.HEAVY_METAL)) {
				TagAPI.addBlockTag(NamedMineableTags.PICKAXE, block);
			}
			else if (material.equals(Material.WOOD)) {
				TagAPI.addBlockTag(NamedMineableTags.AXE, block);
			}
			else if (material.equals(Material.LEAVES) || material.equals(Material.PLANT) || material.equals(Material.WATER_PLANT) || material.equals(Material.SPONGE)) {
				TagAPI.addBlockTag(NamedMineableTags.HOE, block);
			}
			else if (material.equals(Material.SAND)) {
				TagAPI.addBlockTag(NamedMineableTags.SHOVEL, block);
			}
			
			if (block instanceof EndTerrainBlock) {
				addEndGround(block);
				TagAPI.addBlockTag(NamedBlockTags.NYLIUM, block);
				BonemealAPI.addSpreadableBlock(block, Blocks.END_STONE);
			}
			else if (block instanceof LeavesBlock || block instanceof SimpleLeavesBlock) {
				TagAPI.addBlockTag(NamedBlockTags.LEAVES, block);
				ComposterAPI.allowCompost(0.3f, item);
			}
			else if (block instanceof BaseVineBlock) {
				TagAPI.addBlockTag(NamedBlockTags.CLIMBABLE, block);
			}
			else if (block instanceof PedestalBlock) {
				TagAPI.addBlockTag(PEDESTALS, block);
			}
			
			Material mat = block.defaultBlockState().getMaterial();
			if (mat.equals(Material.PLANT) || mat.equals(Material.REPLACEABLE_PLANT)) {
				ComposterAPI.allowCompost(0.1F, item);
			}
		});
		addEndGround(EndBlocks.CAVE_MOSS.get());
		TagAPI.addBlockTag(NamedBlockTags.NYLIUM, EndBlocks.CAVE_MOSS.get());
		BonemealAPI.addSpreadableBlock(EndBlocks.CAVE_MOSS.get(), Blocks.END_STONE);
		BonemealAPI.addSpreadableBlock(EndBlocks.MOSSY_OBSIDIAN.get(), Blocks.OBSIDIAN);
		BonemealAPI.addSpreadableBlock(EndBlocks.MOSSY_DRAGON_BONE.get(), EndBlocks.DRAGON_BONE_BLOCK.get());
		
		List<Item> ITEM_HAMMERS = Lists.newArrayList();
		EndItems.getModItems().forEach(item -> {
			if (item.isEdible()) {
				FoodProperties food = item.getFoodProperties();
				if (food != null) {
					float compost = food.getNutrition() * food.getSaturationModifier() * 0.18F;
					ComposterAPI.allowCompost(compost, item);
				}
			}
			if (item instanceof EndHammerItem) {
				ITEM_HAMMERS.add(item);
			}
		});

		TagAPI.addBlockTag(
			NamedCommonBlockTags.GEN_END_STONES,
			EndBlocks.ENDER_ORE.get(),
			EndBlocks.BRIMSTONE.get()
		);
		TagAPI.addBlockTag(NamedCommonBlockTags.END_STONES, EndBlocks.BRIMSTONE.get());
		TagAPI.addBlockTag(NamedBlockTags.ANVIL, EndBlocks.AETERNIUM_ANVIL.get());
		TagAPI.addBlockTag(NamedBlockTags.BEACON_BASE_BLOCKS, EndBlocks.AETERNIUM_BLOCK.get());
		TagAPI.addItemTag(NamedItemTags.BEACON_PAYMENT_ITEMS, EndItems.AETERNIUM_INGOT.get());
		TagAPI.addBlockTag(
			NamedCommonBlockTags.DRAGON_IMMUNE,
			EndBlocks.ENDER_ORE.get(),
			EndBlocks.ETERNAL_PEDESTAL.get(),
			EndBlocks.FLAVOLITE_RUNED_ETERNAL.get(),
			EndBlocks.FLAVOLITE_RUNED.get()
		);
		TagAPI.addItemTag(NamedCommonItemTags.IRON_INGOTS, EndBlocks.THALLASIUM.ingot.get());
		
		TagAPI.addItemTag(ALLOYING_IRON, Items.IRON_ORE, Items.DEEPSLATE_IRON_ORE, Items.RAW_IRON);
		TagAPI.addItemTag(ALLOYING_GOLD, Items.GOLD_ORE, Items.DEEPSLATE_GOLD_ORE, Items.RAW_GOLD);
		TagAPI.addItemTag(ALLOYING_COPPER, Items.COPPER_ORE, Items.DEEPSLATE_COPPER_ORE, Items.RAW_COPPER);
	}
	
	public static void addEndGround(Block bl){
		TagAPI.addBlockTag(NamedCommonBlockTags.END_STONES, bl);
	}
	
	public static void addBiomeSurfaceToEndGroup(EndBiome b){
		addEndGround(b.getTopMaterial().getBlock());
		addEndGround(b.getAltTopMaterial().getBlock());
		addEndGround(b.getUnderMaterial().getBlock());
	}
	
	// TODO make getter for biome top blocks
	public static void addTerrainTags(Registry<Biome> biomeRegistry) {
		/*biomeRegistry.forEach((biome) -> {
			if (biome.getBiomeCategory() == BiomeCategory.THEEND) {
				SurfaceBuilderConfiguration config = biome.getGenerationSettings().getSurfaceBuilderConfig();
				Block under = config.getUnderMaterial().getBlock();
				Block surface = config.getTopMaterial().getBlock();
				TagAPI.addTag(CommonBlockTags.GEN_END_STONES, under, surface);
				TagAPI.addTag(CommonBlockTags.END_STONES, surface);
			}
		});
		TagAPI.BLOCK_END_STONES.getValues().forEach(TagAPI::addEndGround);*/
	}
}
