package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.PottableFeatureSapling;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndFeatures;

public class UmbrellaTreeSaplingBlock extends PottableFeatureSapling {
	public UmbrellaTreeSaplingBlock() {
		super((state)-> EndFeatures.UMBRELLA_TREE.getFeature());
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getBlockState(pos.below()).is(EndBlocks.JUNGLE_MOSS.get());
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		return block == EndBlocks.JUNGLE_MOSS.get();
	}
}
