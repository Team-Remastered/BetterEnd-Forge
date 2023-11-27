package com.teamremastered.betterendforge.bclib.registry;

import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import com.teamremastered.betterendforge.bclib.api.tag.NamedBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonItemTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedItemTags;
import com.teamremastered.betterendforge.bclib.api.tag.NamedMineableTags;
import com.teamremastered.betterendforge.bclib.blocks.BaseLeavesBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseOreBlock;
import com.teamremastered.betterendforge.bclib.blocks.FeatureSaplingBlock;
import com.teamremastered.betterendforge.bclib.interfaces.CustomItemProvider;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;

public class BlockRegistry extends BaseRegistry<Block> {
	public BlockRegistry(CreativeModeTab creativeTab) {
		super(creativeTab);
	}

	@Override
	public Block register(ResourceLocation id, Block block) {
		
		BlockItem item = null;
		if (block instanceof CustomItemProvider) {
			item = ((CustomItemProvider) block).getCustomItem(id, makeItemSettings());
		}
		else {
			item = new BlockItem(block, makeItemSettings());
		}
		registerBlockItem(id, item);
//		if (block.defaultBlockState().getMaterial().isFlammable() && FlammableBlockRegistry.getDefaultInstance().get(block).getBurnChance() == 0) {
//			FlammableBlockRegistry.getDefaultInstance().add(block, 5, 5);
//		} //FIXME: FlammableBlockRegistry needs to be fixed

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

		Block finalBlock = block;
		EndBlocks.BLOCKS.register(id.getPath(), () -> finalBlock);

		return block;
	}
	
	public Block registerBlockOnly(ResourceLocation id, Block block) {
		getModBlocks(id.getNamespace()).add(block);
        EndBlocks.BLOCKS.register(id.getPath(), () -> block);
		return Registry.register(Registry.BLOCK, id, block);
	}
	
	private Item registerBlockItem(ResourceLocation id, Item item) {
		registerItem(id, item);
		return item;
	}
	
	@Override
	public void registerItem(ResourceLocation id, Item item) {
		if (item != null && item != Items.AIR) {
			EndItems.ITEMS.register(id.getPath(), () -> item);
			getModBlockItems(id.getNamespace()).add(item);
		}
	}
}