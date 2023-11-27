package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LitBaseBlock extends BaseBlock {
	private static final String PATTERN = "{\"parent\":\"betterend:block/cube_noshade\",\"textures\":{\"texture\":\"betterend:block/name\"}}";
	
	public LitBaseBlock(Properties settings) {
		super(settings);
	}
	
	@Nullable
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		return BlockModel.fromString(PATTERN.replace("name", resourceLocation.getPath()));
	}
}
