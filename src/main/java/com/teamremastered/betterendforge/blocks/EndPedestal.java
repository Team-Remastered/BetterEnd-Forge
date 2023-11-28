package com.teamremastered.betterendforge.blocks;

import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import com.teamremastered.betterendforge.blocks.basis.PedestalBlock;

import java.util.Map;

public class EndPedestal extends PedestalBlock {
	
	public EndPedestal(Block parent) {
		super(parent);
	}
	
	@Override
	protected Map<String, String> createTexturesMap() {
		ResourceLocation blockId = Registry.BLOCK.getKey(parent);
		String name = blockId.getPath();
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%mod%", BetterEndForge.MOD_ID);
		textures.put("%top%", name + "_polished");
		textures.put("%base%", name + "_polished");
		textures.put("%pillar%", name + "_pillar_side");
		textures.put("%bottom%", name + "_polished");
		return textures;
	}
}
