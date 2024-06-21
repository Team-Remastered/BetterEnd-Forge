package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BaseWoodenButtonBlock extends BaseButtonBlock {
	public BaseWoodenButtonBlock(Block source) {
		super(source, BlockBehaviour.Properties.copy(source).strength(0.5F, 0.5F).noOcclusion(), true);
	}
	
	@Override
	protected SoundEvent getSound(boolean clicked) {
		return clicked ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BaseButtonBlock buttonBlock = (BaseButtonBlock) block;

		String blockName = block.getRegistryName().getPath();
		String blockMaterial = buttonBlock.getRegistryName().getPath() + "_planks";

		ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
		if (stateProvider.models().existingFileHelper.exists(BetterEndForge.makeID("block/" + blockMaterial.replace("_button", "_block")), pathToBlockStates)) {
			blockMaterial = blockMaterial.replace("_button", "_block");
		} else {
			blockMaterial = blockMaterial.replace("_button", "");
		}

		stateProvider.buttonBlock(buttonBlock, BetterEndForge.makeID("block/" + blockMaterial));
		stateProvider.itemModels().singleTexture(blockName, stateProvider.mcLoc("block/button_inventory"), BetterEndForge.makeID("block/" + blockMaterial));
	}
}