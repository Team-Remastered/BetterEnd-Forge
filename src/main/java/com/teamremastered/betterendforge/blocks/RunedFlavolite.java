package com.teamremastered.betterendforge.blocks;

import com.google.common.collect.Lists;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.blocks.BlockProperties;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import com.teamremastered.betterendforge.registry.EndBlocks;

import java.util.List;

public class RunedFlavolite extends BaseBlock {
	public static final BooleanProperty ACTIVATED = BlockProperties.ACTIVE;
	
	public RunedFlavolite(boolean unbreakable) {
		super(BlockBehaviour.Properties.copy(EndBlocks.FLAVOLITE.polished.get())
								 .strength(
									 unbreakable ? -1 : 1,
									 unbreakable ? Blocks.BEDROCK.getExplosionResistance() : Blocks.OBSIDIAN.getExplosionResistance()
								 )
								 .lightLevel(state -> {
									 return state.getValue(ACTIVATED) ? 8 : 0;
								 }));
		this.registerDefaultState(stateDefinition.any().setValue(ACTIVATED, false));
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(ACTIVATED);
	}
	
	@Override
	public boolean dropFromExplosion(Explosion explosion) {
		return !BlocksHelper.isInvulnerableUnsafe(this.defaultBlockState());
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		if (BlocksHelper.isInvulnerableUnsafe(this.defaultBlockState())) {
			return Lists.newArrayList();
		}
		return super.getDrops(state, builder);
	}
}
