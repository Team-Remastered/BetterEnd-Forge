package ru.betterend.bclib.api;

import com.google.common.collect.Lists;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.api.biomes.BiomeAPI;
import ru.betterend.bclib.api.tag.NamedMineableTags;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.api.tag.TagAPI.TagLocation;
import ru.betterend.bclib.blocks.BaseBarrelBlock;
import ru.betterend.bclib.blocks.BaseChestBlock;
import ru.betterend.bclib.blocks.BaseFurnaceBlock;
import ru.betterend.bclib.blocks.BaseSignBlock;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.client.render.BaseChestBlockEntityRenderer;
import ru.betterend.bclib.client.render.BaseSignBlockEntityRenderer;
import ru.betterend.bclib.config.Configs;
import ru.betterend.bclib.interfaces.PostInitable;
import ru.betterend.bclib.interfaces.RenderLayerProvider;
import ru.betterend.bclib.interfaces.TagProvider;
import ru.betterend.bclib.interfaces.tools.AddMineableAxe;
import ru.betterend.bclib.interfaces.tools.AddMineableHammer;
import ru.betterend.bclib.interfaces.tools.AddMineableHoe;
import ru.betterend.bclib.interfaces.tools.AddMineablePickaxe;
import ru.betterend.bclib.interfaces.tools.AddMineableShears;
import ru.betterend.bclib.interfaces.tools.AddMineableShovel;
import ru.betterend.bclib.interfaces.tools.AddMineableSword;
import ru.betterend.bclib.interfaces.tools.PreventMineableAdd;
import ru.betterend.bclib.registry.BaseBlockEntities;

import java.util.List;
import java.util.function.Consumer;

public class PostInitAPI {
	private static List<Consumer<Boolean>> postInitFunctions = Lists.newArrayList();
	private static List<TagLocation<Block>> blockTags = Lists.newArrayList();
	private static List<TagLocation<Item>> itemTags = Lists.newArrayList();
	
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
				processBlockClient(block);
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
		Configs.BIOMES_CONFIG.saveChanges();
	}
	
	@OnlyIn(Dist.CLIENT)
	private static void processBlockClient(Block block) {
		if (block instanceof RenderLayerProvider) {
			BCLRenderLayer layer = ((RenderLayerProvider) block).getRenderLayer();
			if (layer == BCLRenderLayer.CUTOUT) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
			else if (layer == BCLRenderLayer.TRANSLUCENT) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.translucent());
		}
		if (block instanceof BaseChestBlock) {
			BaseChestBlockEntityRenderer.registerRenderLayer(block);
		}
		else if (block instanceof BaseSignBlock) {
			BaseSignBlockEntityRenderer.registerRenderLayer(block);
		}
	}
	
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
