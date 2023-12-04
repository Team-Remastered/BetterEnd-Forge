package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.CustomItemProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;

import java.util.Map;
import java.util.Optional;

public class BaseStairsBlock extends StairBlock implements BlockModelProvider, CustomItemProvider, LootProvider, IBCLBlockStateProvider {
	private final Block parent;
	public final boolean fireproof;

	public BaseStairsBlock(Block source) {
		this(source, false);
	}
	
	public BaseStairsBlock(Block source, boolean fireproof) {
		super(source.defaultBlockState(), BlockBehaviour.Properties.copy(source));
		this.parent = source;
		this.fireproof = fireproof;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		Optional<String> pattern = PatternsHelper.createJson(switch (blockState.getValue(SHAPE)) {
			case STRAIGHT -> BasePatterns.BLOCK_STAIR;
			case INNER_LEFT, INNER_RIGHT -> BasePatterns.BLOCK_STAIR_INNER;
			case OUTER_LEFT, OUTER_RIGHT -> BasePatterns.BLOCK_STAIR_OUTER;
		}, parentId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		String state;
		StairsShape shape = blockState.getValue(SHAPE);
		state = switch (shape) {
			case INNER_LEFT, INNER_RIGHT -> "_inner";
			case OUTER_LEFT, OUTER_RIGHT -> "_outer";
			default -> "";
		};
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + state);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		
		boolean isTop = blockState.getValue(HALF) == Half.TOP;
		boolean isLeft = shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT;
		boolean isRight = shape == StairsShape.INNER_RIGHT || shape == StairsShape.OUTER_RIGHT;
		int y = 0;
		int x = isTop ? 180 : 0;
		switch (blockState.getValue(FACING)) {
			case NORTH:
				if (isTop && !isRight) y = 270;
				else if (!isTop) y = isLeft ? 180 : 270;
				break;
			case EAST:
				if (isTop && isRight) y = 90;
				else if (!isTop && isLeft) y = 270;
				break;
			case SOUTH:
				if (isTop) y = isRight ? 180 : 90;
				else if (!isLeft) y = 90;
				break;
			case WEST:
			default:
				y = (isTop && isRight) ? 270 : (!isTop && isLeft) ? 90 : 180;
				break;
		}
		BlockModelRotation rotation = BlockModelRotation.by(x, y);
		return ModelsHelper.createMultiVariant(modelId, rotation.getRotation(), true);
	}

	@Override
	public BlockItem getCustomItem(ResourceLocation blockID, Item.Properties settings) {
		if (fireproof) settings = settings.fireResistant();
		return new BlockItem(this, settings);
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		BaseStairsBlock baseStairsBlock = (BaseStairsBlock) block;

		String blockName = baseStairsBlock.getRegistryName().getPath();

		ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
		if (stateProvider.models().existingFileHelper.exists(BetterEndForge.makeID("block/" + blockName.replace("_stairs", "_block")), pathToBlockStates)) {
			blockName = blockName.replace("_stairs", "_block");
		} else {
			blockName = blockName.replace("_stairs", "");
		}

		stateProvider.stairsBlock(baseStairsBlock, BetterEndForge.makeID("block/" + blockName));
		stateProvider.simpleBlockItem(baseStairsBlock, stateProvider.models().getBuilder("block/" + baseStairsBlock.getRegistryName().getPath()));
	}
}
