package com.teamremastered.betterendforge.blocks;

import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.EndPlantBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

public class ChorusGrassBlock extends EndPlantBlock {
	public ChorusGrassBlock() {
		super(true);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.getBlock() == EndBlocks.CHORUS_NYLIUM.get();
	}
}
