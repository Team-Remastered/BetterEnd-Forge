package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BaseWoodenSlabBlock extends BaseSlabBlock{
    public BaseWoodenSlabBlock(Block source) {
        super(source);
    }

    @Override
    public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
        BaseSlabBlock baseSlabBlock = (BaseSlabBlock) block;

        String blockName = baseSlabBlock.getRegistryName().getPath() + "_planks";

        ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
        if (stateProvider.models().existingFileHelper.exists(BetterEndForge.makeID("block/" + blockName.replace("_slab", "_block")), pathToBlockStates)) {
            blockName = blockName.replace("_slab", "_block");
        } else {
            blockName = blockName.replace("_slab", "");
        }

        stateProvider.slabBlock(baseSlabBlock, baseSlabBlock.getRegistryName(), BetterEndForge.makeID("block/" + blockName));
        stateProvider.simpleBlockItem(baseSlabBlock, stateProvider.models().getBuilder("block/" + baseSlabBlock.getRegistryName().getPath()));
    }
}
