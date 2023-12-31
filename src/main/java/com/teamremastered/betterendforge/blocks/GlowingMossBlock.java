package com.teamremastered.betterendforge.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import com.teamremastered.betterendforge.blocks.basis.EndPlantBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

public class GlowingMossBlock extends EndPlantBlock {
	public GlowingMossBlock(int light) {
		super(light);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.getBlock() == EndBlocks.END_MOSS.get() || state.getBlock() == EndBlocks.END_MYCELIUM.get();
	}
	
	@OnlyIn(Dist.CLIENT)
	public boolean hasEmissiveLighting(BlockGetter world, BlockPos pos) {
		return true;
	}
	
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightLevel(BlockGetter world, BlockPos pos) {
		return 1F;
	}
}