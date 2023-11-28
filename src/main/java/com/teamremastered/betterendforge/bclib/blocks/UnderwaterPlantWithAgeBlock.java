package com.teamremastered.betterendforge.bclib.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public abstract class UnderwaterPlantWithAgeBlock extends UnderwaterPlantBlock {
	public static final IntegerProperty AGE = BlockProperties.AGE;
	
	public UnderwaterPlantWithAgeBlock() {
		super(
			BlockBehaviour.Properties
				.of(Material.WATER_PLANT)
				.sound(SoundType.WET_GRASS)
				.randomTicks()
				.noCollission()
		);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(AGE);
	}
	
	public abstract void grow(WorldGenLevel world, Random random, BlockPos pos);
	
	@Override
	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
		if (random.nextInt(4) == 0) {
			int age = state.getValue(AGE);
			if (age < 3) {
				world.setBlockAndUpdate(pos, state.setValue(AGE, age + 1));
			}
			else {
				grow(world, random, pos);
			}
		}
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		super.tick(state, world, pos, random);
		if (isBonemealSuccess(world, random, pos, state)) {
			performBonemeal(world, random, pos, state);
		}
	}
}
