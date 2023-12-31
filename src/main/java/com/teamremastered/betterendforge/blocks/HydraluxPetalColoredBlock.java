package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.CustomColorProvider;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.client.models.Patterns;

import java.util.Optional;

public class HydraluxPetalColoredBlock extends HydraluxPetalBlock implements CustomColorProvider {
	public HydraluxPetalColoredBlock(BlockBehaviour.Properties settings) {
		super(settings);
	}
	
	@Override
	public BlockColor getProvider() {
		return (state, world, pos, tintIndex) -> BlocksHelper.getBlockColor(this);
	}
	
	@Override
	public ItemColor getItemProvider() {
		return (stack, tintIndex) -> BlocksHelper.getBlockColor(this);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		String path = "betterend:block/block_petal_colored";
		Optional<String> pattern = Patterns.createJson(Patterns.BLOCK_PETAL_COLORED, path, path);
		return ModelsHelper.fromPattern(pattern);
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		ResourceLocation texture = stateProvider.modLoc("block/" + "hydralux_petal_block_colored");

		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + block.getRegistryName().getPath());
		blockModel.parent(stateProvider.models().getExistingFile(Patterns.BLOCK_PETAL_COLORED))
				.texture("texture", texture);

		stateProvider.simpleBlock(block, blockModel);
		stateProvider.simpleBlockItem(block, blockModel);

	}
}