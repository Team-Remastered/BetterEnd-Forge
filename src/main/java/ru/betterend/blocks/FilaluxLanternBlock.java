package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.interfaces.tools.AddMineableAxe;

public class FilaluxLanternBlock extends BaseBlock implements AddMineableAxe {
	public FilaluxLanternBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD)
								 .luminance(15)
								 .sound(SoundType.WOOD));
	}
}
