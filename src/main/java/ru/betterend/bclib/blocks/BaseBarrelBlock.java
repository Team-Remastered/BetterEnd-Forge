package ru.betterend.bclib.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.blockentities.BaseBarrelBlockEntity;
import ru.betterend.bclib.client.models.BasePatterns;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.bclib.client.models.PatternsHelper;
import ru.betterend.bclib.interfaces.BlockModelProvider;
import ru.betterend.bclib.interfaces.LootProvider;
import ru.betterend.bclib.registry.BaseBlockEntities;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class BaseBarrelBlock extends BarrelBlock implements BlockModelProvider, LootProvider {
	public BaseBarrelBlock(Block source) {
		this(FabricBlockSettings.copyOf(source).noOcclusion());
	}
	
	public BaseBarrelBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return BaseBlockEntities.BARREL.create(blockPos, blockState);
	}
	
	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (world.isClientSide) {
			return InteractionResult.SUCCESS;
		}
		else {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof BaseBarrelBlockEntity) {
				player.openMenu((BaseBarrelBlockEntity) blockEntity);
				player.awardStat(Stats.OPEN_BARREL);
				PiglinAi.angerNearbyPiglins(player, true);
			}
			
			return InteractionResult.CONSUME;
		}
	}
	
	@Override
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof BaseBarrelBlockEntity) {
			((BaseBarrelBlockEntity) blockEntity).tick();
		}
	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		if (itemStack.hasCustomHoverName()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof BaseBarrelBlockEntity) {
				((BaseBarrelBlockEntity) blockEntity).setCustomName(itemStack.getHoverName());
			}
		}
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		return getBlockModel(blockId, defaultBlockState());
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
		Optional<String> pattern;
		if (blockState.getValue(OPEN)) {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_BARREL_OPEN, blockId);
		}
		else {
			pattern = PatternsHelper.createJson(BasePatterns.BLOCK_BOTTOM_TOP, blockId);
		}
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		String open = blockState.getValue(OPEN) ? "_open" : "";
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + open);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		Direction facing = blockState.getValue(FACING);
		BlockModelRotation rotation = BlockModelRotation.X0_Y0;
		switch (facing) {
			case NORTH:
				rotation = BlockModelRotation.X90_Y0;
				break;
			case EAST:
				rotation = BlockModelRotation.X90_Y90;
				break;
			case SOUTH:
				rotation = BlockModelRotation.X90_Y180;
				break;
			case WEST:
				rotation = BlockModelRotation.X90_Y270;
				break;
			case DOWN:
				rotation = BlockModelRotation.X180_Y0;
				break;
			default:
				break;
		}
		return ModelsHelper.createMultiVariant(modelId, rotation.getRotation(), false);
	}
}
