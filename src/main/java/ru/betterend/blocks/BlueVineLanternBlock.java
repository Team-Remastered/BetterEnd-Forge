package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.bclib.blocks.BlockProperties;
import ru.betterend.bclib.interfaces.tools.AddMineableAxe;
import ru.betterend.registry.EndBlocks;

public class BlueVineLanternBlock extends BaseBlock implements AddMineableAxe {
	public static final BooleanProperty NATURAL = BlockProperties.NATURAL;
	
	public BlueVineLanternBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD)
								 .lightLevel(BlocksHelper.getLightValue(15))
								 .sound(SoundType.WART_BLOCK));
		this.registerDefaultState(this.stateDefinition.any().setValue(NATURAL, false));
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return !state.getValue(NATURAL) || world.getBlockState(pos.below()).getBlock() == EndBlocks.BLUE_VINE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
		if (!canSurvive(state, world, pos)) {
			return Blocks.AIR.defaultBlockState();
		}
		else {
			return state;
		}
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(NATURAL);
	}
}
