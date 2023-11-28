package com.teamremastered.betterendforge.integration.byg;

import com.teamremastered.betterendforge.bclib.blocks.BaseVineBlock;
import com.teamremastered.betterendforge.blocks.basis.EndWallPlantBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BYGBlocks {
	public static final RegistryObject<Block> IVIS_MOSS = EndBlocks.registerBlock("ivis_moss", () -> new EndWallPlantBlock());
	public static final RegistryObject<Block> NIGHTSHADE_MOSS = EndBlocks.registerBlock("nightshade_moss", () -> new EndWallPlantBlock());
	public static final RegistryObject<Block> IVIS_VINE = EndBlocks.registerBlock("ivis_vine", () -> new BaseVineBlock());

}
