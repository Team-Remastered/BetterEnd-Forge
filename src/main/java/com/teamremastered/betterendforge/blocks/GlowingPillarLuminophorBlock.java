package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShears;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
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
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.registry.EndBlocks;

public class GlowingPillarLuminophorBlock extends BaseBlock implements AddMineableShears {
	public static final BooleanProperty NATURAL = EndBlockProperties.NATURAL;
	
	public GlowingPillarLuminophorBlock() {
		super(BlockBehaviour.Properties.of(Material.LEAVES)
								 .color(MaterialColor.COLOR_ORANGE)
								 .strength(0.2F)
								 .lightLevel(BlocksHelper.getLightValue(15))
								 .sound(SoundType.GRASS));
		this.registerDefaultState(this.stateDefinition.any().setValue(NATURAL, false));
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return !state.getValue(NATURAL) || world.getBlockState(pos.below()).is(EndBlocks.GLOWING_PILLAR_ROOTS.get());
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
