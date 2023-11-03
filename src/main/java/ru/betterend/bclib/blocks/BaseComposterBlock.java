package ru.betterend.bclib.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.client.models.BasePatterns;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.ModelsHelper.MultiPartBuilder;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.LootProvider;

import java.util.Map;
import java.util.Optional;

public class BaseComposterBlock extends ComposterBlock implements BlockModelProvider, LootProvider {
	public BaseComposterBlock(Block source) {
		super(FabricBlockSettings.copyOf(source));
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_COMPOSTER, blockId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@Environment(EnvType.CLIENT)
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
