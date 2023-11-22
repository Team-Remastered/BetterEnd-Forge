package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.blocks.BlockProperties;
import ru.betterend.bclib.blocks.BlockProperties.TripleShape;
import ru.betterend.bclib.interfaces.tools.AddMineableShears;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.bclib.util.MHelper;
import ru.betterend.blocks.basis.EndPlantWithAgeBlock;
import ru.betterend.registry.EndBlocks;

import java.util.Random;

public class GlowingPillarSeedBlock extends EndPlantWithAgeBlock implements AddMineableShears {
	
	public GlowingPillarSeedBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT)
								 .sound(SoundType.GRASS)
								 .lightLevel(state -> state.getValue(AGE) * 3 + 3)
								 .randomTicks()
								 .noCollission());
	}
	
	@Override
	public void growAdult(WorldGenLevel world, Random random, BlockPos pos) {
		int height = MHelper.randRange(1, 2, random);
		int h = BlocksHelper.upRay(world, pos, height + 2);
		if (h < height) {
			return;
		}
		
		MutableBlockPos mut = new MutableBlockPos().set(pos);
		BlockState roots = EndBlocks.GLOWING_PILLAR_ROOTS.get().defaultBlockState();
		if (height < 2) {
			BlocksHelper.setWithUpdate(world, mut, roots.setValue(BlockProperties.TRIPLE_SHAPE, TripleShape.MIDDLE));
		}
		else {
			BlocksHelper.setWithUpdate(world, mut, roots.setValue(BlockProperties.TRIPLE_SHAPE, TripleShape.BOTTOM));
			mut.move(Direction.UP);
			BlocksHelper.setWithUpdate(world, mut, roots.setValue(BlockProperties.TRIPLE_SHAPE, TripleShape.TOP));
		}
		mut.move(Direction.UP);
		BlocksHelper.setWithUpdate(
			world,
			mut,
			EndBlocks.GLOWING_PILLAR_LUMINOPHOR.get().defaultBlockState().setValue(BlueVineLanternBlock.NATURAL, true)
		);
		for (Direction dir : BlocksHelper.DIRECTIONS) {
			pos = mut.relative(dir);
			if (world.isEmptyBlock(pos)) {
				BlocksHelper.setWithUpdate(
					world,
					pos,
					EndBlocks.GLOWING_PILLAR_LEAVES.get().defaultBlockState().setValue(BlockStateProperties.FACING, dir)
				);
			}
		}
		mut.move(Direction.UP);
		if (world.isEmptyBlock(mut)) {
			BlocksHelper.setWithUpdate(
				world,
				mut,
				EndBlocks.GLOWING_PILLAR_LEAVES.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.UP)
			);
		}
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
