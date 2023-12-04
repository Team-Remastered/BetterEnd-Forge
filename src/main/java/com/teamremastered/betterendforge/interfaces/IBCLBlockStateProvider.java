package com.teamremastered.betterendforge.interfaces;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;

public interface IBCLBlockStateProvider {

    void createGeneratedData(BlockStateProvider stateProvider, Block block);
}
