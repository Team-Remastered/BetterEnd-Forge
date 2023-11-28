package com.teamremastered.betterendforge.blocks.basis;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.bclib.api.tag.NamedBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.blocks.BaseAttachedBlock;
import com.teamremastered.betterendforge.bclib.client.render.BCLRenderLayer;
import com.teamremastered.betterendforge.bclib.interfaces.RenderLayerProvider;
import com.teamremastered.betterendforge.bclib.interfaces.tools.AddMineableShears;
import com.teamremastered.betterendforge.bclib.items.tool.BaseShearsItem;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumMap;
import java.util.List;

public class FurBlock extends BaseAttachedBlock implements RenderLayerProvider, AddMineableShears {
	private static final EnumMap<Direction, VoxelShape> BOUNDING_SHAPES = Maps.newEnumMap(Direction.class);
	private final ItemLike drop;
	private final int dropChance;
	
	public FurBlock(ItemLike drop, int light, int dropChance, boolean wet) {
		super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
								 .lightLevel(BlocksHelper.getLightValue(light))
								 .sound(wet ? SoundType.WET_GRASS : SoundType.GRASS)
								 .noCollission());
		this.drop = drop;
		this.dropChance = dropChance;
		TagAPI.addBlockTag(NamedBlockTags.LEAVES, this);
	}
	
	public FurBlock(ItemLike drop, int dropChance) {
		super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
								 
								 .sound(SoundType.GRASS)
								 .noCollission());
		this.drop = drop;
		this.dropChance = dropChance;
		TagAPI.addBlockTag(NamedBlockTags.LEAVES, this);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, BlockGetter view, BlockPos pos, CollisionContext ePos) {
		return BOUNDING_SHAPES.get(state.getValue(FACING));
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		ItemStack tool = builder.getParameter(LootContextParams.TOOL);
		if (tool != null && BaseShearsItem.isShear(tool) || EnchantmentHelper.getItemEnchantmentLevel(
			Enchantments.SILK_TOUCH,
			tool
		) > 0) {
			return Lists.newArrayList(new ItemStack(this));
		}
		else if (dropChance < 1 || MHelper.RANDOM.nextInt(dropChance) == 0) {
			return Lists.newArrayList(new ItemStack(drop));
		}
		else {
			return Lists.newArrayList();
		}
	}
	
	@Override
	public BCLRenderLayer getRenderLayer() {
		return BCLRenderLayer.CUTOUT;
	}
	
	static {
		BOUNDING_SHAPES.put(Direction.UP, Shapes.box(0.0, 0.0, 0.0, 1.0, 0.5, 1.0));
		BOUNDING_SHAPES.put(Direction.DOWN, Shapes.box(0.0, 0.5, 0.0, 1.0, 1.0, 1.0));
		BOUNDING_SHAPES.put(Direction.NORTH, Shapes.box(0.0, 0.0, 0.5, 1.0, 1.0, 1.0));
		BOUNDING_SHAPES.put(Direction.SOUTH, Shapes.box(0.0, 0.0, 0.0, 1.0, 1.0, 0.5));
		BOUNDING_SHAPES.put(Direction.WEST, Shapes.box(0.5, 0.0, 0.0, 1.0, 1.0, 1.0));
		BOUNDING_SHAPES.put(Direction.EAST, Shapes.box(0.0, 0.0, 0.0, 0.5, 1.0, 1.0));
	}
}
