package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShears;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import com.teamremastered.betterendforge.blocks.basis.EndPlantBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class LargeAmaranitaBlock extends EndPlantBlock implements AddMineableShears {
	public static final EnumProperty<BlockProperties.TripleShape> SHAPE = BlockProperties.TRIPLE_SHAPE;
	private static final VoxelShape SHAPE_BOTTOM = Block.box(4, 0, 4, 12, 14, 12);
	private static final VoxelShape SHAPE_TOP = Shapes.or(Block.box(1, 3, 1, 15, 16, 15), SHAPE_BOTTOM);
	
	public LargeAmaranitaBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT)
								 
								 .sound(SoundType.GRASS)
								 .lightLevel((state) -> (state.getValue(SHAPE) == BlockProperties.TripleShape.TOP) ? 15 : 0));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return state.getValue(SHAPE) == BlockProperties.TripleShape.TOP ? SHAPE_TOP : SHAPE_BOTTOM;
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.SANGNUM.get()) || state.is(EndBlocks.MOSSY_OBSIDIAN.get()) || state.is(EndBlocks.MOSSY_DRAGON_BONE.get());
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(SHAPE);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockProperties.TripleShape shape = state.getValue(SHAPE);
		if (shape == BlockProperties.TripleShape.BOTTOM) {
			return isTerrain(world.getBlockState(pos.below())) && world.getBlockState(pos.above()).is(this);
		}
		else if (shape == BlockProperties.TripleShape.TOP) {
			return world.getBlockState(pos.below()).is(this);
		}
		else {
			return world.getBlockState(pos.below()).is(this) && world.getBlockState(pos.above()).is(this);
		}
	}
	
	@Override
	public OffsetType getOffsetType() {
		return OffsetType.NONE;
	}
	
	@Override
	public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}
	
	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return false;
	}
}
