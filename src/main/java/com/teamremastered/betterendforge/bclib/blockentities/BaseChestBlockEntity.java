package com.teamremastered.betterendforge.bclib.blockentities;

import com.teamremastered.betterendforge.bclib.registry.BaseBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BaseChestBlockEntity extends ChestBlockEntity {
	public BaseChestBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(BaseBlockEntities.CHEST, blockPos, blockState);
	}
}