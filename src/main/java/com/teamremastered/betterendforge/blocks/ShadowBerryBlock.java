package com.teamremastered.betterendforge.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import com.teamremastered.betterendforge.blocks.basis.PottableCropBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;

public class ShadowBerryBlock extends PottableCropBlock {
	private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 8, 15);
	
	public ShadowBerryBlock() {
		super(EndItems.SHADOW_BERRY_RAW.get(), EndBlocks.SHADOW_GRASS.get());
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}
}
