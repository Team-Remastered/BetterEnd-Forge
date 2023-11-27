package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.blocks.BaseTerrainBlock;
import com.teamremastered.betterendforge.bclib.interfaces.TagProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.interfaces.PottableTerrain;

import java.util.List;

public class EndTerrainBlock extends BaseTerrainBlock implements PottableTerrain, TagProvider {
	public EndTerrainBlock(MaterialColor color) {
		super(Blocks.END_STONE, color);
	}
	
	@Override
	public void addTags(List<TagAPI.TagLocation<Block>> blockTags, List<TagAPI.TagLocation<Item>> itemTags) {
		blockTags.add(NamedCommonBlockTags.END_STONES);
	}
}
