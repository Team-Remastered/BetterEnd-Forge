package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class DenseSnowBlock extends BaseBlock {
	public DenseSnowBlock() {
		super(BlockBehaviour.Properties.of(Material.SNOW).strength(0.2F).sound(SoundType.SNOW));
	}
}
