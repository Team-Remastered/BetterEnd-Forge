package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;

import java.util.Map;
import java.util.Optional;

public class BaseMetalBarsBlock extends IronBarsBlock implements BlockModelProvider, RenderLayerProvider, LootProvider, IBCLBlockStateProvider {
	public BaseMetalBarsBlock(Block source) {
		this(BlockBehaviour.Properties.copy(source).strength(5.0F, 6.0F).noOcclusion());
	}
	
	public BaseMetalBarsBlock(Properties properties) {
		super(properties);
	}
	
	public Optional<String> getModelString(String block) {
		ResourceLocation blockId = Registry.BLOCK.getKey(this);
		if (block.contains("item")) {
			return PatternsHelper.createJson(BasePatterns.ITEM_BLOCK, blockId);
		}
		if (block.contains("post")) {
			return PatternsHelper.createJson(BasePatterns.BLOCK_BARS_POST, blockId);
		}
		else {
			return PatternsHelper.createJson(BasePatterns.BLOCK_BARS_SIDE, blockId);
		}
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return ModelsHelper.createBlockItem(resourceLocation);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		ResourceLocation thisId = Registry.BLOCK.getKey(this);
		String path = blockId.getPath();
		Optional<String> pattern = Optional.empty();
		if (path.endsWith("_post")) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_BARS_POST, thisId);
		}
		if (path.endsWith("_side")) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_BARS_SIDE, thisId);
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
		
		ModelsHelper.MultiPartBuilder builder = ModelsHelper.MultiPartBuilder.create(stateDefinition);
		builder.part(postId)
			   .setCondition(state -> !state.getValue(NORTH) && !state.getValue(EAST) && !state.getValue(SOUTH) && !state
				   .getValue(WEST))
			   .add();
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
		
		return builder.build();
	}
	
	@OnlyIn(Dist.CLIENT)
	public boolean skipRendering(BlockState state, BlockState stateFrom, Direction direction) {
		if (direction.getAxis().isVertical() && stateFrom.getBlock() == this && !stateFrom.equals(state)) {
			return false;
		}
		return super.skipRendering(state, stateFrom, direction);
	}

	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BlockModelBuilder post = stateProvider.models().withExistingParent(block.getRegistryName().
						getPath() + "_post", stateProvider.modLoc("patterns/block/bars_post")).
				texture("top", stateProvider.modLoc("block/" + block.getRegistryName().getPath() + "_top"));
		BlockModelBuilder side = stateProvider.models().withExistingParent(block.getRegistryName().
						getPath() + "_side", stateProvider.modLoc("patterns/block/bars_side")).
				texture("top", stateProvider.modLoc("block/" + block.getRegistryName().getPath() + "_top")).
				texture("side", stateProvider.modLoc("block/" + block.getRegistryName().getPath()));

		MultiPartBlockStateBuilder builder = stateProvider.getMultipartBuilder(block)
				.part().modelFile(post).addModel().
				condition(NORTH, false).
				condition(SOUTH, false).
				condition(EAST, false).
				condition(WEST, false).end();

		stateProvider.fourWayMultipart(builder, side);
		stateProvider.simpleBlockItem(block, post);
	}
}