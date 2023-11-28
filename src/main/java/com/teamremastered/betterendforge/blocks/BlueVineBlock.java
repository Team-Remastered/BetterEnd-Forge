package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.UpDownPlantBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.registry.EndBlocks;

public class BlueVineBlock extends UpDownPlantBlock {
	public static final EnumProperty<BlockProperties.TripleShape> SHAPE = BlockProperties.TRIPLE_SHAPE;
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(SHAPE);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.getBlock() == EndBlocks.END_MOSS.get() || state.getBlock() == EndBlocks.END_MYCELIUM.get();
	}
}
