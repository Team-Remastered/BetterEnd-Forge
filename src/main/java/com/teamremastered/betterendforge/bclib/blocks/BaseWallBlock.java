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
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

import java.util.Map;
import java.util.Optional;

public class BaseWallBlock extends WallBlock implements BlockModelProvider, LootProvider, IBCLBlockStateProvider {
	private final Block parent;
	
	public BaseWallBlock(Block source) {
		super(BlockBehaviour.Properties.copy(source).noOcclusion());
		this.parent = source;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.ITEM_WALL, parentId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		String path = blockId.getPath();
		Optional<String> pattern = Optional.empty();
		if (path.endsWith("_post")) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_WALL_POST, parentId);
		}
		if (path.endsWith("_side")) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_WALL_SIDE, parentId);
		}
		if (path.endsWith("_side_tall")) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_WALL_SIDE_TALL, parentId);
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation postId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + "_post");
		ResourceLocation sideId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + "_side");
		ResourceLocation sideTallId = new ResourceLocation(
			stateId.getNamespace(),
			"block/" + stateId.getPath() + "_side_tall"
		);
		registerBlockModel(postId, postId, blockState, modelCache);
		registerBlockModel(sideId, sideId, blockState, modelCache);
		registerBlockModel(sideTallId, sideTallId, blockState, modelCache);
		
		ModelsHelper.MultiPartBuilder builder = ModelsHelper.MultiPartBuilder.create(stateDefinition);
		builder.part(sideId).setCondition(state -> state.getValue(NORTH_WALL) == WallSide.LOW).setUVLock(true).add();
		builder.part(sideId)
			   .setCondition(state -> state.getValue(EAST_WALL) == WallSide.LOW)
			   .setTransformation(BlockModelRotation.X0_Y90.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(sideId)
			   .setCondition(state -> state.getValue(SOUTH_WALL) == WallSide.LOW)
			   .setTransformation(BlockModelRotation.X0_Y180.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(sideId)
			   .setCondition(state -> state.getValue(WEST_WALL) == WallSide.LOW)
			   .setTransformation(BlockModelRotation.X0_Y270.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(sideTallId)
			   .setCondition(state -> state.getValue(NORTH_WALL) == WallSide.TALL)
			   .setUVLock(true)
			   .add();
		builder.part(sideTallId)
			   .setCondition(state -> state.getValue(EAST_WALL) == WallSide.TALL)
			   .setTransformation(BlockModelRotation.X0_Y90.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(sideTallId)
			   .setCondition(state -> state.getValue(SOUTH_WALL) == WallSide.TALL)
			   .setTransformation(BlockModelRotation.X0_Y180.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(sideTallId)
			   .setCondition(state -> state.getValue(WEST_WALL) == WallSide.TALL)
			   .setTransformation(BlockModelRotation.X0_Y270.getRotation())
			   .setUVLock(true)
			   .add();
		builder.part(postId).setCondition(state -> state.getValue(UP)).add();
		
		return builder.build();
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BaseWallBlock wallBlock = (BaseWallBlock) block;
		String blockName = wallBlock.getRegistryName().getPath();

		ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
		if (stateProvider.models().existingFileHelper.exists(BetterEndForge.makeID("block/" + blockName.replace("_wall", "_block")), pathToBlockStates)) {
			blockName = blockName.replace("_wall", "_block");
		} else {
			blockName = blockName.replace("_wall", "");
		}

		stateProvider.wallBlock(wallBlock, BetterEndForge.makeID("block/" + blockName));
		stateProvider.itemModels().wallInventory(wallBlock.getRegistryName().getPath(), BetterEndForge.makeID("block/" + blockName));
	}
}