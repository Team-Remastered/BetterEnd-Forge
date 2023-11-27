package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseVineBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FilaluxBlock extends BaseVineBlock {
	public FilaluxBlock() {
		super(15, true);
	}
	
	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.NONE;
	}
}
