package com.teamremastered.betterendforge.world.surface;

import com.mojang.serialization.Codec;
import com.teamremastered.betterendforge.bclib.interfaces.NumericProvider;
import com.teamremastered.betterendforge.bclib.util.MHelper;
import com.teamremastered.betterendforge.noise.OpenSimplexNoise;
import net.minecraft.core.Registry;
import com.teamremastered.betterendforge.mixin.common.bclib.SurfaceRulesContextAccessor;
import com.teamremastered.betterendforge.BetterEndForge;

/**
 * Noise source that returns a value in [0, 4]
 */
public class UmbraSurfaceNoiseCondition implements NumericProvider {
	public static final UmbraSurfaceNoiseCondition DEFAULT = new UmbraSurfaceNoiseCondition();
	public static final Codec<UmbraSurfaceNoiseCondition> CODEC = Codec.BYTE.fieldOf("umbra_srf").xmap((obj)->DEFAULT, obj -> (byte)0).codec();

	private static final OpenSimplexNoise NOISE = new OpenSimplexNoise(1512);

	@Override
	public int getNumber(SurfaceRulesContextAccessor context) {
		final int x = context.getBlockX();
		final int z = context.getBlockZ();
		return getDepth(x, z);
	}
	
	public static int getDepth(int x, int z) {
		final double value = NOISE.eval(x * 0.03, z * 0.03) + NOISE.eval(x * 0.1, z * 0.1) * 0.3 + MHelper.randRange(-0.1, 0.1, MHelper.RANDOM);
		if (value > 0.4) return 0;
		if (value > 0.15) return 1;
		if (value > -0.15) return 2;
		if (value > -0.4) return 3;
		return 4;
	}

	@Override
	public Codec<? extends NumericProvider> pcodec() {
		return CODEC;
	}

	static {
		Registry.register(NumericProvider.NUMERIC_PROVIDER , BetterEndForge.makeID("umbra_srf"), UmbraSurfaceNoiseCondition.CODEC);
	}
}
