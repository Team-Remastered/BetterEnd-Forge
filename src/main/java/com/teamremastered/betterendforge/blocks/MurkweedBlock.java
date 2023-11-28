package com.teamremastered.betterendforge.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import com.teamremastered.betterendforge.blocks.basis.EndPlantBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.Random;

public class MurkweedBlock extends EndPlantBlock {
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level world, BlockPos pos, Random random) {
		double x = pos.getX() + random.nextDouble();
		double y = pos.getY() + random.nextDouble() * 0.5 + 0.5;
		double z = pos.getZ() + random.nextDouble();
		double v = random.nextDouble() * 0.1;
		world.addParticle(ParticleTypes.ENTITY_EFFECT, x, y, z, v, v, v);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity && !((LivingEntity) entity).hasEffect(MobEffects.BLINDNESS)) {
			((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50));
		}
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.SHADOW_GRASS.get());
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
		return false;
	}
}
