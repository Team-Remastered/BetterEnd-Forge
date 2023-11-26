package ru.betterend.complexmaterials;

import com.google.common.collect.Maps;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.Registry;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.bclib.recipes.GridRecipe;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.BetterEndForge;
import ru.betterend.registry.EndBlocks;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ColoredMaterial {
	private static final Map<Integer, ItemLike> DYES = Maps.newHashMap();
	private static final Map<Integer, String> COLORS = Maps.newHashMap();
	private final Map<Integer, Block> colors = Maps.newHashMap();
	
	public ColoredMaterial(final Supplier<? extends Block> source, String sourceId, boolean craftEight) {
		this(source, sourceId, COLORS, DYES, craftEight);
	}
	
	public ColoredMaterial( final Supplier<? extends Block> source, String sourceId, Map<Integer, String> colors, Map<Integer, ItemLike> dyes, boolean craftEight) {
		String id = sourceId;
		colors.forEach((color, name) -> {
			String blockName = id + "_" + name;
			final Supplier<? extends Block> block = source; //TODO: Find a way to add to the source block properties
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
		return colors.get(color.getMaterialColor().col);
	}
	
	public Block getByColor(int color) {
		return colors.get(color);
	}
	
	static {
		for (DyeColor color : DyeColor.values()) {
			int colorRGB = color.getMaterialColor().col;
			COLORS.put(colorRGB, color.getName());
			DYES.put(colorRGB, DyeItem.byColor(color));
		}
	}
}
