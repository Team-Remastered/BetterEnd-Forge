package com.teamremastered.betterendforge.bclib.interfaces;

import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.List;

public interface TagProvider {
	void addTags(List<TagAPI.TagLocation<Block>> blockTags, List<TagAPI.TagLocation<Item>> itemTags);
}
