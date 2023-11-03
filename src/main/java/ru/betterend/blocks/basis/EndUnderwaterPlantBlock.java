package ru.betterend.blocks.basis;

import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.tag.CommonBlockTags;
import ru.betterend.bclib.blocks.UnderwaterPlantBlock;

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
