package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.interfaces.tools.AddMineablePickaxe;
import ru.betterend.blocks.basis.LitPillarBlock;

public class SmaragdantCrystalBlock extends LitPillarBlock implements AddMineablePickaxe {
	public SmaragdantCrystalBlock() {
		super(BlockBehaviour.Properties.of(Material.GLASS)
								 .luminance(15)
								 .hardness(1F)
								 .resistance(1F)
								 .noOcclusion()
								 .sound(SoundType.AMETHYST));
	}
}
