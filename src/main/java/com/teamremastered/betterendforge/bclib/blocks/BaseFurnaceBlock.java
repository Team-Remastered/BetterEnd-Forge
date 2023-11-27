package com.teamremastered.betterendforge.bclib.blocks;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.blockentities.BaseFurnaceBlockEntity;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;
import com.teamremastered.betterendforge.bclib.registry.BaseBlockEntities;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BaseFurnaceBlock extends FurnaceBlock implements BlockModelProvider, RenderLayerProvider, LootProvider {
	public BaseFurnaceBlock(Block source) {
		this(BlockBehaviour.Properties.copy(source).lightLevel(state -> state.getValue(LIT) ? 13 : 0));
	}
	
	public BaseFurnaceBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new BaseFurnaceBlockEntity(blockPos, blockState);
	}
	
	@Override
	protected void openContainer(Level world, BlockPos pos, Player player) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof BaseFurnaceBlockEntity) {
			player.openMenu((MenuProvider) blockEntity);
			player.awardStat(Stats.INTERACT_WITH_FURNACE);
		}
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		String blockName = blockId.getPath();
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%modid%", blockId.getNamespace());
		textures.put("%top%", blockName + "_top");
		textures.put("%side%", blockName + "_side");
		Optional<String> pattern;
		if (blockState.getValue(LIT)) {
			textures.put("%front%", blockName + "_front_on");
			textures.put("%glow%", blockName + "_glow");
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_FURNACE_LIT, textures);
		}
		else {
			textures.put("%front%", blockName + "_front");
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_FURNACE, textures);
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		String lit = blockState.getValue(LIT) ? "_lit" : "";
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + lit);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createFacingModel(modelId, blockState.getValue(FACING), false, true);
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		List<ItemStack> drop = Lists.newArrayList(new ItemStack(this));
		BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
		if (blockEntity instanceof BaseFurnaceBlockEntity) {
			BaseFurnaceBlockEntity entity = (BaseFurnaceBlockEntity) blockEntity;
			for (int i = 0; i < entity.getContainerSize(); i++) {
				drop.add(entity.getItem(i));
			}
		}
		return drop;
	}
	
	@Override
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
		return createFurnaceTicker(level, blockEntityType, BaseBlockEntities.FURNACE);
	}
	
	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level level, BlockEntityType<T> blockEntityType, BlockEntityType<? extends AbstractFurnaceBlockEntity> blockEntityType2) {
		return level.isClientSide ? null : createTickerHelper(
			blockEntityType,
			blockEntityType2,
			AbstractFurnaceBlockEntity::serverTick
		);
	}
}
