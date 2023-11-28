package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.blocks.WallMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;

public class EndWallMushroom extends WallMushroomBlock {
	
	public EndWallMushroom(int light) {
		super(light);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
}
