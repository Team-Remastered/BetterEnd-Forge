package ru.betterend.blocks.basis;

import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.tag.CommonBlockTags;
import ru.betterend.bclib.blocks.WallMushroomBlock;

public class EndWallMushroom extends WallMushroomBlock {
	
	public EndWallMushroom(int light) {
		super(light);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
}
