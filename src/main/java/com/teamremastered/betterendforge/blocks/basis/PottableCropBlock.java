package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.BaseCropBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import com.teamremastered.betterendforge.interfaces.PottablePlant;

import java.util.function.Supplier;

public class PottableCropBlock extends BaseCropBlock implements PottablePlant {
	private final Supplier<? extends Block>[] terrain;
	
	public PottableCropBlock(final Supplier<? extends Item> drop, final Supplier<? extends Block>... terrain) {
		super(drop, terrain);
		this.terrain = terrain;
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		for (Supplier<? extends Block> ter : terrain) {
			if (block == ter.get()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String getPottedState() {
		return "age=3";
	}
}