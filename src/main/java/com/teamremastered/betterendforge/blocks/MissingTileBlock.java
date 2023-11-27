package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;

public class MissingTileBlock extends BaseBlock {
	public MissingTileBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.END_STONE));
	}
}
