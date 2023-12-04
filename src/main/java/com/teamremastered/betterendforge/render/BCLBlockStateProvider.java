package com.teamremastered.betterendforge.render;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class BCLBlockStateProvider extends BlockStateProvider {

    public BCLBlockStateProvider(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, BetterEndForge.MOD_ID, helper);
    }

    /**
     * Removes every blocks that already have a designed blockstate inside the Resource directory
     * to avoid duplicates and crash the data generation.
     **/

    private List<RegistryObject<Block>> filteredBlockList(List<RegistryObject<Block>> registeredBlockList) {
        List<RegistryObject<Block>> filteredList = new ArrayList<RegistryObject<Block>>();
        ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "blockstates");
        for (RegistryObject<Block> registeredBlock : registeredBlockList) {
            if (!models().existingFileHelper.exists(registeredBlock.getId(), pathToBlockStates)) {
                filteredList.add(registeredBlock);
            }
        }

        return filteredList;
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> registeredBlock : filteredBlockList(EndBlocks.registeredBetterEndBlocks)) {
            if (registeredBlock.get() instanceof IBCLBlockStateProvider baseBlock) {
                baseBlock.createGeneratedData(this, registeredBlock.get());
            }
            else {
                String blockName = registeredBlock.getId().getPath();

                simpleBlock(registeredBlock.get(), BaseBlock.cubeAll(this, blockName));
                simpleBlockItem(registeredBlock.get(), BaseBlock.cubeAll(this, blockName));

            }
        }
    }
}