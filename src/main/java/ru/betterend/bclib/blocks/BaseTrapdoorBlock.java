package ru.betterend.bclib.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.client.models.BasePatterns;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.client.render.BCLRenderLayer;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.LootProvider;
import ru.betterend.bclib.interfaces.RenderLayerProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BaseTrapdoorBlock extends TrapDoorBlock implements RenderLayerProvider, BlockModelProvider, LootProvider {
	public BaseTrapdoorBlock(Block source) {
		this(FabricBlockSettings.copyOf(source).strength(3.0F, 3.0F).noOcclusion());
	}
	
	public BaseTrapdoorBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		String name = resourceLocation.getPath();
		Optional<String> pattern = PatternsHelper.createJson(
			BasePatterns.BLOCK_TRAPDOOR,
			new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;
				
				{
					put("%modid%", resourceLocation.getNamespace());
					put("%texture%", name);
					put("%side%", name.replace("trapdoor", "door_side"));
				}
			}
		);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		boolean isTop = blockState.getValue(HALF) == Half.TOP;
		boolean isOpen = blockState.getValue(OPEN);
		int y = 0;
		int x = (isTop && isOpen) ? 270 : isTop ? 180 : isOpen ? 90 : 0;
		switch (blockState.getValue(FACING)) {
			case EAST:
				y = (isTop && isOpen) ? 270 : 90;
				break;
			case NORTH:
				if (isTop && isOpen) y = 180;
				break;
			case SOUTH:
				y = (isTop && isOpen) ? 0 : 180;
				break;
			case WEST:
				y = (isTop && isOpen) ? 90 : 270;
				break;
			default:
				break;
		}
		BlockModelRotation rotation = BlockModelRotation.by(x, y);
		return ModelsHelper.createMultiVariant(modelId, rotation.getRotation(), false);
	}
}
