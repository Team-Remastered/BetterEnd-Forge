package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import ru.betterend.bclib.blocks.BaseBlock;

public class MissingTileBlock extends BaseBlock {
	public MissingTileBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.END_STONE));
	}
}
