package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;

import java.util.Optional;

public class BaseBarkBlock extends BaseRotatedPillarBlock {
	public BaseBarkBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	protected Optional<String> createBlockPattern(ResourceLocation blockId) {
		blockId = Registry.BLOCK.getKey(this);
		return PatternsHelper.createJson(BasePatterns.BLOCK_BASE, replacePath(blockId));
	}
	
	private ResourceLocation replacePath(ResourceLocation blockId) {
		String newPath = blockId.getPath().replace("_bark", "_log_side");
		return new ResourceLocation(blockId.getNamespace(), newPath);
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {

		String blockName = block.getRegistryName().getPath().replace("_bark", "_log_side");
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + blockName);
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.mcLoc("block/cube")));

		stateProvider.simpleBlock(block, BaseBlock.cubeAll(stateProvider, blockName));
		stateProvider.simpleBlockItem(block, BaseBlock.cubeAll(stateProvider, blockName));
	}

}
