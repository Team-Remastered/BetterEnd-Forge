package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.interfaces.tools.AddMineableAxe;

public class HydraluxPetalBlock extends BaseBlock implements AddMineableAxe {
	public HydraluxPetalBlock() {
		this(
			BlockBehaviour.Properties
				.of(Material.PLANT)
				.destroyTime(1)
				.explosionResistance(1)
				.color(MaterialColor.PODZOL)
				.sound(SoundType.WART_BLOCK)
		);
	}
	
	public HydraluxPetalBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
	}
}
