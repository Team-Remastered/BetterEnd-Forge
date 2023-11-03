package ru.betterend.bclib.blocks;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.api.tag.NamedMineableTags;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.client.models.BasePatterns;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.client.sound.BlockSounds;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@SuppressWarnings("deprecation")
public class BaseTerrainBlock extends BaseBlock {
	private final Block baseBlock;
	private Block pathBlock;
	
	public BaseTerrainBlock(Block baseBlock, MaterialColor color) {
		super(FabricBlockSettings
			.copyOf(baseBlock)
			.materialColor(color)
			.sound(BlockSounds.TERRAIN_SOUND)
			.randomTicks()
		);
		this.baseBlock = baseBlock;
	}
	
	public void setPathBlock(Block roadBlock) {
		this.pathBlock = roadBlock;
	}
	
	public Block getBaseBlock() {
		return baseBlock;
	}
	
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		//TODO: 1.18.2 check
		if (pathBlock != null && TagAPI.isToolWithMineableTag(player.getMainHandItem(), NamedMineableTags.SHOVEL)){
		//if (pathBlock != null && FabricTagProvider.SHOVELS.contains(player.getMainHandItem().getItem())) {
			world.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
			if (!world.isClientSide) {
				world.setBlockAndUpdate(pos, pathBlock.defaultBlockState());
				if (!player.isCreative()) {
					player.getMainHandItem().hurt(1, world.random, (ServerPlayer) player);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		ItemStack tool = builder.getParameter(LootContextParams.TOOL);
		if (tool != null && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0) {
			return Collections.singletonList(new ItemStack(this));
		}
		return Collections.singletonList(new ItemStack(getBaseBlock()));
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		if (random.nextInt(16) == 0 && !canStay(state, world, pos)) {
			world.setBlockAndUpdate(pos, getBaseBlock().defaultBlockState());
		}
	}
	
	public boolean canStay(BlockState state, LevelReader worldView, BlockPos pos) {
		BlockPos blockPos = pos.above();
		BlockState blockState = worldView.getBlockState(blockPos);
		if (blockState.is(Blocks.SNOW) && blockState.getValue(SnowLayerBlock.LAYERS) == 1) {
			return true;
		}
		else if (blockState.getFluidState().getAmount() == 8) {
			return false;
		}
		else {
			int i = LayerLightEngine.getLightBlockInto(
				worldView,
				state,
				pos,
				blockState,
				blockPos,
				Direction.UP,
				blockState.getLightBlock(worldView, blockPos)
			);
			return i < 5;
		}
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		return getBlockModel(blockId, defaultBlockState());
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		ResourceLocation baseId = Registry.BLOCK.getKey(getBaseBlock());
		String modId = blockId.getNamespace();
		String path = blockId.getPath();
		String bottom = baseId.getNamespace() + ":block/" + baseId.getPath();
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%top%", modId + ":block/" + path + "_top");
		textures.put("%side%", modId + ":block/" + path + "_side");
		textures.put("%bottom%", bottom);
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_TOP_SIDE_BOTTOM, textures);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createRandomTopModel(modelId);
	}
}
