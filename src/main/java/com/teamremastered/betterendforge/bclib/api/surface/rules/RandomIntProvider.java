package com.teamremastered.betterendforge.bclib.api.surface.rules;

import com.mojang.serialization.Codec;
import com.teamremastered.betterendforge.bclib.BCLib;
import net.minecraft.core.Registry;
import com.teamremastered.betterendforge.bclib.interfaces.NumericProvider;
import com.teamremastered.betterendforge.mixin.common.bclib.SurfaceRulesContextAccessor;
import com.teamremastered.betterendforge.bclib.util.MHelper;

public record RandomIntProvider(int range) implements NumericProvider {
	public static final Codec<RandomIntProvider> CODEC = Codec.INT.fieldOf("range").xmap(RandomIntProvider::new, obj -> obj.range).codec();

	@Override
	public int getNumber(SurfaceRulesContextAccessor context) {
		return MHelper.RANDOM.nextInt(range);
	}

	@Override
	public Codec<? extends NumericProvider> pcodec() {
		return CODEC;
	}

	static {
		Registry.register(NumericProvider.NUMERIC_PROVIDER , BCLib.makeID("rnd_int"), RandomIntProvider.CODEC);
	}
}
