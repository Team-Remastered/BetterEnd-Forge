package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.blocks.BaseBlock;

public class DenseSnowBlock extends BaseBlock {
	public DenseSnowBlock() {
		super(BlockBehaviour.Properties.of(Material.SNOW).strength(0.2F).sound(SoundType.SNOW));
	}
}
