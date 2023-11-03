package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.interfaces.tools.AddMineableAxe;

public class AmaranitaCapBlock extends BaseBlock implements AddMineableAxe {
	public AmaranitaCapBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD));
	}
}
