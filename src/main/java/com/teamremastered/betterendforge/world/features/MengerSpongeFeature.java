package com.teamremastered.betterendforge.world.features;

import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;
import java.util.function.Function;

public class MengerSpongeFeature extends UnderwaterPlantScatter {
	private static final Function<BlockState, Boolean> REPLACE;
	
	public MengerSpongeFeature(int radius) {
		super(radius);
	}
	
	@Override
	public void generate(WorldGenLevel world, Random random, BlockPos blockPos) {
		BlocksHelper.setWithoutUpdate(world, blockPos, EndBlocks.MENGER_SPONGE_WET.get());
		if (random.nextBoolean()) {
			for (Direction dir : BlocksHelper.DIRECTIONS) {
				BlockPos pos = blockPos.relative(dir);
				if (REPLACE.apply(world.getBlockState(pos))) {
					BlocksHelper.setWithoutUpdate(world, pos, EndBlocks.MENGER_SPONGE_WET.get());
				}
			}
		}
	}
	
	static {
		REPLACE = (state) -> {
			if (state.is(EndBlocks.END_LOTUS_STEM.get())) {
				return false;
			}
			return !state.getFluidState().isEmpty() || state.getMaterial().isReplaceable();
		};
	}
}
