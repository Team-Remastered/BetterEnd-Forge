package com.teamremastered.betterendforge.blocks;

import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineablePickaxe;
import com.teamremastered.betterendforge.blocks.basis.EndLanternBlock;
import com.teamremastered.betterendforge.client.models.Patterns;

import java.util.Map;
import java.util.Optional;

public class BulbVineLanternBlock extends EndLanternBlock implements RenderLayerProvider, BlockModelProvider, AddMineablePickaxe {
	private static final VoxelShape SHAPE_CEIL = Block.box(4, 4, 4, 12, 16, 12);
	private static final VoxelShape SHAPE_FLOOR = Block.box(4, 0, 4, 12, 12, 12);
	
	public BulbVineLanternBlock() {
		this(BlockBehaviour.Properties.of(Material.METAL)
								.destroyTime(1)
								.explosionResistance(1)
								.color(MaterialColor.COLOR_LIGHT_GRAY)
								.lightLevel(BlocksHelper.getLightValue(15))
								.requiresCorrectToolForDrops()
								.sound(SoundType.LANTERN));
	}
	
	public BulbVineLanternBlock(Properties settings) {
		super(settings);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return state.getValue(IS_FLOOR) ? SHAPE_FLOOR : SHAPE_CEIL;
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		Map<String, String> textures = Maps.newHashMap();
		textures.put("%glow%", getGlowTexture());
		textures.put("%metal%", getMetalTexture(resourceLocation));
		Optional<String> pattern = blockState.getValue(IS_FLOOR) ? Patterns.createJson(
			Patterns.BLOCK_BULB_LANTERN_FLOOR,
			textures
		) : Patterns.createJson(Patterns.BLOCK_BULB_LANTERN_CEIL, textures);
		return ModelsHelper.fromPattern(pattern);
	}

	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath();
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + blockName);
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.modLoc("patterns/block/bulb_lantern_ceil")));

		blockModel.texture("glow",  stateProvider.modLoc("block/" + getGlowTexture()))
				.texture("material", "block/" + getMetalTexture(block.getRegistryName()));

		return blockModel;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block lanternBlock) {
		BlockModelBuilder builder = getBlockModelBuilder(stateProvider, lanternBlock);
		stateProvider.simpleBlock(lanternBlock, builder);
		stateProvider.simpleBlockItem(lanternBlock, builder);
	}

	protected String getMetalTexture(ResourceLocation blockId) {
		String name = blockId.getPath();
		name = name.substring(0, name.indexOf('_'));
		return name + "_bulb_vine_lantern_metal";
	}
	
	protected String getGlowTexture() {
		return "bulb_vine_lantern_bulb";
	}


	
}
