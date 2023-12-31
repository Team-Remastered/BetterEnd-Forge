package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.BaseRotatedPillarBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class LitPillarBlock extends BaseRotatedPillarBlock {
	private static final String PATTERN = "{\"parent\":\"betterend:block/pillar_noshade\",\"textures\":{\"end\":\"betterend:block/name_top\",\"side\":\"betterend:block/name_side\"}}";
	
	public LitPillarBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	protected Optional<String> createBlockPattern(ResourceLocation blockId) {
		String name = blockId.getPath();
		return Optional.of(PATTERN.replace("name", name));
	}
}
