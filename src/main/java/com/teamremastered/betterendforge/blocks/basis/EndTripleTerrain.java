package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.TripleTerrainBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import com.teamremastered.betterendforge.interfaces.PottableTerrain;

public class EndTripleTerrain extends TripleTerrainBlock implements PottableTerrain {
	public EndTripleTerrain(MaterialColor color) {
		super(Blocks.END_STONE, color);
	}
}
