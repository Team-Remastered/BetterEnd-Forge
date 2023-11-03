package ru.betterend.bclib.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.LootProvider;

import java.util.Map;
import java.util.Optional;

public class BaseRotatedPillarBlock extends RotatedPillarBlock implements BlockModelProvider, LootProvider {
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
}
