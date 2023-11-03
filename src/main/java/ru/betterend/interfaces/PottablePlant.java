package ru.betterend.interfaces;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.Block;

public interface PottablePlant {
	boolean canPlantOn(Block block);
	
	default boolean canBePotted() {
		return true;
	}
	
	@OnlyIn(Dist.CLIENT)
	default String getPottedState() {
		return "";
	}
}
