package ru.betterend.integration.byg;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.bclib.blocks.BaseVineBlock;
import ru.betterend.blocks.basis.EndWallPlantBlock;
import ru.betterend.registry.EndBlocks;

public class BYGBlocks {
	public static final RegistryObject<Block> IVIS_MOSS = EndBlocks.registerBlock("ivis_moss", () -> new EndWallPlantBlock());
	public static final RegistryObject<Block> NIGHTSHADE_MOSS = EndBlocks.registerBlock("nightshade_moss", () -> new EndWallPlantBlock());
	public static final RegistryObject<Block> IVIS_VINE = EndBlocks.registerBlock("ivis_vine", () -> new BaseVineBlock());

}
