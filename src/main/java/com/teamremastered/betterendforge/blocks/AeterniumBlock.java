package com.teamremastered.betterendforge.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.interfaces.CustomItemProvider;

public class AeterniumBlock extends BaseBlock implements CustomItemProvider {
	public AeterniumBlock() {
		super(BlockBehaviour.Properties
			.of(Material.METAL, MaterialColor.COLOR_GRAY)
			.destroyTime(65F)
			.explosionResistance(1200F)
			.requiresCorrectToolForDrops()
			.sound(SoundType.NETHERITE_BLOCK)
		);
	}
	
	@Override
	public BlockItem getCustomItem(ResourceLocation blockID, Item.Properties settings) {
		return new BlockItem(this, settings.fireResistant());
	}
}
