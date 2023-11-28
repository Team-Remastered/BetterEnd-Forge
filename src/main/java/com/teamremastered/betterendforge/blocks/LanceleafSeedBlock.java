package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.EndPlantWithAgeBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class LanceleafSeedBlock extends EndPlantWithAgeBlock {
	@Override
	public void growAdult(WorldGenLevel world, Random random, BlockPos pos) {
		int height = MHelper.randRange(4, 6, random);
		int h = BlocksHelper.upRay(world, pos, height + 2);
		if (h < height + 1) {
			return;
		}
		int rotation = random.nextInt(4);
		MutableBlockPos mut = new MutableBlockPos().set(pos);
		BlockState plant = EndBlocks.LANCELEAF.get().defaultBlockState().setValue(BlockProperties.ROTATION, rotation);
		BlocksHelper.setWithoutUpdate(world, mut, plant.setValue(BlockProperties.PENTA_SHAPE, BlockProperties.PentaShape.BOTTOM));
		BlocksHelper.setWithoutUpdate(
			world,
			mut.move(Direction.UP),
			plant.setValue(BlockProperties.PENTA_SHAPE, BlockProperties.PentaShape.PRE_BOTTOM)
		);
		for (int i = 2; i < height - 2; i++) {
			BlocksHelper.setWithoutUpdate(
				world,
				mut.move(Direction.UP),
				plant.setValue(BlockProperties.PENTA_SHAPE, BlockProperties.PentaShape.MIDDLE)
			);
		}
		BlocksHelper.setWithoutUpdate(
			world,
			mut.move(Direction.UP),
			plant.setValue(BlockProperties.PENTA_SHAPE, BlockProperties.PentaShape.PRE_TOP)
		);
		BlocksHelper.setWithoutUpdate(
			world,
			mut.move(Direction.UP),
			plant.setValue(BlockProperties.PENTA_SHAPE, BlockProperties.PentaShape.TOP)
		);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.AMBER_MOSS.get());
	}
	
	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.NONE;
	}
}
