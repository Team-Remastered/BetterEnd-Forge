package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class UmbrellaTreeClusterEmptyBlock extends BaseBlock {
	public static final BooleanProperty NATURAL = EndBlockProperties.NATURAL;
	
	public UmbrellaTreeClusterEmptyBlock() {
		super(BlockBehaviour.Properties
			.copy(Blocks.NETHER_WART_BLOCK)
			.color(MaterialColor.COLOR_PURPLE)
			.randomTicks()
		);
		registerDefaultState(stateDefinition.any().setValue(NATURAL, false));
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(NATURAL);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		if (state.getValue(NATURAL) && random.nextInt(16) == 0) {
			BlocksHelper.setWithUpdate(
				world,
				pos,
				EndBlocks.UMBRELLA_TREE_CLUSTER.get().defaultBlockState().setValue(UmbrellaTreeClusterBlock.NATURAL, true)
			);
		}
	}
}
