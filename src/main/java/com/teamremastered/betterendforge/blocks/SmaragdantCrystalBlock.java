package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineablePickaxe;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import com.teamremastered.betterendforge.blocks.basis.LitPillarBlock;

public class SmaragdantCrystalBlock extends LitPillarBlock implements AddMineablePickaxe {
	public SmaragdantCrystalBlock() {
		super(BlockBehaviour.Properties.of(Material.GLASS)
								 .lightLevel(BlocksHelper.getLightValue(15))
								 .destroyTime(1F)
								 .explosionResistance(1F)
								 .noOcclusion()
								 .sound(SoundType.AMETHYST));
	}
}
