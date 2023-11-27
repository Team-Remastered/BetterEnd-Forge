package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import com.teamremastered.betterendforge.blocks.basis.EndPlantWithAgeBlock;
import com.teamremastered.betterendforge.blocks.basis.FurBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class BlueVineSeedBlock extends EndPlantWithAgeBlock {
	@Override
	public void growAdult(WorldGenLevel world, Random random, BlockPos pos) {
		int height = MHelper.randRange(2, 5, random);
		int h = BlocksHelper.upRay(world, pos, height + 2);
		if (h < height + 1) {
			return;
		}
		BlocksHelper.setWithoutUpdate(
			world,
			pos,
			EndBlocks.BLUE_VINE.get().defaultBlockState()
							   .setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.BOTTOM)
		);
		for (int i = 1; i < height; i++) {
			BlocksHelper.setWithoutUpdate(
				world,
				pos.above(i),
				EndBlocks.BLUE_VINE.get().defaultBlockState()
								   .setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.MIDDLE)
			);
		}
		BlocksHelper.setWithoutUpdate(
			world,
			pos.above(height),
			EndBlocks.BLUE_VINE.get().defaultBlockState()
							   .setValue(BlockProperties.TRIPLE_SHAPE, BlockProperties.TripleShape.TOP)
		);
		placeLantern(world, pos.above(height + 1));
	}
	
	private void placeLantern(WorldGenLevel world, BlockPos pos) {
		BlocksHelper.setWithoutUpdate(
			world,
			pos,
			EndBlocks.BLUE_VINE_LANTERN.get().defaultBlockState().setValue(BlueVineLanternBlock.NATURAL, true)
		);
		for (Direction dir : BlocksHelper.HORIZONTAL) {
			BlockPos p = pos.relative(dir);
			if (world.isEmptyBlock(p)) {
				BlocksHelper.setWithoutUpdate(
					world,
					p,
					EndBlocks.BLUE_VINE_FUR.get().defaultBlockState().setValue(FurBlock.FACING, dir)
				);
			}
		}
		if (world.isEmptyBlock(pos.above())) {
			BlocksHelper.setWithoutUpdate(
				world,
				pos.above(),
				EndBlocks.BLUE_VINE_FUR.get().defaultBlockState().setValue(FurBlock.FACING, Direction.UP)
			);
		}
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.END_MOSS.get()) || state.is(EndBlocks.END_MYCELIUM.get());
	}
	
	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.NONE;
	}
}
