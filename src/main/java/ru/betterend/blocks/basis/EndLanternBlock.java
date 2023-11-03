package ru.betterend.blocks.basis;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import ru.betterend.bclib.blocks.BaseBlockNotFull;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.bclib.blocks.BlockProperties;
import ru.betterend.bclib.client.models.ModelsHelper;

import java.util.Map;

@SuppressWarnings("deprecation")
public class EndLanternBlock extends BaseBlockNotFull implements SimpleWaterloggedBlock, LiquidBlockContainer {
	public static final BooleanProperty IS_FLOOR = BlockProperties.IS_FLOOR;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public EndLanternBlock(Block source) {
		this(BlockBehaviour.Properties.copy(source).lightLevel(BlocksHelper.getLightValue(15)).noOcclusion());
	}
	
	public EndLanternBlock(Properties settings) {
		super(settings.noOcclusion());
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(IS_FLOOR, WATERLOGGED);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		LevelReader worldView = ctx.getLevel();
		BlockPos blockPos = ctx.getClickedPos();
		Direction dir = ctx.getClickedFace();
		boolean water = worldView.getFluidState(blockPos).getType() == Fluids.WATER;
		if (dir != Direction.DOWN && dir != Direction.UP) {
			if (canSupportCenter(worldView, blockPos.above(), Direction.DOWN)) {
				return defaultBlockState().setValue(IS_FLOOR, false).setValue(WATERLOGGED, water);
			}
			else if (canSupportCenter(worldView, blockPos.below(), Direction.UP)) {
				return defaultBlockState().setValue(IS_FLOOR, true).setValue(WATERLOGGED, water);
			}
			else {
				return null;
			}
		}
		else if (dir == Direction.DOWN) {
			if (canSupportCenter(worldView, blockPos.above(), Direction.DOWN)) {
				return defaultBlockState().setValue(IS_FLOOR, false).setValue(WATERLOGGED, water);
			}
			else if (canSupportCenter(worldView, blockPos.below(), Direction.UP)) {
				return defaultBlockState().setValue(IS_FLOOR, true).setValue(WATERLOGGED, water);
			}
			else {
				return null;
			}
		}
		else {
			if (canSupportCenter(worldView, blockPos.below(), Direction.UP)) {
				return defaultBlockState().setValue(IS_FLOOR, true).setValue(WATERLOGGED, water);
			}
			else if (canSupportCenter(worldView, blockPos.above(), Direction.DOWN)) {
				return defaultBlockState().setValue(IS_FLOOR, false).setValue(WATERLOGGED, water);
			}
			else {
				return null;
			}
		}
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		if (state.getValue(IS_FLOOR)) {
			return canSupportCenter(world, pos.below(), Direction.UP);
		}
		else {
			return canSupportCenter(world, pos.above(), Direction.DOWN);
		}
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		Boolean water = state.getValue(WATERLOGGED);
		if (water) {
			world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		if (!canSurvive(state, world, pos)) {
			return water ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
		}
		else {
			return state;
		}
	}
	
	@Override
	public boolean canPlaceLiquid(BlockGetter world, BlockPos pos, BlockState state, Fluid fluid) {
		return false;
	}
	
	@Override
	public boolean placeLiquid(LevelAccessor world, BlockPos pos, BlockState state, FluidState fluidState) {
		return false;
	}
	
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		String floor = blockState.getValue(IS_FLOOR) ? "_floor" : "";
		ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + floor);
		registerBlockModel(stateId, modelId, blockState, modelCache);
		return ModelsHelper.createBlockSimple(modelId);
	}
}
