package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.BaseLeavesBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.interfaces.PottablePlant;

public class PottableLeavesBlock extends BaseLeavesBlock implements PottablePlant {
	
	public PottableLeavesBlock(Block sapling, MaterialColor color) {
		super(sapling, color);
	}
	
	public PottableLeavesBlock(Block sapling, MaterialColor color, int light) {
		super(sapling, color, light);
	}
	
	@Override
	public boolean canPlantOn(Block block) {
		if (sapling instanceof PottablePlant) {
			return ((PottablePlant) sapling).canPlantOn(block);
		}
		return true;
	}
}
