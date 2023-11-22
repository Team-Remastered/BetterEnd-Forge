package ru.betterend.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import ru.betterend.bclib.client.models.ModelsHelper;
import ru.betterend.blocks.basis.EndPlantBlock;
import ru.betterend.registry.EndBlocks;

public class FlammalixBlock extends EndPlantBlock {
	private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 14, 14);
	
	public FlammalixBlock() {
		super(false, 12);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.PALLIDIUM_FULL.get()) ||
			state.is(EndBlocks.PALLIDIUM_HEAVY.get()) ||
			state.is(EndBlocks.PALLIDIUM_THIN.get()) ||
			state.is(EndBlocks.PALLIDIUM_TINY.get());
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return SHAPE;
	}
	
	@Override
	public OffsetType getOffsetType() {
		return OffsetType.NONE;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return ModelsHelper.createItemModel(resourceLocation);
	}
}
