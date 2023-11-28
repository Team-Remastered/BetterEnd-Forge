package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import com.teamremastered.betterendforge.blocks.basis.LitPillarBlock;

public class NeonCactusBlock extends LitPillarBlock {
	public NeonCactusBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.CACTUS).lightLevel(BlocksHelper.getLightValue(15)));
	}
}