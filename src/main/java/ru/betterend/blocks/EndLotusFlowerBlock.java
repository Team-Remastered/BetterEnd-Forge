package ru.betterend.blocks;

import com.google.common.collect.Lists;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.bclib.util.MHelper;
import ru.betterend.blocks.basis.EndPlantBlock;
import ru.betterend.registry.EndBlocks;

import java.util.List;

public class EndLotusFlowerBlock extends EndPlantBlock {
	private static final VoxelShape SHAPE_OUTLINE = Block.box(2, 0, 2, 14, 14, 14);
	private static final VoxelShape SHAPE_COLLISION = Block.box(0, 0, 0, 16, 2, 16);
	
	public EndLotusFlowerBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT).lightLevel(BlocksHelper.getLightValue(15)).noOcclusion());
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.END_LOTUS_STEM.get());
	}
	
	@Override
	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.NONE;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE_OUTLINE;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getCollisionShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE_COLLISION;
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		int count = MHelper.randRange(1, 2, MHelper.RANDOM);
		return Lists.newArrayList(new ItemStack(EndBlocks.END_LOTUS_SEED.get(), count));
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
		return new ItemStack(EndBlocks.END_LOTUS_SEED.get());
	}
}
