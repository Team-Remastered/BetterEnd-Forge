package com.teamremastered.betterendforge.blocks;

import com.google.common.collect.Lists;
import com.teamremastered.betterendforge.bclib.api.tag.CommonBlockTags;
import com.teamremastered.betterendforge.bclib.blocks.UnderwaterPlantBlock;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShears;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import com.teamremastered.betterendforge.blocks.EndBlockProperties.HydraluxShape;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HydraluxBlock extends UnderwaterPlantBlock implements AddMineableShears {
	
	public static final EnumProperty<HydraluxShape> SHAPE = EndBlockProperties.HYDRALUX_SHAPE;
	
	public HydraluxBlock() {
		super(BlockBehaviour.Properties.of(Material.WATER_PLANT)
								 .sound(SoundType.WET_GRASS)
								 .lightLevel((state) -> state.getValue(SHAPE).hasGlow() ? 15 : 0)
								 .noCollission());
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(SHAPE);
	}
	
	@Override
	public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
		BlockState down = world.getBlockState(pos.below());
		HydraluxShape shape = state.getValue(SHAPE);
		if (shape == HydraluxShape.FLOWER_BIG_TOP || shape == HydraluxShape.FLOWER_SMALL_TOP) {
			return down.is(this);
		}
		else if (shape == HydraluxShape.ROOTS) {
			return down.is(EndBlocks.SULPHURIC_ROCK.stone.get()) && world.getBlockState(pos.above()).is(this);
		}
		else {
			return down.is(this) && world.getBlockState(pos.above()).is(this);
		}
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(CommonBlockTags.END_STONES);
	}
	
	@Override
	public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}
	
	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return false;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
		return new ItemStack(EndBlocks.HYDRALUX_SAPLING.get());
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		HydraluxShape shape = state.getValue(SHAPE);
		if (shape == HydraluxShape.FLOWER_BIG_BOTTOM || shape == HydraluxShape.FLOWER_SMALL_BOTTOM) {
			return Lists.newArrayList(new ItemStack(EndItems.HYDRALUX_PETAL.get(), MHelper.randRange(1, 4, MHelper.RANDOM)));
		}
		else if (shape == HydraluxShape.ROOTS) {
			return Lists.newArrayList(new ItemStack(
				EndBlocks.HYDRALUX_SAPLING.get(),
				MHelper.randRange(1, 2, MHelper.RANDOM)
			));
		}
		return Collections.emptyList();
	}
}
