package ru.betterend.blocks.basis;

import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.tag.CommonBlockTags;
import ru.betterend.bclib.blocks.BaseWallPlantBlock;

public class EndWallPlantBlock extends BaseWallPlantBlock {
	public EndWallPlantBlock() {
	}
	
	public EndWallPlantBlock(int light) {
		super(light);
	}
	
	public EndWallPlantBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
}
