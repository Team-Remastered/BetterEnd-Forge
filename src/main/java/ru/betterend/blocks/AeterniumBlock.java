package ru.betterend.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.interfaces.CustomItemProvider;

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
		return new BlockItem(this, settings.fireproof());
	}
}
