package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

import java.util.Map;
import java.util.Optional;

public class BaseGateBlock extends FenceGateBlock implements BlockModelProvider, LootProvider {
	private final Block parent;
	
	public BaseGateBlock(Block source) {
		super(BlockBehaviour.Properties.copy(source).noOcclusion());
		this.parent = source;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		boolean inWall = blockState.getValue(IN_WALL);
		boolean isOpen = blockState.getValue(OPEN);
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		Optional<String> pattern;
		if (inWall) {
			pattern = isOpen ? PatternsHelper.createJson(
				BasePatterns.BLOCK_GATE_OPEN_WALL,
				parentId
			) : PatternsHelper.createJson(BasePatterns.BLOCK_GATE_CLOSED_WALL, parentId);
		}
		else {
			pattern = isOpen ? PatternsHelper.createJson(
				BasePatterns.BLOCK_GATE_OPEN,
				parentId
			) : PatternsHelper.createJson(BasePatterns.BLOCK_GATE_CLOSED, parentId);
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		boolean inWall = blockState.getValue(IN_WALL);
		boolean isOpen = blockState.getValue(OPEN);
		String state = "" + (inWall ? "_wall" : "") + (isOpen ? "_open" : "_closed");
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + state);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createFacingModel(modelId, blockState.getValue(FACING), true, false);
	}
}