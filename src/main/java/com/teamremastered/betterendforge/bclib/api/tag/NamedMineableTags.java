package com.teamremastered.betterendforge.bclib.api.tag;

import net.minecraft.world.level.block.Block;

public class NamedMineableTags {
	public static final TagAPI.TagLocation<Block> AXE = new TagAPI.TagLocation<>("mineable/axe");
	public static final TagAPI.TagLocation<Block> HOE = new TagAPI.TagLocation<>("mineable/hoe");
	public static final TagAPI.TagLocation<Block> PICKAXE = new TagAPI.TagLocation<>("mineable/pickaxe");
	public static final TagAPI.TagLocation<Block> SHEARS = new TagAPI.TagLocation<>("fabric", "mineable/shears");
	public static final TagAPI.TagLocation<Block> SHOVEL = new TagAPI.TagLocation<>("mineable/shovel");
	public static final TagAPI.TagLocation<Block> SWORD = new TagAPI.TagLocation<>("fabric", "mineable/sword");
	public static final TagAPI.TagLocation<Block> HAMMER = new TagAPI.TagLocation<>("c", "mineable/hammer");
}
