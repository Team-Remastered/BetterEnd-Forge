package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BaseWoodenStairsBlock extends BaseStairsBlock{
    public BaseWoodenStairsBlock(Block source) {
        super(source);
    }

    @Override
    public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
        BaseStairsBlock baseStairsBlock = (BaseStairsBlock) block;

        String blockName = baseStairsBlock.getRegistryName().getPath() + "_planks";

        ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
        if (stateProvider.models().existingFileHelper.exists(BetterEndForge.makeID("block/" + blockName.replace("_stairs", "_block")), pathToBlockStates)) {
            blockName = blockName.replace("_stairs", "_block");
        } else {
            blockName = blockName.replace("_stairs", "");
        }

        stateProvider.stairsBlock(baseStairsBlock, BetterEndForge.makeID("block/" + blockName));
        stateProvider.simpleBlockItem(baseStairsBlock, stateProvider.models().getBuilder("block/" + baseStairsBlock.getRegistryName().getPath()));

    }
}
