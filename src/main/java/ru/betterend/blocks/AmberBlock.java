package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.blocks.BaseBlock;

public class AmberBlock extends BaseBlock {
	public AmberBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).color(MaterialColor.COLOR_YELLOW));
	}
}
