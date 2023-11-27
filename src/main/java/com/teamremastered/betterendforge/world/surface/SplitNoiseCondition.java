package com.teamremastered.betterendforge.world.surface;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import com.teamremastered.betterendforge.bclib.interfaces.NumericProvider;
import com.teamremastered.betterendforge.mixin.common.bclib.SurfaceRulesContextAccessor;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.noise.OpenSimplexNoise;

/**
 * Noise source that returns a value in [0, 1]
 */
public class SplitNoiseCondition implements NumericProvider {
	public static final SplitNoiseCondition DEFAULT = new SplitNoiseCondition();
	public static final Codec<SplitNoiseCondition> CODEC = Codec.BYTE.fieldOf("split_noise").xmap((obj)->DEFAULT, obj -> (byte)0).codec();

	private static final OpenSimplexNoise NOISE = new OpenSimplexNoise(4141);

	@Override
	public int getNumber(SurfaceRulesContextAccessor context) {
		final int x = context.getBlockX();
		final int z = context.getBlockZ();
		float noise = (float) NOISE.eval(x * 0.1, z * 0.1) + MHelper.randRange(-0.4F, 0.4F, MHelper.RANDOM);
		return noise > 0 ? 1 : 0;
	}

	@Override
	public Codec<? extends NumericProvider> pcodec() {
		return CODEC;
	}

	static {
		Registry.register(NumericProvider.NUMERIC_PROVIDER , BetterEndForge.makeID("split_noise"), SplitNoiseCondition.CODEC);
	}
}
