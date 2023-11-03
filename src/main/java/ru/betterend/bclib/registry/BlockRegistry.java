package ru.betterend.bclib.registry;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import ru.betterend.bclib.api.tag.NamedBlockTags;
import ru.betterend.bclib.api.tag.NamedCommonBlockTags;
import ru.betterend.bclib.api.tag.NamedCommonItemTags;
import ru.betterend.bclib.api.tag.NamedItemTags;
import ru.betterend.bclib.api.tag.NamedMineableTags;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.blocks.BaseLeavesBlock;
import ru.betterend.bclib.blocks.BaseOreBlock;
import ru.betterend.bclib.blocks.FeatureSaplingBlock;
import ru.betterend.bclib.config.PathConfig;
import ru.betterend.bclib.interfaces.CustomItemProvider;

public class BlockRegistry extends BaseRegistry<Block> {
	public BlockRegistry(CreativeModeTab creativeTab, PathConfig config) {
		super(creativeTab, config);
	}
	
	@Override
	public Block register(ResourceLocation id, Block block) {
		if (!config.getBooleanRoot(id.getNamespace(), true)) {
			return block;
		}
		
		BlockItem item = null;
		if (block instanceof CustomItemProvider) {
			item = ((CustomItemProvider) block).getCustomItem(id, makeItemSettings());
		}
		else {
			item = new BlockItem(block, makeItemSettings());
		}
		registerBlockItem(id, item);
		if (block.defaultBlockState().getMaterial().isFlammable() && FlammableBlockRegistry.getDefaultInstance().get(block).getBurnChance() == 0) {
			FlammableBlockRegistry.getDefaultInstance().add(block, 5, 5);
		}

		block = Registry.register(Registry.BLOCK, id, block);
		getModBlocks(id.getNamespace()).add(block);

		if (block instanceof BaseLeavesBlock){
			TagAPI.addBlockTags(
				block,
				NamedBlockTags.LEAVES,
				NamedCommonBlockTags.LEAVES,
				NamedMineableTags.HOE,
				NamedMineableTags.SHEARS
			);
			if (item != null){
				TagAPI.addItemTags(item, NamedCommonItemTags.LEAVES, NamedItemTags.LEAVES);
			}
		} else if (block instanceof BaseOreBlock){
			TagAPI.addBlockTags(block, NamedMineableTags.PICKAXE);
		} else if (block instanceof FeatureSaplingBlock){
			TagAPI.addBlockTags(block, NamedCommonBlockTags.SAPLINGS, NamedBlockTags.SAPLINGS);
			if (item != null){
				TagAPI.addItemTags(item, NamedCommonItemTags.SAPLINGS, NamedItemTags.SAPLINGS);
			}
		}

		return block;
	}
	
	public Block registerBlockOnly(ResourceLocation id, Block block) {
		if (!config.getBooleanRoot(id.getNamespace(), true)) {
			return block;
		}
		getModBlocks(id.getNamespace()).add(block);
		return Registry.register(Registry.BLOCK, id, block);
	}
	
	private Item registerBlockItem(ResourceLocation id, Item item) {
		registerItem(id, item);
		return item;
	}
	
	@Override
	public void registerItem(ResourceLocation id, Item item) {
		if (item != null && item != Items.AIR) {
			Registry.register(Registry.ITEM, id, item);
			getModBlockItems(id.getNamespace()).add(item);
		}
	}
}
