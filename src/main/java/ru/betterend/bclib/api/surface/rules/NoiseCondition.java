package ru.betterend.bclib.api.surface.rules;

import net.minecraft.world.level.levelgen.SurfaceRules;
import ru.betterend.bclib.mixin.common.SurfaceRulesContextAccessor;

public interface NoiseCondition extends SurfaceRules.ConditionSource{
	boolean test(SurfaceRulesContextAccessor context);
}
