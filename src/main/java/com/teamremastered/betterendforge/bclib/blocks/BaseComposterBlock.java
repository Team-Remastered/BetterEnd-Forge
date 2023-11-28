package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper.MultiPartBuilder;

import java.util.Map;
import java.util.Optional;

public class BaseComposterBlock extends ComposterBlock implements BlockModelProvider, LootProvider {
	public BaseComposterBlock(Block source) {
		super(BlockBehaviour.Properties.copy(source));
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_COMPOSTER, blockId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		
		MultiPartBuilder builder = MultiPartBuilder.create(stateDefinition);
		LEVEL.getPossibleValues().forEach(level -> {
			if (level > 0) {
				ResourceLocation contentId;
				if (level > 7) {
					contentId = new ResourceLocation("block/composter_contents_ready");
				}
				else {
					contentId = new ResourceLocation("block/composter_contents" + level);
				}
				builder.part(contentId).setCondition(state -> state.getValue(LEVEL).equals(level)).add();
			}
		});
		builder.part(modelId).add();
		
		return builder.build();
	}
}
