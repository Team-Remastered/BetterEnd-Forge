package com.teamremastered.betterendforge.render;

import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;
import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BCLRendLayerProvider {

    public static void registerBlockRenderedLayer() {

        for (RegistryObject<Block> block : EndBlocks.BLOCKS.getEntries().stream().toList()) {
            if (block.get() instanceof RenderLayerProvider provider) {
                if (provider.getRenderLayer() == BCLRenderLayer.CUTOUT) {
                ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.cutout());
                } else if (provider.getRenderLayer() == BCLRenderLayer.TRANSLUCENT) {
                    ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.translucent());
                }
            }
        }
    }
}
