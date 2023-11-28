package com.teamremastered.betterendforge.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.bclib.blocks.BaseRotatedPillarBlock;

public class AmaranitaStemBlock extends BaseRotatedPillarBlock {
	public AmaranitaStemBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GREEN));
	}
}
