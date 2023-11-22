package ru.betterend.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootContext;
import ru.betterend.bclib.api.tag.NamedBlockTags;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.blocks.BaseLeavesBlock;
import ru.betterend.bclib.interfaces.CustomColorProvider;
import ru.betterend.bclib.interfaces.tools.AddMineableShears;
import ru.betterend.bclib.util.ColorUtil;
import ru.betterend.bclib.util.MHelper;
import ru.betterend.noise.OpenSimplexNoise;
import ru.betterend.registry.EndBlocks;

import java.util.List;

public class HelixTreeLeavesBlock extends BaseBlock implements CustomColorProvider, AddMineableShears {
	public static final IntegerProperty COLOR = EndBlockProperties.COLOR;
	private static final OpenSimplexNoise NOISE = new OpenSimplexNoise(0);
	
	public HelixTreeLeavesBlock() {
		super(BlockBehaviour.Properties
			.of(Material.LEAVES)
			.mapColor(MaterialColor.COLOR_ORANGE)
			.sound(SoundType.WART_BLOCK)
			.sound(SoundType.GRASS)
			.strength(0.2F)
		);

		TagAPI.addBlockTag(NamedBlockTags.LEAVES, this);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
		stateManager.add(COLOR);
	}
	
	@Override
	public BlockColor getProvider() {
		return (state, world, pos, tintIndex) -> {
			return ColorUtil.color(237, getGreen(state.getValue(COLOR)), 20);
		};
	}
	
	@Override
	public ItemColor getItemProvider() {
		return (stack, tintIndex) -> {
			return ColorUtil.color(237, getGreen(4), 20);
		};
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		double px = ctx.getClickedPos().getX() * 0.1;
		double py = ctx.getClickedPos().getY() * 0.1;
		double pz = ctx.getClickedPos().getZ() * 0.1;
		return this.defaultBlockState().setValue(COLOR, MHelper.floor(NOISE.eval(px, py, pz) * 3.5 + 4));
	}
	
	private int getGreen(int color) {
		float delta = color / 7F;
		return (int) Mth.lerp(delta, 80, 158);
	}
	
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		return BaseLeavesBlock.getLeaveDrops(this, EndBlocks.HELIX_TREE_SAPLING.get(), builder, 16, 32);
	}
}
