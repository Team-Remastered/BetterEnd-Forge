package ru.betterend.bclib.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public abstract class BasePlantWithAgeBlock extends BasePlantBlock {
	public static final IntegerProperty AGE = BlockProperties.AGE;
	
	public BasePlantWithAgeBlock() {
		this(
			FabricBlockSettings.of(Material.PLANT)
				.sound(SoundType.GRASS)
				.randomTicks()
				.noCollission()
		);
	}
	
	public BasePlantWithAgeBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(AGE);
	}
	
	public abstract void growAdult(WorldGenLevel world, Random random, BlockPos pos);
	
	@Override
	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
		int age = state.getValue(AGE);
		if (age < 3) {
			world.setBlockAndUpdate(pos, state.setValue(AGE, age + 1));
		}
		else {
			growAdult(world, random, pos);
		}
	}
	
	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return true;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		super.tick(state, world, pos, random);
		if (random.nextInt(8) == 0) {
			performBonemeal(world, random, pos, state);
		}
	}
}
