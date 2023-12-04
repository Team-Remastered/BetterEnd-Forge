package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.CustomColorProvider;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.client.models.Patterns;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Optional;

public class StoneLanternBlock extends EndLanternBlock implements CustomColorProvider {
	private static final VoxelShape SHAPE_CEIL = Block.box(3, 1, 3, 13, 16, 13);
	private static final VoxelShape SHAPE_FLOOR = Block.box(3, 0, 3, 13, 15, 13);
	
	public StoneLanternBlock(Block source) {
		super(BlockBehaviour.Properties.copy(source).lightLevel(BlocksHelper.getLightValue(15)));
	}
	
	@Override
	public BlockColor getProvider() {
		return ((CustomColorProvider) EndBlocks.AURORA_CRYSTAL.get()).getProvider();
	}
	
	@Override
	public ItemColor getItemProvider() {
		return ((CustomColorProvider) EndBlocks.AURORA_CRYSTAL.get()).getItemProvider();
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return state.getValue(IS_FLOOR) ? SHAPE_FLOOR : SHAPE_CEIL;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		String blockName = resourceLocation.getPath();
		Optional<String> pattern = blockState.getValue(IS_FLOOR) ? Patterns.createJson(
			Patterns.BLOCK_STONE_LANTERN_FLOOR,
			blockName,
			blockName
		) : Patterns.createJson(Patterns.BLOCK_STONE_LANTERN_CEIL, blockName, blockName);
		return ModelsHelper.fromPattern(pattern);
	}

	//TODO: Make the stone lantern ModelBuilder

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		String materialName = block.getRegistryName().getPath().replace("_lantern", "");


		ModelFile ceil = stateProvider.models().withExistingParent(materialName + "_lantern_ceil", stateProvider.modLoc("patterns/block/stone_lantern_ceil"))
				.texture("particle", stateProvider.modLoc("block/" + materialName + "_lantern_side"))
				.texture("texture", stateProvider.modLoc("block/" + materialName + "_lantern_side"))
				.texture("top", stateProvider.modLoc("block/" + materialName + "_lantern_top"))
				.texture("crystal", stateProvider.modLoc("block/aurora_crystal"))
				.texture("bottom", stateProvider.modLoc("block/" + materialName + "_lantern_bottom"));
		ModelFile floor = stateProvider.models().withExistingParent(materialName + "_lantern_floor", stateProvider.modLoc("patterns/block/stone_lantern_floor"))
				.texture("particle", stateProvider.modLoc("block/" + materialName + "_lantern_side"))
				.texture("texture", stateProvider.modLoc("block/" + materialName + "_lantern_side"))
				.texture("top", stateProvider.modLoc("block/" + materialName + "_lantern_top"))
				.texture("crystal", stateProvider.modLoc("block/aurora_crystal"))
				.texture("bottom", stateProvider.modLoc("block/" + materialName + "_lantern_bottom"));
		stateProvider.getVariantBuilder(block)
				.forAllStates(state -> {
					boolean isFloor = state.getValue(IS_FLOOR);
					return ConfiguredModel.builder()
							.modelFile(isFloor ? floor : ceil)
							.build();
				});
		stateProvider.simpleBlockItem(block, floor);
	}

}