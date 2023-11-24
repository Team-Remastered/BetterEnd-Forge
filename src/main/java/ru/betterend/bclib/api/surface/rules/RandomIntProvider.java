package ru.betterend.bclib.api.surface.rules;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.interfaces.NumericProvider;
import ru.betterend.mixin.common.bclib.SurfaceRulesContextAccessor;
import ru.betterend.bclib.util.MHelper;

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
