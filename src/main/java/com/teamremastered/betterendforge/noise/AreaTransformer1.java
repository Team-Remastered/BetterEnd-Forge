package com.teamremastered.betterendforge.noise;

import com.teamremastered.betterendforge.interfaces.AreaFactory;
import com.teamremastered.betterendforge.world.util.Area;
import com.teamremastered.betterendforge.world.util.AreaContext;

public interface AreaTransformer1 {
    default AreaFactory run(AreaContext context, AreaFactory areaFactory) {
        return () -> {
            Area area = areaFactory.make();
            return context.createResult((x, y) -> {
                context.initRandom((long)x, (long)y);
                return this.apply(context, area, x, y);
            }, area);
        };
    }

    int apply(AreaContext var1, Area var2, int var3, int var4);
}
