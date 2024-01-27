package com.teamremastered.betterendforge.noise;

import com.teamremastered.betterendforge.interfaces.AreaFactory;
import com.teamremastered.betterendforge.world.util.AreaContext;

public interface AreaTransformer0 {

    default AreaFactory run(AreaContext context) {
        return () -> {
            return context.createResult((x, y) -> {
                context.initRandom((long)x, (long)y);
                return this.apply(context, x, y);
            });
        };
    }

    int apply(AreaContext var1, int var2, int var3);
}
