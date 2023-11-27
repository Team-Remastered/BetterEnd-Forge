package com.teamremastered.betterendforge.bclib.util;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;
import java.util.Random;
import java.util.function.ToIntFunction;

public class BlocksHelper {
	private static final Map<Block, Integer> COLOR_BY_BLOCK = Maps.newHashMap();
	
	public static final int FLAG_UPDATE_BLOCK = 1;
	public static final int FLAG_SEND_CLIENT_CHANGES = 2;
	public static final int FLAG_NO_RERENDER = 4;
	public static final int FORSE_RERENDER = 8;
	public static final int FLAG_IGNORE_OBSERVERS = 16;
	
	public static final int SET_SILENT = FLAG_UPDATE_BLOCK | FLAG_IGNORE_OBSERVERS | FLAG_SEND_CLIENT_CHANGES;
	public static final int SET_OBSERV = FLAG_UPDATE_BLOCK | FLAG_SEND_CLIENT_CHANGES;
	public static final Direction[] HORIZONTAL = makeHorizontal();
	public static final Direction[] DIRECTIONS = Direction.values();
	
	private static final ThreadLocal<MutableBlockPos> TL_POS = ThreadLocal.withInitial(() -> new MutableBlockPos());
	
	protected static final BlockState AIR = Blocks.AIR.defaultBlockState();
	protected static final BlockState WATER = Blocks.WATER.defaultBlockState();
	
	public static void addBlockColor(Block block, int color) {
		COLOR_BY_BLOCK.put(block, color);
	}
	
	public static int getBlockColor(Block block) {
		return COLOR_BY_BLOCK.getOrDefault(block, 0xFF000000);
	}
	
	public static void setWithoutUpdate(LevelAccessor world, BlockPos pos, BlockState state) {
		world.setBlock(pos, state, SET_SILENT);
	}
	
	public static void setWithoutUpdate(LevelAccessor world, BlockPos pos, Block block) {
		world.setBlock(pos, block.defaultBlockState(), SET_SILENT);
	}
	
	public static void setWithUpdate(LevelAccessor world, BlockPos pos, BlockState state) {
		world.setBlock(pos, state, SET_OBSERV);
	}
	
	public static void setWithUpdate(LevelAccessor world, BlockPos pos, Block block) {
		world.setBlock(pos, block.defaultBlockState(), SET_OBSERV);
	}
	
	public static int upRay(LevelAccessor world, BlockPos pos, int maxDist) {
		int length = 0;
		for (int j = 1; j < maxDist && (world.isEmptyBlock(pos.above(j))); j++) {
			length++;
		}
		return length;
	}
	
	public static int downRay(LevelAccessor world, BlockPos pos, int maxDist) {
		int length = 0;
		for (int j = 1; j < maxDist && (world.isEmptyBlock(pos.below(j))); j++) {
			length++;
		}
		return length;
	}
	
	public static int downRayRep(LevelAccessor world, BlockPos pos, int maxDist) {
		final MutableBlockPos POS = TL_POS.get();
		POS.set(pos);
		for (int j = 1; j < maxDist && (world.getBlockState(POS)).getMaterial().isReplaceable(); j++) {
			POS.setY(POS.getY() - 1);
		}
		return pos.getY() - POS.getY();
	}
	
	public static int raycastSqr(LevelAccessor world, BlockPos pos, int dx, int dy, int dz, int maxDist) {
		final MutableBlockPos POS = TL_POS.get();
		POS.set(pos);
		for (int j = 1; j < maxDist && (world.getBlockState(POS)).getMaterial().isReplaceable(); j++) {
			POS.move(dx, dy, dz);
		}
		return (int) pos.distSqr(POS);
	}
	
	/**
	 * Rotates {@link BlockState} horizontally. Used in block classes with {@link Direction} {@link Property} in rotate function.
	 *
	 * @param state	- {@link BlockState} to mirror;
	 * @param rotation - {@link Rotation};
	 * @param facing   - Block {@link Direction} {@link Property}.
	 * @return Rotated {@link BlockState}.
	 */
	public static BlockState rotateHorizontal(BlockState state, Rotation rotation, Property<Direction> facing) {
		return state.setValue(facing, rotation.rotate(state.getValue(facing)));
	}
	
	/**
	 * Mirrors {@link BlockState} horizontally. Used in block classes with {@link Direction} {@link Property} in mirror function.
	 *
	 * @param state  - {@link BlockState} to mirror;
	 * @param mirror - {@link Mirror};
	 * @param facing - Block {@link Direction} {@link Property}.
	 * @return Mirrored {@link BlockState}.
	 */
	public static BlockState mirrorHorizontal(BlockState state, Mirror mirror, Property<Direction> facing) {
		return state.rotate(mirror.getRotation(state.getValue(facing)));
	}
	
	/**
	 * Counts the amount of same block down.
	 *
	 * @param world - {@link LevelAccessor} world;
	 * @param pos   - {@link BlockPos} start position;
	 * @param block - {@link Block} to count.
	 * @return Integer amount of blocks.
	 */
	public static int getLengthDown(LevelAccessor world, BlockPos pos, Block block) {
		int count = 1;
		while (world.getBlockState(pos.below(count)).getBlock() == block) {
			count++;
		}
		return count;
	}
	
	/**
	 * Creates a new {@link Direction} array with clockwise order:
	 * NORTH, EAST, SOUTH, WEST
	 *
	 * @return Array of {@link Direction}.
	 */
	public static Direction[] makeHorizontal() {
		return new Direction[] {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
	}
	
	/**
	 * Get any random horizontal {@link Direction}.
	 *
	 * @param random - {@link Random}.
	 * @return {@link Direction}.
	 */
	public static Direction randomHorizontal(Random random) {
		return HORIZONTAL[random.nextInt(4)];
	}
	
	/**
	 * Get any random {@link Direction} including vertical and horizontal.
	 *
	 * @param random - {@link Random}.
	 * @return {@link Direction}.
	 */
	public static Direction randomDirection(Random random) {
		return DIRECTIONS[random.nextInt(6)];
	}
	
	/**
	 * Check if block is {@link Fluid} or not.
	 *
	 * @param state - {@link BlockState} to check.
	 * @return {@code true} if block is fluid and {@code false} if not.
	 */
	public static boolean isFluid(BlockState state) {
		return !state.getFluidState().isEmpty();
	}
	
	/**
	 * Check if block is "invulnerable" like Bedrock.
	 *
	 * @param state - {@link BlockState} to check;
	 * @param world - {@link BlockGetter} world where BlockState exist;
	 * @param pos   - {@link BlockPos} where BlockState is.
	 * @return {@code true} if block is "invulnerable" and {@code false} if not.
	 */
	public static boolean isInvulnerable(BlockState state, BlockGetter world, BlockPos pos) {
		return state.getDestroySpeed(world, pos) < 0;
	}
	
	/**
	 * Check if block is "invulnerable" like Bedrock. Unlike safe function will pass world and position parameters as {@code null}.
	 *
	 * @param state - {@link BlockState} to check.
	 * @return {@code true} if block is "invulnerable" and {@code false} if not.
	 */
	public static boolean isInvulnerableUnsafe(BlockState state) {
		try {
			return isInvulnerable(state, null, null);
		}
		catch (Exception e) {
			return false;
		}
	}

	public static ToIntFunction<BlockState> getLightValue(int pLightValue) {
		return (state) -> {
			return pLightValue;
		};
	}
}
