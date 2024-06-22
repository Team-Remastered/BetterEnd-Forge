package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;

import java.util.Map;
import java.util.Optional;

public class BaseLadderBlock extends LadderBlock implements RenderLayerProvider, BlockModelProvider, LootProvider, IBCLBlockStateProvider {
	public BaseLadderBlock(Block block) {
		this(BlockBehaviour.Properties.copy(block).noOcclusion());
	}
	
	public BaseLadderBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		return ModelsHelper.createBlockItem(blockId);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_LADDER, blockId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createFacingModel(modelId, blockState.getValue(FACING), false, true);
	}

	@OnlyIn(Dist.CLIENT)
	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath();
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + blockName);
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.modLoc("block/ladder")));
		blockModel.texture("texture", stateProvider.modLoc("block/" + blockName));
		return blockModel;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BlockModelBuilder builder = getBlockModelBuilder(stateProvider, block);
		stateProvider.simpleBlock(block, builder);
		stateProvider.simpleBlockItem(block, stateProvider.models().getBuilder("block/" + block.getRegistryName().getPath()));
	}
}