package ru.betterend.blocks.basis;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import ru.bclib.blocks.FeatureSaplingBlock;
import ru.betterend.interfaces.PottablePlant;

import java.util.function.Function;

public abstract class PottableFeatureSapling extends FeatureSaplingBlock implements PottablePlant {
	public PottableFeatureSapling(Function<BlockState, Feature<?>> featureSupplier) {
		super(featureSupplier);
	}
	
	public PottableFeatureSapling(int light, Function<BlockState, Feature<?>> featureSupplier) {
		super(light, featureSupplier);
	}
}
