package com.teamremastered.betterendforge.blocks;

import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import com.teamremastered.betterendforge.blocks.basis.PedestalBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Map;

public class EndPedestal extends PedestalBlock {
	
	public EndPedestal(Block parent) {
		super(parent);
	}
	
	@Override
	protected Map<String, String> createTexturesMap() {
		ResourceLocation blockId = Registry.BLOCK.getKey(parent);
		String name = blockId.getPath();
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%mod%", BetterEndForge.MOD_ID);
		textures.put("%top%", name + "_polished");
		textures.put("%base%", name + "_polished");
		textures.put("%pillar%", name + "_pillar_side");
		textures.put("%bottom%", name + "_polished");
		return textures;
	}

	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath().replace("_pedestal", ""); //get the parent block
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + block.getRegistryName().getPath());
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.modLoc("block/pedestal_default")));

		blockModel.texture("top", stateProvider.modLoc("block/" + blockName + "_polished"))
				.texture("base", stateProvider.modLoc("block/" + blockName + "_polished"))
				.texture("pillar", stateProvider.modLoc("block/" + blockName + "_pillar_side"))
				.texture("bottom", stateProvider.modLoc("block/" + blockName + "_polished"));

		return blockModel;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block endPedestal) {
		BlockModelBuilder builder = getBlockModelBuilder(stateProvider, endPedestal);
		stateProvider.simpleBlock(endPedestal, builder);
		stateProvider.simpleBlockItem(endPedestal, builder);
	}
}