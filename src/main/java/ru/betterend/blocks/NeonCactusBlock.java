package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import ru.betterend.blocks.basis.LitPillarBlock;

public class NeonCactusBlock extends LitPillarBlock {
	public NeonCactusBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.CACTUS).luminance(15));
	}
}
