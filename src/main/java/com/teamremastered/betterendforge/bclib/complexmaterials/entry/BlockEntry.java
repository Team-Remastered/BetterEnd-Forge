package com.teamremastered.betterendforge.bclib.complexmaterials.entry;

import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.complexmaterials.ComplexMaterial;
import com.teamremastered.betterendforge.bclib.registry.BlockRegistry;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;

public class BlockEntry extends ComplexMaterialEntry {
	final BiFunction<ComplexMaterial, BlockBehaviour.Properties, Block> initFunction;
	final boolean hasItem;
	
	TagAPI.TagLocation<Block>[] blockTags;
	TagAPI.TagLocation<Item>[] itemTags;
	
	public BlockEntry(String suffix, BiFunction<ComplexMaterial, BlockBehaviour.Properties, Block> initFunction) {
		this(suffix, true, initFunction);
	}
	
	public BlockEntry(String suffix, boolean hasItem, BiFunction<ComplexMaterial, BlockBehaviour.Properties, Block> initFunction) {
		super(suffix);
		this.initFunction = initFunction;
		this.hasItem = hasItem;
	}
	
	public BlockEntry setBlockTags(TagAPI.TagLocation<Block>... blockTags) {
		this.blockTags = blockTags;
		return this;
	}
	
	public BlockEntry setItemTags(TagAPI.TagLocation<Item>... itemTags) {
		this.itemTags = itemTags;
		return this;
	}
	
	public Block init(ComplexMaterial material, BlockBehaviour.Properties blockSettings, BlockRegistry registry) {
		ResourceLocation location = getLocation(material.getModID(), material.getBaseName());
		Block block = initFunction.apply(material, blockSettings);
		if (hasItem) {
			registry.register(location, block);
			if (itemTags != null) {
				TagAPI.addItemTags(block, itemTags);
			}
		}
		else {
			registry.registerBlockOnly(location, block);
		}
		if (blockTags != null) {
			TagAPI.addBlockTags(block, blockTags);
		}
		return block;
	}
}
