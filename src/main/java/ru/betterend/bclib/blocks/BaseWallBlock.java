package ru.betterend.bclib.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WallSide;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.client.models.BasePatterns;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.LootProvider;

import java.util.Map;
import java.util.Optional;

public class BaseWallBlock extends WallBlock implements BlockModelProvider, LootProvider {
	private final Block parent;
	
	public BaseWallBlock(Block source) {
		super(FabricBlockSettings.copyOf(source).noOcclusion());
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
}
