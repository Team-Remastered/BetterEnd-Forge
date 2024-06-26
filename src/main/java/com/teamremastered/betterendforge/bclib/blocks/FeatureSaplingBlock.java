package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.interfaces.IBCLBlockStateProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.bclib.client.models.BasePatterns;
import com.teamremastered.betterendforge.bclib.client.models.ModelsHelper;
import com.teamremastered.betterendforge.bclib.client.models.PatternsHelper;
import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;

import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

public class FeatureSaplingBlock extends SaplingBlock implements RenderLayerProvider, BlockModelProvider, LootProvider, IBCLBlockStateProvider {
	private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 14, 12);
	private final Function<BlockState, Feature<?>> feature;
	
	public FeatureSaplingBlock(Function<BlockState, Feature<?>> featureSupplier) {
		this(BlockBehaviour.Properties.of(Material.PLANT)
		   .noCollission()
		   .instabreak()
		   .sound(SoundType.GRASS)
		   .randomTicks(),
			featureSupplier
		);
	}
	
	public FeatureSaplingBlock(int light, Function<BlockState, Feature<?>> featureSupplier) {
		this(BlockBehaviour.Properties.of(Material.PLANT)
		   .noCollission()
		   .lightLevel(BlocksHelper.getLightValue(light))
		   .instabreak()
		   .sound(SoundType.GRASS)
		   .randomTicks(),
			featureSupplier
		);
	}
	
	public FeatureSaplingBlock(Properties properties, Function<BlockState, Feature<?>> featureSupplier) {
		super(null, properties);
		this.feature = featureSupplier;
	}
	
	protected Feature<?> getFeature(BlockState state) {
		return feature.apply(state);
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		if (!canSurvive(state, world, pos)) return Blocks.AIR.defaultBlockState();
		else return state;
	}
	
	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return random.nextInt(16) == 0;
	}
	
	@Override
	public void advanceTree(ServerLevel world, BlockPos pos, BlockState blockState, Random random) {
		FeaturePlaceContext context = new FeaturePlaceContext(
			Optional.empty(),
			world,
			world.getChunkSource().getGenerator(),
			random,
			pos,
			null
		);
		getFeature(blockState).place(context);
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		this.tick(state, world, pos, random);
	}
	
	@Override
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		super.tick(state, world, pos, random);
		if (isBonemealSuccess(world, random, pos, state)) {
			performBonemeal(world, random, pos, state);
		}
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return ModelsHelper.createBlockItem(resourceLocation);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public @Nullable BlockModel getBlockModel(ResourceLocation resourceLocation, BlockState blockState) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.BLOCK_CROSS, resourceLocation);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}

	@OnlyIn(Dist.CLIENT)
	public BlockModelBuilder getBlockModelBuilder(BlockStateProvider stateProvider, Block block) {
		String blockName = block.getRegistryName().getPath();
		BlockModelBuilder blockModel = stateProvider.models().getBuilder("block/" + blockName);
		blockModel.parent(stateProvider.models().getExistingFile(stateProvider.mcLoc("block/cross")));

		blockModel.texture("cross", stateProvider.modLoc("block/" + blockName));

		return blockModel;
	}

	@Override
	public void createGeneratedData(BlockStateProvider stateProvider, Block block) {
		FeatureSaplingBlock saplingBlock = (FeatureSaplingBlock) block;


		BlockModelBuilder builder = saplingBlock.getBlockModelBuilder(stateProvider, saplingBlock);
		stateProvider.simpleBlock(saplingBlock, builder);
		stateProvider.simpleBlockItem(saplingBlock, builder);
	}
}