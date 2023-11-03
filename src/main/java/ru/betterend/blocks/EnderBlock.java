package ru.betterend.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.blocks.BaseBlock;

public class EnderBlock extends BaseBlock {
	
	public EnderBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WARPED_WART_BLOCK)
								 .destroyTime(5F)
								 .explosionResistance(6F)
								 .requiresCorrectToolForDrops()
								 .sound(SoundType.STONE));
	}
	
	@Environment(EnvType.CLIENT)
	public int getColor(BlockState state, BlockGetter world, BlockPos pos) {
		return 0xFF005548;
	}
}
