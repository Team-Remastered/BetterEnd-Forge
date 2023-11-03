package ru.betterend.bclib.blocks;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.client.models.BasePatterns;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.CustomItemProvider;
import ru.betterend.bclib.interfaces.LootProvider;
import ru.betterend.bclib.items.BaseAnvilItem;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public abstract class BaseAnvilBlock extends AnvilBlock implements BlockModelProvider, CustomItemProvider, LootProvider {
	public static final IntegerProperty DESTRUCTION = BlockProperties.DESTRUCTION;
	public IntegerProperty durability;
	
	public BaseAnvilBlock(MaterialColor color) {
		this(BlockBehaviour.Properties.copy(Blocks.ANVIL).color(color));
	}
	
	public BaseAnvilBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		if (getMaxDurability() != 3) {
			durability = IntegerProperty.create("durability", 0, getMaxDurability());
		}
		else {
			durability = BlockProperties.DEFAULT_ANVIL_DURABILITY;
		}
		builder.add(DESTRUCTION, durability);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		return getBlockModel(blockId, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		int destruction = blockState.getValue(DESTRUCTION);
		String name = blockId.getPath();
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%modid%", blockId.getNamespace());
		textures.put("%anvil%", name);
		textures.put("%top%", name + "_top_" + destruction);
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_ANVIL, textures);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		int destruction = blockState.getValue(DESTRUCTION);
		String modId = stateId.getNamespace();
		String modelId = "block/" + stateId.getPath() + "_top_" + destruction;
		ResourceLocation modelLocation = new ResourceLocation(modId, modelId);
		registerBlockModel(stateId, modelLocation, blockState, modelCache);
		return ModelsHelper.createFacingModel(modelLocation, blockState.getValue(FACING), false, false);
	}
	
	@Override
	public BlockItem getCustomItem(ResourceLocation blockID, FabricItemSettings settings) {
		return new BaseAnvilItem(this, settings);
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		int destruction = state.getValue(DESTRUCTION);
		int durability = state.getValue(getDurabilityProp());
		int value = destruction * getMaxDurability() + durability;
		ItemStack tool = builder.getParameter(LootContextParams.TOOL);
		if (tool != null && tool.getItem() instanceof PickaxeItem) {
			ItemStack itemStack = new ItemStack(this);
			itemStack.getOrCreateTag().putInt(BaseAnvilItem.DESTRUCTION, value);
			return Lists.newArrayList(itemStack);
		}
		return Collections.emptyList();
	}
	
	public IntegerProperty getDurabilityProp() {
		return durability;
	}
	
	public int getMaxDurability() {
		return 3;
	}
	
	public BlockState damageAnvilUse(BlockState state, Random random) {
		IntegerProperty durability = getDurabilityProp();
		int value = state.getValue(durability);
		if (value < getMaxDurability() && random.nextInt(8) == 0) {
			return state.setValue(durability, value + 1);
		}
		value = state.getValue(DESTRUCTION);
		return value < 2 ? state.setValue(DESTRUCTION, value + 1).setValue(durability, 0) : null;
	}
	
	public BlockState damageAnvilFall(BlockState state) {
		int destruction = state.getValue(DESTRUCTION);
		return destruction < 2 ? state.setValue(DESTRUCTION, destruction + 1) : null;
	}
}
