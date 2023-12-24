package com.teamremastered.betterendforge.noise;


import com.teamremastered.betterendforge.interfaces.AreaFactory;
import com.teamremastered.betterendforge.world.util.AreaContext;

import java.util.function.LongFunction;

public class LayeredNoiseUtil {
    public LayeredNoiseUtil() {
    }

    public static AreaFactory zoom(long seedModifier, AreaTransformer1 transformer, AreaFactory initialAreaFactory, int times, LongFunction<AreaContext> contextFactory) {
        AreaFactory areaFactory = initialAreaFactory;

        for(int i = 0; i < times; ++i) {
            areaFactory = transformer.run((AreaContext)contextFactory.apply(seedModifier + (long)i), areaFactory);
        }

        return areaFactory;
    }
}