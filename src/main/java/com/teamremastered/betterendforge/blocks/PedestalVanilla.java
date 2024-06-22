package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import com.teamremastered.betterendforge.blocks.basis.PedestalBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;

import java.util.HashMap;
import java.util.Map;

public class PedestalVanilla extends PedestalBlock {
	
	public PedestalVanilla(Block parent) {
		super(parent);
	}
	
	@Override
	protected Map<String, String> createTexturesMap() {
		ResourceLocation blockId = Registry.BLOCK.getKey(parent);
		String name = blockId.getPath().replace("_block", "");
		return new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			
			{
				put("%mod%", blockId.getNamespace());
				put("%top%", "polished_" + name);
				put("%base%", "polished_" + name);
				put("%pillar%", name + "_pillar");
				put("%bottom%", "polished_" + name);
			}
		};
	}

	@OnlyIn(Dist.CLIENT)
	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath().replace("_pedestal", ""); //get the parent block
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + block.getRegistryName().getPath());
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.modLoc("block/pedestal_default")));

		blockModel.texture("top", stateProvider.mcLoc("block/polished_" + blockName))
				.texture("base", stateProvider.mcLoc("block/polished_" + blockName))
				.texture("pillar", stateProvider.mcLoc("block/" + blockName + "_pillar"))
				.texture("bottom", stateProvider.mcLoc("block/polished_" + blockName));

		return blockModel;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block pedestalVanilla) {
		BlockModelBuilder builder = getBlockModelBuilder(stateProvider, pedestalVanilla);
		stateProvider.simpleBlock(pedestalVanilla, builder);
		stateProvider.simpleBlockItem(pedestalVanilla, builder);
	}

}
