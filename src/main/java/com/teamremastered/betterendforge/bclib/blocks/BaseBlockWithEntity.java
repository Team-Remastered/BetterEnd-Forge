package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BaseBlockWithEntity extends BaseEntityBlock implements LootProvider {
	public BaseBlockWithEntity(Properties settings) {
		super(settings);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return null;
	}
}
