package ru.betterend.bclib.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import ru.betterend.bclib.util.BlocksHelper;
public abstract class BaseUnderwaterWallPlantBlock extends BaseWallPlantBlock implements LiquidBlockContainer {
	public BaseUnderwaterWallPlantBlock() {
		this(
			BlockBehaviour.Properties
				.of(Material.WATER_PLANT)
				.sound(SoundType.WET_GRASS)
				.noCollission()
		);
	}
	
	public BaseUnderwaterWallPlantBlock(int light) {
		this(
			BlockBehaviour.Properties
				.of(Material.WATER_PLANT)
				.lightLevel(BlocksHelper.getLightValue(light))
				.sound(SoundType.WET_GRASS)
				.noCollission()
		);
	}
	public BaseUnderwaterWallPlantBlock(Properties settings) {
		super(settings);
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
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return Fluids.WATER.getSource(false);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		return world.getFluidState(pos).getType() == Fluids.WATER && super.canSurvive(state, world, pos);
	}
}
