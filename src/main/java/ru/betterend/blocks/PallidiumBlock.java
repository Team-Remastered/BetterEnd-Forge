package ru.betterend.blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.blocks.basis.EndTerrainBlock;
import ru.betterend.registry.EndBlocks;

import java.util.Map;

public class PallidiumBlock extends EndTerrainBlock {
	private final Block nextLevel;
	
	public PallidiumBlock(String thickness, Block nextLevel) {
		super(MaterialColor.COLOR_LIGHT_GRAY);
		this.nextLevel = nextLevel;
	}
	
	public boolean canBePotted() {
		return this == EndBlocks.PALLIDIUM_FULL.get();
	}
	
	@Override
	public Block getBaseBlock() {
		return EndBlocks.UMBRALITH.stone;
	}
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (nextLevel == null) {
			return InteractionResult.PASS;
		}
		else if (level.isClientSide) {
			return InteractionResult.PASS;
		}
		
		ItemStack itemStack = player.getItemInHand(hand);
		if (itemStack.is(Items.BONE_MEAL)) {
			BlocksHelper.setWithUpdate(level, pos, nextLevel);
			if (!player.isCreative()) {
				itemStack.shrink(1);
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
		return this.getBlockModel(stateId, blockState);
	}
}
