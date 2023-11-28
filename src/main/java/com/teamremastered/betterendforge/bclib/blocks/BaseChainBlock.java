package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
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
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;

import java.util.Map;
import java.util.Optional;

public class BaseChainBlock extends ChainBlock implements BlockModelProvider, RenderLayerProvider, LootProvider {
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
}
