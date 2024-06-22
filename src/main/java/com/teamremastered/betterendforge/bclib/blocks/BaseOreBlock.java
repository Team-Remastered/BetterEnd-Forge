package com.teamremastered.betterendforge.bclib.blocks;

import com.teamremastered.betterendforge.bclib.interfaces.BlockModelProvider;
import com.teamremastered.betterendforge.bclib.interfaces.LootProvider;
import com.teamremastered.betterendforge.bclib.util.LootUtil;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class BaseOreBlock extends OreBlock implements BlockModelProvider, LootProvider {
	private final Supplier<Item> dropItem;
	private final int minCount;
	private final int maxCount;
	private final int miningLevel;
	
	public BaseOreBlock(Supplier<Item> drop, int minCount, int maxCount, int experience) {
		this(drop, minCount, maxCount, experience, 0);
	}
	
	public BaseOreBlock(Supplier<Item> drop, int minCount, int maxCount, int experience, int miningLevel) {
		this(
			BlockBehaviour.Properties
				.of(Material.STONE, MaterialColor.SAND)
				.requiresCorrectToolForDrops()
				.destroyTime(3F)
				.explosionResistance(9F)
				.sound(SoundType.STONE),
			drop, minCount, maxCount, experience, miningLevel
		);
	}
	
	public BaseOreBlock(Properties properties, Supplier<Item> drop, int minCount, int maxCount, int experience) {
		this(properties, drop, minCount, maxCount, experience, 0);
	}
	
	public BaseOreBlock(Properties properties, Supplier<Item> drop, int minCount, int maxCount, int experience, int miningLevel) {
		super(properties, UniformInt.of(experience>0?1:0, experience));
		this.dropItem = drop;
		this.minCount = minCount;
		this.maxCount = maxCount;
		this.miningLevel = miningLevel;
	}
	
	@Override
	public List<ItemStack> getLoot(BlockState state, LootContext.Builder builder) {
		return LootUtil
			.getDrops(this, state, builder)
			.orElseGet(
				()->BaseOreBlock.getDroppedItems(this, dropItem.get(), maxCount, minCount, miningLevel, state, builder)
			);
	}
	
	public static List<ItemStack> getDroppedItems(ItemLike block, Item dropItem, int maxCount, int minCount, int miningLevel, BlockState state, LootContext.Builder builder) {
		ItemStack tool = builder.getParameter(LootContextParams.TOOL);
		if (tool != null && tool.isCorrectToolForDrops(state)) {
			boolean canMine = miningLevel==0;
			if (tool.getItem() instanceof TieredItem tired) {
				canMine = tired.getTier().getLevel()>=miningLevel;
			}
			if (canMine) {
				if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0) {
					return Collections.singletonList(new ItemStack(block));
				}
				int count;
				int enchantment = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, tool);
				if (enchantment > 0) {
					int min = Mth.clamp(minCount + enchantment, minCount, maxCount);
					int max = maxCount + (enchantment / Enchantments.BLOCK_FORTUNE.getMaxLevel());
					if (min == max) {
						return Collections.singletonList(new ItemStack(dropItem, max));
					}
					count = MHelper.randRange(min, max, MHelper.RANDOM);
				} else {
					count = MHelper.randRange(minCount, maxCount, MHelper.RANDOM);
				}
				return Collections.singletonList(new ItemStack(dropItem, count));
			}
		}
		return Collections.emptyList();
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public BlockModel getItemModel(ResourceLocation resourceLocation) {
		return getBlockModel(resourceLocation, defaultBlockState());
	}
}
