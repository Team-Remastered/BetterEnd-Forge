package com.teamremastered.betterendforge.blocks;

import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;

import java.util.Collections;
import java.util.List;

public class DenseEmeraldIceBlock extends BaseBlock implements RenderLayerProvider {
	public DenseEmeraldIceBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE));
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		ItemStack tool = builder.getOptionalParameter(LootContextParams.TOOL);
		if (tool != null && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) != 0) {
			return Collections.singletonList(new ItemStack(this));
		}
		else {
			return Collections.emptyList();
		}
	}
}
