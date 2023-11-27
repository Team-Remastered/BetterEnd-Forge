package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.blocks.UpDownPlantBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import com.teamremastered.betterendforge.registry.EndBlocks;

public class GlowingPillarRootsBlock extends UpDownPlantBlock {
	public static final EnumProperty<BlockProperties.TripleShape> SHAPE = BlockProperties.TRIPLE_SHAPE;
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(SHAPE);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.AMBER_MOSS.get());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
		return new ItemStack(EndBlocks.GLOWING_PILLAR_SEED.get());
	}
}
