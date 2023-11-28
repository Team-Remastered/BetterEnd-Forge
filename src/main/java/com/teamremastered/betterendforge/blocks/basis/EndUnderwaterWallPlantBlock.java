package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.blocks.BaseUnderwaterWallPlantBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EndUnderwaterWallPlantBlock extends BaseUnderwaterWallPlantBlock {
	
	public EndUnderwaterWallPlantBlock() {
	}
	
	public EndUnderwaterWallPlantBlock(int light) {
		super(light);
	}
	
	public EndUnderwaterWallPlantBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
}
