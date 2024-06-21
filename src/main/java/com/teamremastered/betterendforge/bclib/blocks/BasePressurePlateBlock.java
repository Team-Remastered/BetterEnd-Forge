package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

import java.util.Map;
import java.util.Optional;

public class BasePressurePlateBlock extends PressurePlateBlock implements BlockModelProvider, LootProvider, IBCLBlockStateProvider {
	private final Block parent;
	
	public BasePressurePlateBlock(Sensitivity rule, Block source) {
		super(rule, BlockBehaviour.Properties.copy(source).noCollission().noOcclusion().strength(0.5F));
		this.parent = source;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		Optional<String> pattern;
		if (blockState.getValue(POWERED)) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_PLATE_DOWN, parentId);
		}
		else {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_PLATE_UP, parentId);
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		String state = blockState.getValue(POWERED) ? "_down" : "_up";
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + state);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createBlockSimple(modelId);
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BasePressurePlateBlock pressurePlateBlock = (BasePressurePlateBlock) block;

		String blockName = pressurePlateBlock.getRegistryName().getPath();

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
