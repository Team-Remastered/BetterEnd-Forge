package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.blocks.BlockHelper;
import ru.betterend.bclib.interfaces.tools.AddMineableAxe;

public class GlowingHymenophoreBlock extends BaseBlock implements AddMineableAxe {
	public GlowingHymenophoreBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD)
								 .lightLevel(BlockHelper.getLightValue(15))
								 .sound(SoundType.WART_BLOCK));
	}
}
