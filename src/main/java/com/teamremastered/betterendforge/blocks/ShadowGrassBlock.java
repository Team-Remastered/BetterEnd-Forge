package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.interfaces.TagProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.blocks.basis.EndTerrainBlock;
import com.teamremastered.betterendforge.registry.EndParticles;

import java.util.List;
import java.util.Random;

public class ShadowGrassBlock extends EndTerrainBlock implements TagProvider {
	public ShadowGrassBlock() {
		super(MaterialColor.COLOR_BLACK);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level world, BlockPos pos, Random random) {
		super.animateTick(state, world, pos, random);
		if (random.nextInt(32) == 0) {
			world.addParticle(
				EndParticles.BLACK_SPORE.get(),
				(double) pos.getX() + random.nextDouble(),
				(double) pos.getY() + 1.1D,
				(double) pos.getZ() + random.nextDouble(),
				0.0D,
				0.0D,
				0.0D
			);
		}
	}
	
	@Override
	public void addTags(List<TagAPI.TagLocation<Block>> blockTags, List<TagAPI.TagLocation<Item>> itemTags) {
		blockTags.add(NamedCommonBlockTags.END_STONES);
	}
}
