package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;

import java.util.Map;
import java.util.Optional;

public class BaseChainBlock extends ChainBlock implements BlockModelProvider, RenderLayerProvider, LootProvider, IBCLBlockStateProvider {
	public BaseChainBlock(MaterialColor color) {
		this(BlockBehaviour.Properties.copy(Blocks.CHAIN).color(color));
	}
	
	public BaseChainBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		return ModelsHelper.createItemModel(blockId);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_CHAIN, blockId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		Direction.Axis axis = blockState.getValue(AXIS);
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createRotatedModel(modelId, axis);
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}

	@OnlyIn(Dist.CLIENT)
	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath();
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + block.getRegistryName().getPath());
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.modLoc("patterns/block/chain")));
		blockModel.texture("particle", stateProvider.modLoc("block/" + blockName))
				  .texture("all", stateProvider.modLoc("block/" + blockName));

		return blockModel;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		ModelFile chain = stateProvider.models().withExistingParent(block.getRegistryName().getPath(), stateProvider.mcLoc("block/chain"))
				.texture("particle", stateProvider.modLoc("block/" + block.getRegistryName().getPath()))
				.texture("all", stateProvider.modLoc("block/" + block.getRegistryName().getPath()));
		stateProvider.axisBlock((RotatedPillarBlock)block, chain, chain);
		stateProvider.simpleBlockItem(block, stateProvider.models().getBuilder("block/" + block.getRegistryName().getPath()));
	}
}