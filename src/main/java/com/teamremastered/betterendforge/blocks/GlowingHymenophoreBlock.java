package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableAxe;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class GlowingHymenophoreBlock extends BaseBlock implements AddMineableAxe {
	public GlowingHymenophoreBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD)
								 .lightLevel(BlocksHelper.getLightValue(15))
								 .sound(SoundType.WART_BLOCK));
	}
}
