package ru.betterend.blocks;

import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.betterend.bclib.blocks.BlockHelper;
import ru.betterend.bclib.interfaces.tools.AddMineableShears;
import ru.betterend.blocks.basis.EndUnderwaterPlantBlock;

import java.util.Random;

public class PondAnemoneBlock extends EndUnderwaterPlantBlock implements AddMineableShears {
	private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 14, 14);
	
	public PondAnemoneBlock() {
		super(BlockBehaviour.Properties.of(Material.WATER_PLANT)
								 
								 .lightLevel(BlockHelper.getLightValue(13))
								 .sound(SoundType.CORAL_BLOCK)
								 .noCollission());
	}
	
	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.NONE;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level world, BlockPos pos, Random random) {
		double x = pos.getX() + random.nextDouble();
		double y = pos.getY() + random.nextDouble() * 0.5F + 0.5F;
		double z = pos.getZ() + random.nextDouble();
		world.addParticle(ParticleTypes.BUBBLE, x, y, z, 0.0D, 0.0D, 0.0D);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}
	
	@Override
	public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}
	
	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return false;
	}
}
