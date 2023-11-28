package com.teamremastered.betterendforge.blocks.basis;

import com.teamremastered.betterendforge.bclib.blocks.FeatureSaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import com.teamremastered.betterendforge.interfaces.PottablePlant;

import java.util.function.Function;

public abstract class PottableFeatureSapling extends FeatureSaplingBlock implements PottablePlant {
	public PottableFeatureSapling(Function<BlockState, Feature<?>> featureSupplier) {
		super(featureSupplier);
	}
	
	public PottableFeatureSapling(int light, Function<BlockState, Feature<?>> featureSupplier) {
		super(light, featureSupplier);
	}
}
