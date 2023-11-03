package ru.betterend.bclib.blocks;

import com.google.common.collect.Lists;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.List;

public abstract class WallMushroomBlock extends BaseWallPlantBlock {
	public WallMushroomBlock(int light) {
		this(
			BlockBehaviour.Properties
				.of(Material.PLANT)
				.luminance(light)
				.destroyTime(0.2F)
				.sound(SoundType.GRASS)
				.sound(SoundType.WOOD)
				.noCollission()
		);
	}
	
	public WallMushroomBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		return Lists.newArrayList(new ItemStack(this));
	}
	
	@Override
	public boolean isSupport(LevelReader world, BlockPos pos, BlockState blockState, Direction direction) {
		return blockState.getMaterial().isSolid() && blockState.isFaceSturdy(world, pos, direction);
	}
}
