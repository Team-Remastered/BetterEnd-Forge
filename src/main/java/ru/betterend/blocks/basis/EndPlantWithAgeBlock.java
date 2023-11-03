package ru.betterend.blocks.basis;

import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.tag.CommonBlockTags;
import ru.betterend.bclib.blocks.BasePlantWithAgeBlock;

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
