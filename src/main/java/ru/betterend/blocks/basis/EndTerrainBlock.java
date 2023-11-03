package ru.betterend.blocks.basis;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.api.tag.NamedCommonBlockTags;
import ru.betterend.bclib.api.tag.TagAPI.TagLocation;
import ru.betterend.bclib.blocks.BaseTerrainBlock;
import ru.betterend.bclib.interfaces.TagProvider;
import ru.betterend.interfaces.PottableTerrain;

import java.util.List;

public class EndTerrainBlock extends BaseTerrainBlock implements PottableTerrain, TagProvider {
	public EndTerrainBlock(MaterialColor color) {
		super(Blocks.END_STONE, color);
	}
	
	@Override
	public void addTags(List<TagLocation<Block>> blockTags, List<TagLocation<Item>> itemTags) {
		blockTags.add(NamedCommonBlockTags.END_STONES);
	}
}
