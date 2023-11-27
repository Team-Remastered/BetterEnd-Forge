package com.teamremastered.betterendforge.bclib.api;

import com.google.common.collect.Lists;
import com.teamremastered.betterendforge.bclib.BCLib;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.blocks.BaseBarrelBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseFurnaceBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseSignBlock;
import com.teamremastered.betterendforge.bclib.interfaces.PostInitable;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableSword;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import com.teamremastered.betterendforge.bclib.api.biomes.BiomeAPI;
import com.teamremastered.betterendforge.bclib.api.tag.NamedMineableTags;
import com.teamremastered.betterendforge.bclib.blocks.BaseChestBlock;
import com.teamremastered.betterendforge.bclib.interfaces.TagProvider;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableAxe;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableHammer;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableHoe;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineablePickaxe;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShears;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShovel;
import com.teamremastered.betterendforge.bclib.interfaces.tools.PreventMineableAdd;
import com.teamremastered.betterendforge.bclib.registry.BaseBlockEntities;

import java.util.List;
import java.util.function.Consumer;

public class PostInitAPI {
	private static List<Consumer<Boolean>> postInitFunctions = Lists.newArrayList();
	private static List<TagAPI.TagLocation<Block>> blockTags = Lists.newArrayList();
	private static List<TagAPI.TagLocation<Item>> itemTags = Lists.newArrayList();
	
	/**
	 * Register a new function which will be called after all mods are initiated. Will be called on both client and server.
	 * @param function {@link Consumer} with {@code boolean} parameter ({@code true} for client, {@code false} for server).
	 */
	public static void register(Consumer<Boolean> function) {
		postInitFunctions.add(function);
	}
	
	/**
	 * Called in proper BCLib entry points, for internal usage only.
	 * @param isClient {@code boolean}, {@code true} for client, {@code false} for server.
	 */
	public static void postInit(boolean isClient) {
		Registry.BLOCK.forEach(block -> {
			processBlockCommon(block);
			if (isClient) {
			//	processBlockClient(block); //FIXME: No idea what this does
			}
		});
		
		Registry.ITEM.forEach(item -> {
			processItemCommon(item);
		});
		
		if (postInitFunctions != null) {
			postInitFunctions.forEach(function -> function.accept(isClient));
			postInitFunctions = null;
		}
		
		blockTags = null;
		itemTags = null;
		BiomeAPI.loadFabricAPIBiomes();
	}
	
//	@OnlyIn(Dist.CLIENT)
//	private static void processBlockClient(Block block) {
//		if (block instanceof RenderLayerProvider) {
//			BCLRenderLayer layer = ((RenderLayerProvider) block).getRenderLayer();
//			if (layer == BCLRenderLayer.CUTOUT) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
//			else if (layer == BCLRenderLayer.TRANSLUCENT) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.translucent());
//		}
//		if (block instanceof BaseChestBlock) {
//			BaseChestBlockEntityRenderer.registerRenderLayer(block);
//		}
//		else if (block instanceof BaseSignBlock) {
//			BaseSignBlockEntityRenderer.registerRenderLayer(block);
//		}
//	} //FIXME: No idea what this does 2

	private static void processItemCommon(Item item) {
		if (item instanceof TagProvider provider){
			try {
				provider.addTags(null, itemTags);
			} catch (NullPointerException ex){
				BCLib.LOGGER.error(item + " probably tried to access blockTags.", ex);
			}
			itemTags.forEach(tag -> TagAPI.addItemTag(tag, item));
			itemTags.clear();
		}
	}
	
	private static void processBlockCommon(Block block) {
		if (block instanceof PostInitable) {
			((PostInitable) block).postInit();
		}
		if (block instanceof BaseChestBlock) {
			BaseBlockEntities.CHEST.registerBlock(block);
		}
		else if (block instanceof BaseSignBlock) {
			BaseBlockEntities.SIGN.registerBlock(block);
		}
		else if (block instanceof BaseBarrelBlock) {
			BaseBlockEntities.BARREL.registerBlock(block);
		}
		else if (block instanceof BaseFurnaceBlock) {
			BaseBlockEntities.FURNACE.registerBlock(block);
		}
		if (!(block instanceof PreventMineableAdd)) {
			if (block instanceof AddMineableShears) {
				TagAPI.addBlockTags(block, NamedMineableTags.SHEARS);
			}
			if (block instanceof AddMineableAxe) {
				TagAPI.addBlockTags(block, NamedMineableTags.AXE);
			}
			if (block instanceof AddMineablePickaxe) {
				TagAPI.addBlockTags(block, NamedMineableTags.PICKAXE);
			}
			if (block instanceof AddMineableShovel) {
				TagAPI.addBlockTags(block, NamedMineableTags.SHOVEL);
			}
			if (block instanceof AddMineableHoe) {
				TagAPI.addBlockTags(block, NamedMineableTags.HOE);
			}
			if (block instanceof AddMineableSword) {
				TagAPI.addBlockTags(block, NamedMineableTags.SWORD);
			}
			if (block instanceof AddMineableHammer) {
				TagAPI.addBlockTags(block, NamedMineableTags.HAMMER);
			}
		}
		if (block instanceof TagProvider) {
			TagProvider.class.cast(block).addTags(blockTags, itemTags);
			blockTags.forEach(tag -> TagAPI.addBlockTag(tag, block));
			itemTags.forEach(tag -> TagAPI.addItemTag(tag, block));
			blockTags.clear();
			itemTags.clear();
		}
	}
}
