package com.teamremastered.betterendforge.blocks;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import com.teamremastered.betterendforge.bclib.blocks.BaseVineBlock;
import com.teamremastered.betterendforge.bclib.blocks.BlockProperties.TripleShape;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;

import java.util.List;

public class BulbVineBlock extends BaseVineBlock {
	public BulbVineBlock() {
		super(15, true);
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		if (state.getValue(SHAPE) == TripleShape.BOTTOM) {
			return Lists.newArrayList(new ItemStack(EndItems.GLOWING_BULB.get()));
		}
		else if (MHelper.RANDOM.nextInt(8) == 0) {
			return Lists.newArrayList(new ItemStack(EndBlocks.BULB_VINE_SEED.get()));
		}
		else {
			return Lists.newArrayList();
		}
	}
	
	@Override
	public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		boolean canPlace = super.canSurvive(state, world, pos);
		return (state.is(this) && state.getValue(SHAPE) == TripleShape.BOTTOM) ? canPlace : canPlace && world.getBlockState(
			pos.below()).is(this);
	}
}
