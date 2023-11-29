package com.teamremastered.betterendforge.render;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateFactory extends BlockStateProvider {

    public BlockStateFactory(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, BetterEndForge.MOD_ID, helper);
    }

        private ModelFile existingModel(final Block block) {
            return models().getExistingFile(block.getRegistryName());
        }

    @Override
    protected void registerStatesAndModels() {
//        for (RegistryObject<Block> moddedBlock : EndBlocks.registeredBetterEndBlocks) {
//        }
        simpleBlock(EndBlocks.END_MYCELIUM.get(), existingModel(Blocks.GRASS_BLOCK));
    }
}