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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

import java.util.Map;
import java.util.Optional;

public class BaseRotatedPillarBlock extends RotatedPillarBlock implements BlockModelProvider, LootProvider, IBCLBlockStateProvider {
	public BaseRotatedPillarBlock(Properties settings) {
		super(settings);
	}
	
	public BaseRotatedPillarBlock(Block block) {
		this(BlockBehaviour.Properties.copy(block));
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		return getBlockModel(blockId, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		Optional<String> pattern = createBlockPattern(blockId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createRotatedModel(modelId, blockState.getValue(AXIS));
	}
	
	protected Optional<String> createBlockPattern(ResourceLocation blockId) {
		return PatternsHelper.createBlockPillar(blockId);
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BaseRotatedPillarBlock baseRotatedPillarBlock = (BaseRotatedPillarBlock) block;


		ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
		if (stateProvider.models().existingFileHelper.exists(BetterEndForge.makeID("block/" + baseRotatedPillarBlock.getRegistryName().getPath()), pathToBlockStates)) {
			stateProvider.logBlock(baseRotatedPillarBlock);
		} else {
			ModaxisBlock(baseRotatedPillarBlock, BetterEndForge.makeID("block/" + baseRotatedPillarBlock.getRegistryName().getPath()), stateProvider);
		}
		stateProvider.simpleBlockItem(baseRotatedPillarBlock, stateProvider.models().getBuilder("block/" + baseRotatedPillarBlock.getRegistryName().getPath()));
	}

	public void ModaxisBlock(RotatedPillarBlock block, ResourceLocation baseName, BlockStateProvider stateProvider) {
		stateProvider.axisBlock(block, extend(baseName, "_side"), extend(baseName, "_top"));
	}

	private ResourceLocation extend(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}
}
