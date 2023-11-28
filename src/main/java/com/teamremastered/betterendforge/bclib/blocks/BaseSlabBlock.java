package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.CustomItemProvider;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BaseSlabBlock extends SlabBlock implements BlockModelProvider, CustomItemProvider, LootProvider {
	private final Block parent;
	public final boolean fireproof;

	public BaseSlabBlock(Block source) {
		this(source, false);
	}

	public BaseSlabBlock(Block source, boolean fireproof) {
		super(BlockBehaviour.Properties.copy(source));
		this.parent = source;
		this.fireproof = fireproof;
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		int count = state.getValue(TYPE) == SlabType.DOUBLE ? 2 : 1;
		return Collections.singletonList(new ItemStack(this, count));
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
		Optional<String> pattern;
		if (blockState.getValue(TYPE) == SlabType.DOUBLE) {
			pattern = PatternsHelper.createBlockSimple(parentId);
		}
		else {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_SLAB, parentId);
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		SlabType type = blockState.getValue(TYPE);
		ResourceLocation modelId = new ResourceLocation(
			stateId.getNamespace(),
			"block/" + stateId.getPath() + "_" + type
		);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		if (type == SlabType.TOP) {
			return ModelsHelper.createMultiVariant(modelId, BlockModelRotation.X180_Y0.getRotation(), true);
		}
		return ModelsHelper.createBlockSimple(modelId);
	}

	@Override
	public BlockItem getCustomItem(ResourceLocation blockID, Item.Properties settings) {
		if (fireproof) settings = settings.fireResistant();
		return new BlockItem(this, settings);
	}
}
