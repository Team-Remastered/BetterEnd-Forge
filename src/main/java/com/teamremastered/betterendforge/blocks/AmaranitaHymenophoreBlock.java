package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableAxe;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;

public class AmaranitaHymenophoreBlock extends BaseBlock implements RenderLayerProvider, AddMineableAxe {
	public AmaranitaHymenophoreBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD));
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
}
