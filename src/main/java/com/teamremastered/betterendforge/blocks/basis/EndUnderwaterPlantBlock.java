package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.blocks.UnderwaterPlantBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EndUnderwaterPlantBlock extends UnderwaterPlantBlock {
	
	public EndUnderwaterPlantBlock() {
	}
	
	public EndUnderwaterPlantBlock(int light) {
		super(light);
	}
	
	public EndUnderwaterPlantBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
}
