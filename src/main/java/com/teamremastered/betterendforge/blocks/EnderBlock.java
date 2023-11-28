package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class EnderBlock extends BaseBlock {
	
	public EnderBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.WARPED_WART_BLOCK)
								 .destroyTime(5F)
								 .explosionResistance(6F)
								 .requiresCorrectToolForDrops()
								 .sound(SoundType.STONE));
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getColor(BlockState state, BlockGetter world, BlockPos pos) {
		return 0xFF005548;
	}
}
