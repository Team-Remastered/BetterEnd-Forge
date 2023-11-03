package ru.betterend.world.features;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.blocks.BaseDoublePlantBlock;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.bclib.util.MHelper;

import java.util.Random;

public class DoublePlantFeature extends ScatterFeature {
	private final Block smallPlant;
	private final Block largePlant;
	private Block plant;
	
	public DoublePlantFeature(Block smallPlant, Block largePlant, int radius) {
		super(radius);
		this.smallPlant = smallPlant;
		this.largePlant = largePlant;
	}
	
	@Override
	public boolean canGenerate(WorldGenLevel world, Random random, BlockPos center, BlockPos blockPos, float radius) {
		float d = MHelper.length(
			center.getX() - blockPos.getX(),
			center.getZ() - blockPos.getZ()
		) / radius * 0.6F + random.nextFloat() * 0.4F;
		plant = d < 0.5F ? largePlant : smallPlant;
		return plant.canSurvive(plant.defaultBlockState(), world, blockPos);
	}
	
	@Override
	public void generate(WorldGenLevel world, Random random, BlockPos blockPos) {
		if (plant instanceof BaseDoublePlantBlock) {
			int rot = random.nextInt(4);
			BlockState state = plant.defaultBlockState().setValue(BaseDoublePlantBlock.ROTATION, rot);
			BlocksHelper.setWithoutUpdate(world, blockPos, state);
			BlocksHelper.setWithoutUpdate(world, blockPos.above(), state.setValue(BaseDoublePlantBlock.TOP, true));
		}
		else {
			BlocksHelper.setWithoutUpdate(world, blockPos, plant);
		}
	}
}
