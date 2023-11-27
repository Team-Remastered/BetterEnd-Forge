package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableAxe;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;

public class AmaranitaCapBlock extends BaseBlock implements AddMineableAxe {
	public AmaranitaCapBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD));
	}
}
