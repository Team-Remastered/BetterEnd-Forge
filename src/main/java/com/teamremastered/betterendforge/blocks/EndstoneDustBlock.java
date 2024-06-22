package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.interfaces.TagProvider;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShovel;
import com.teamremastered.betterendforge.bclib.util.ColorUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.Collections;
import java.util.List;

public class EndstoneDustBlock extends FallingBlock implements TagProvider, AddMineableShovel {
//	@OnlyIn(Dist.CLIENT)
	private static final int COLOR = ColorUtil.color(226, 239, 168);
	
	public EndstoneDustBlock() {
		super(BlockBehaviour.Properties
			.copy(Blocks.SAND)
			.color(Blocks.END_STONE.defaultMaterialColor())
		);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		return Collections.singletonList(new ItemStack(this));
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState state, BlockGetter world, BlockPos pos) {
		return COLOR;
	}
	
	@Override
	public void addTags(List<TagAPI.TagLocation<Block>> blockTags, List<TagAPI.TagLocation<Item>> itemTags) {
		blockTags.add(NamedCommonBlockTags.END_STONES);
	}
}
