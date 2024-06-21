package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WoodenPressurePlateBlock extends BasePressurePlateBlock {
	public WoodenPressurePlateBlock(Block source) {
		super(Sensitivity.EVERYTHING, source);
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BasePressurePlateBlock pressurePlateBlock = (BasePressurePlateBlock) block;

		String blockName = pressurePlateBlock.getRegistryName().getPath() + "_planks";

		ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
		if (stateProvider.models().existingFileHelper.exists(BetterEndForge.makeID("block/" + blockName.replace("_plate", "_block")), pathToBlockStates)) {
			blockName = blockName.replace("_plate", "_block");
		} else {
			blockName = blockName.replace("_plate", "");
		}

		stateProvider.pressurePlateBlock(pressurePlateBlock, BetterEndForge.makeID("block/" + blockName));
		stateProvider.simpleBlockItem(pressurePlateBlock, stateProvider.models().getBuilder("block/" + pressurePlateBlock.getRegistryName().getPath()));
	}
}
