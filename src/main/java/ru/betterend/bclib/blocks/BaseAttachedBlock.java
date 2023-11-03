package ru.betterend.bclib.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import ru.betterend.bclib.util.BlocksHelper;

@SuppressWarnings("deprecation")
public abstract class BaseAttachedBlock extends BaseBlockNotFull {
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	
	public BaseAttachedBlock(Properties settings) {
		super(settings);
		registerDefaultState(defaultBlockState().setValue(FACING, Direction.UP));
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(FACING);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		BlockState blockState = defaultBlockState();
		LevelReader worldView = ctx.getLevel();
		BlockPos blockPos = ctx.getClickedPos();
		Direction[] directions = ctx.getNearestLookingDirections();
		for (Direction direction : directions) {
			Direction direction2 = direction.getOpposite();
			blockState = blockState.setValue(FACING, direction2);
			if (blockState.canSurvive(worldView, blockPos)) {
				return blockState;
			}
		}
		return null;
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockPos blockPos = pos.relative(direction.getOpposite());
		return canSupportCenter(world, blockPos, direction) || world.getBlockState(blockPos).is(BlockTags.LEAVES);
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		if (!canSurvive(state, world, pos)) {
			return Blocks.AIR.defaultBlockState();
		}
		else {
			return state;
		}
	}
	
	
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return BlocksHelper.rotateHorizontal(state, rotation, FACING);
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return BlocksHelper.mirrorHorizontal(state, mirror, FACING);
	}
}
