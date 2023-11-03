package ru.betterend.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import ru.betterend.bclib.items.BaseAnvilItem;
import ru.betterend.blocks.basis.EndAnvilBlock;
import ru.betterend.item.material.EndToolMaterial;
import ru.betterend.registry.EndBlocks;

public class AeterniumAnvil extends EndAnvilBlock {
	public AeterniumAnvil() {
		super(EndBlocks.AETERNIUM_BLOCK.defaultMaterialColor(), EndToolMaterial.AETERNIUM.getLevel());
	}
	
	@Override
	public int getMaxDurability() {
		return 8;
	}
	
	@Override
	public BlockItem getCustomItem(ResourceLocation blockID, Item.Properties settings) {
		return new BaseAnvilItem(this, settings.fireproof());
	}
}
