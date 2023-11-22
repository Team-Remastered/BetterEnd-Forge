package ru.betterend.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.blocks.BaseDoublePlantBlock;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.blocks.basis.EndPlantBlock;
import ru.betterend.registry.EndBlocks;

import java.util.Random;

public class TwistedUmbrellaMossBlock extends EndPlantBlock {
	public TwistedUmbrellaMossBlock() {
		super(11);
	}
	
	@Override
	protected boolean isTerrain(BlockState state) {
		return state.is(EndBlocks.END_MOSS.get()) || state.is(EndBlocks.END_MYCELIUM.get()) || state.is(EndBlocks.JUNGLE_MOSS.get());
	}
	
	@OnlyIn(Dist.CLIENT)
	public boolean hasEmissiveLighting(BlockGetter world, BlockPos pos) {
		return true;
	}
	
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightLevel(BlockGetter world, BlockPos pos) {
		return 1F;
	}
	
	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return world.isEmptyBlock(pos.above());
	}
	
	@Override
	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
		int rot = world.random.nextInt(4);
		BlockState bs = EndBlocks.TWISTED_UMBRELLA_MOSS_TALL.get().defaultBlockState()
															.setValue(BaseDoublePlantBlock.ROTATION, rot);
		BlocksHelper.setWithoutUpdate(world, pos, bs);
		BlocksHelper.setWithoutUpdate(world, pos.above(), bs.setValue(BaseDoublePlantBlock.TOP, true));
	}
}
