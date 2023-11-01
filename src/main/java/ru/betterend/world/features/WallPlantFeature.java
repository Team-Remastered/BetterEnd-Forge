package ru.betterend.world.features;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import ru.bclib.blocks.BaseAttachedBlock;
import ru.bclib.blocks.BaseWallPlantBlock;
import ru.bclib.util.BlocksHelper;

import java.util.Random;

public class WallPlantFeature extends WallScatterFeature {
	private final Block block;
	
	public WallPlantFeature(Block block, int radius) {
		super(radius);
		this.block = block;
	}
	
	@Override
	public boolean canGenerate(WorldGenLevel world, Random random, BlockPos pos, Direction dir) {
		if (block instanceof BaseWallPlantBlock) {
			BlockState state = block.defaultBlockState().setValue(BaseWallPlantBlock.FACING, dir);
			return block.canSurvive(state, world, pos);
		}
		else if (block instanceof BaseAttachedBlock) {
			BlockState state = block.defaultBlockState().setValue(BlockStateProperties.FACING, dir);
			return block.canSurvive(state, world, pos);
		}
		return block.canSurvive(block.defaultBlockState(), world, pos);
	}
	
	@Override
	public void generate(WorldGenLevel world, Random random, BlockPos pos, Direction dir) {
		BlockState state = block.defaultBlockState();
		if (block instanceof BaseWallPlantBlock) {
			state = state.setValue(BaseWallPlantBlock.FACING, dir);
		}
		else if (block instanceof BaseAttachedBlock) {
			state = state.setValue(BlockStateProperties.FACING, dir);
		}
		BlocksHelper.setWithoutUpdate(world, pos, state);
	}
}
