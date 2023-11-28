package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.LeveledAnvilBlock;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.complexmaterials.MetalMaterial;

public class EndAnvilBlock extends LeveledAnvilBlock {
	protected MetalMaterial metalMaterial;
	
	public EndAnvilBlock(MaterialColor color, int level) {
		super(color, level);
	}
	
	public EndAnvilBlock(MetalMaterial metalMaterial, MaterialColor color, int level) {
		super(color, level);
		this.metalMaterial = metalMaterial;
	}
	
	public int getCraftingLevel() {
		return level;
	}
}
