package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.bclib.registry.BaseBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;

import java.util.Optional;

public class BaseChestBlock extends ChestBlock implements BlockModelProvider, LootProvider {
	private final Block parent;
	
	public BaseChestBlock(Block source) {
		super(BlockBehaviour.Properties.copy(source).noOcclusion(), () -> BaseBlockEntities.CHEST);
		this.parent = source;
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return BaseBlockEntities.CHEST.create(blockPos, blockState);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation blockId) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.ITEM_CHEST, blockId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		ResourceLocation parentId = Registry.BLOCK.getKey(parent);
		return ModelsHelper.createBlockEmpty(parentId);
	}
}
