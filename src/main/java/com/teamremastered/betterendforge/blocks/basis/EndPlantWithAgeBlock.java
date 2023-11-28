package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.blocks.BasePlantWithAgeBlock;
import net.minecraft.world.level.block.state.BlockState;

public abstract class EndPlantWithAgeBlock extends BasePlantWithAgeBlock {
	
	public EndPlantWithAgeBlock() {
	}
	
	public EndPlantWithAgeBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
}
