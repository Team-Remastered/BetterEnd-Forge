package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper.MultiPartBuilder;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;

import java.util.Map;
import java.util.Optional;

public class BaseFenceBlock extends FenceBlock implements BlockModelProvider, LootProvider, IBCLBlockStateProvider {
	private final Block parent;
	
	public BaseFenceBlock(Block source) {
		super(BlockBehaviour.Properties.copy(source).noOcclusion());
		this.parent = source;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.ITEM_FENCE, parentId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		String path = blockId.getPath();
		Optional<String> pattern = Optional.empty();
		if (path.endsWith("_post")) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_FENCE_POST, parentId);
		}
		if (path.endsWith("_side")) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_FENCE_SIDE, parentId);
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation postId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + "_post");
		ResourceLocation sideId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + "_side");
		registerBlockModel(postId, postId, blockState, modelCache);
		registerBlockModel(sideId, sideId, blockState, modelCache);
		
		MultiPartBuilder builder = MultiPartBuilder.create(stateDefinition);
		builder.part(sideId).setCondition(state -> state.getValue(NORTH)).setUVLock(true).add();
		builder.part(sideId)
			   .setCondition(state -> state.getValue(EAST))
			   .setTransformation(BlockModelRotation.X0_Y90.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(sideId)
			   .setCondition(state -> state.getValue(SOUTH))
			   .setTransformation(BlockModelRotation.X0_Y180.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(sideId)
			   .setCondition(state -> state.getValue(WEST))
			   .setTransformation(BlockModelRotation.X0_Y270.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(postId).add();
		
		return builder.build();
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		FenceBlock fence = (FenceBlock) block;
		String blockName = fence.getRegistryName().getPath();
		String blockParent = blockName.replace("fence", "planks");
		stateProvider.fenceBlock(fence, BetterEndForge.makeID("block/" + blockParent));
		stateProvider.itemModels().fenceInventory(blockName, BetterEndForge.makeID("block/" + blockParent));
	}
}