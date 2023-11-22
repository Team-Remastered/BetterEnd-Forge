package ru.betterend.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.blocks.basis.PottableFeatureSapling;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndFeatures;

public class DragonTreeSaplingBlock extends PottableFeatureSapling {
	public DragonTreeSaplingBlock() {
		super((state)->EndFeatures.DRAGON_TREE.getFeature());
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).is(EndBlocks.SHADOW_GRASS.get());
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		return block == EndBlocks.SHADOW_GRASS.get();
	}
}
