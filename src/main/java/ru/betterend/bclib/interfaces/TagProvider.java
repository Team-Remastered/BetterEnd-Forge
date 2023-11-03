package ru.betterend.bclib.interfaces;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import ru.betterend.bclib.api.tag.TagAPI.TagLocation;

import java.util.List;

public interface TagProvider {
	void addTags(List<TagLocation<Block>> blockTags, List<TagLocation<Item>> itemTags);
}
