package ru.betterend.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.interfaces.RenderLayerProvider;
import ru.betterend.bclib.interfaces.tools.AddMineableAxe;

public class AmaranitaHymenophoreBlock extends BaseBlock implements RenderLayerProvider, AddMineableAxe {
	public AmaranitaHymenophoreBlock() {
		super(FabricBlockSettings.of(Material.WOOD).sound(SoundType.WOOD));
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
}
