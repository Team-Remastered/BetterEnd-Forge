package com.teamremastered.betterendforge.complexmaterials;

import com.google.common.collect.Maps;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.blocks.BulbVineLanternBlock;
import com.teamremastered.betterendforge.blocks.BulbVineLanternColoredBlock;
import com.teamremastered.betterendforge.blocks.HydraluxPetalColoredBlock;
import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Supplier;

public class ColoredMaterial {
	private static final Map<Integer, ItemLike> DYES = Maps.newHashMap();
	private static final Map<Integer, String> COLORS = Maps.newHashMap();
	private final Map<Integer, Supplier<? extends Block>> colors = Maps.newHashMap();
	
	public ColoredMaterial(final Supplier<? extends Block> source, String sourceId, boolean craftEight) {
		this(source, sourceId, COLORS, DYES, craftEight);
	}

	//FIXME: Make it so that block value is not hardcoded
	public ColoredMaterial(final Supplier<? extends Block> source, String sourceId, Map<Integer, String> colors, Map<Integer, ItemLike> dyes, boolean craftEight) {
		String id = sourceId;
		colors.forEach((color, name) -> {
			String blockName = id + "_" + name;

            final Supplier<? extends Block> block;
            if (sourceId.contains("_bulb_lantern")) {
                block = () -> new BulbVineLanternColoredBlock(BlockBehaviour.Properties.copy(source.get()).color(MaterialColor.COLOR_BLACK));
            }
			else {
                block = () -> new HydraluxPetalColoredBlock(BlockBehaviour.Properties.copy(source.get()).color(MaterialColor.COLOR_BLACK));
            }
            EndBlocks.registerBlock(blockName, block);

//			if (craftEight) {
//				GridRecipe.make(BetterEndForge.MOD_ID, blockName, block.get())
//						  .setOutputCount(8)
//						  .setShape("###", "#D#", "###")
//						  .addMaterial('#', source)
//						  .addMaterial('D', dyes.get(color))
//						  .build();
//			}
//			else {
//				GridRecipe.make(BetterEndForge.MOD_ID, blockName, block.get())
//						  .setList("#D")
//						  .addMaterial('#', source)
//						  .addMaterial('D', dyes.get(color))
//						  .build();
//			}
//			this.colors.put(color, block.get());
//			BlocksHelper.addBlockColor(block.get(), color);
		}); //TODO: Fix the crafting recipes
	}
	
	public Block getByColor(DyeColor color) {
		return colors.get(color.getMaterialColor().col).get();
	}
	
	public Block getByColor(int color) {
		return colors.get(color).get();
	}
	
	static {
		for (DyeColor color : DyeColor.values()) {
			int colorRGB = color.getMaterialColor().col;
			COLORS.put(colorRGB, color.getName());
			DYES.put(colorRGB, DyeItem.byColor(color));
		}
	}
}
