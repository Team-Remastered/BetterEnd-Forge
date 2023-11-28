package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.items.BaseAnvilItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import com.teamremastered.betterendforge.blocks.basis.EndAnvilBlock;
import com.teamremastered.betterendforge.item.material.EndToolMaterial;
import com.teamremastered.betterendforge.registry.EndBlocks;

public class AeterniumAnvil extends EndAnvilBlock {
	public AeterniumAnvil() {
		super(EndBlocks.AETERNIUM_BLOCK.get().defaultMaterialColor(), EndToolMaterial.AETERNIUM.getLevel());
	}
	
	@Override
	public int getMaxDurability() {
		return 8;
	}
	
	@Override
	public BlockItem getCustomItem(ResourceLocation blockID, Item.Properties settings) {
		return new BaseAnvilItem(this, settings.fireResistant());
	}
}
