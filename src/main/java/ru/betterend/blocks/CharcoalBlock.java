package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.level.block.Blocks;
import ru.betterend.bclib.blocks.BaseBlock;

public class CharcoalBlock extends BaseBlock {
	public CharcoalBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK));
		FuelRegistry.INSTANCE.add(this, 16000);
	}
}
