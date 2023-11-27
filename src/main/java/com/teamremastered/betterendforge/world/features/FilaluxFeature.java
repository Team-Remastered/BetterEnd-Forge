package com.teamremastered.betterendforge.world.features;

import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class FilaluxFeature extends SkyScatterFeature {
	public FilaluxFeature() {
		super(10);
	}
	
	@Override
	public void generate(WorldGenLevel world, Random random, BlockPos blockPos) {
		BlockState vine = EndBlocks.FILALUX.get().defaultBlockState();
		BlockState wings = EndBlocks.FILALUX_WINGS.get().defaultBlockState();
		BlocksHelper.setWithoutUpdate(world, blockPos, EndBlocks.FILALUX_LANTERN.get());
		BlocksHelper.setWithoutUpdate(
			world,
			blockPos.above(),
			wings.setValue(BlockStateProperties.FACING, Direction.UP)
		);
		for (Direction dir : BlocksHelper.HORIZONTAL) {
			BlocksHelper.setWithoutUpdate(
				world,
				blockPos.relative(dir),
				wings.setValue(BlockStateProperties.FACING, dir)
			);
		}
		int length = MHelper.randRange(1, 3, random);
		for (int i = 1; i <= length; i++) {
			BlockProperties.TripleShape shape = length > 1 ? BlockProperties.TripleShape.TOP : BlockProperties.TripleShape.BOTTOM;
			if (i > 1) {
				shape = i == length ? BlockProperties.TripleShape.BOTTOM : BlockProperties.TripleShape.MIDDLE;
			}
			BlocksHelper.setWithoutUpdate(world, blockPos.below(i), vine.setValue(BlockProperties.TRIPLE_SHAPE, shape));
		}
	}
}
