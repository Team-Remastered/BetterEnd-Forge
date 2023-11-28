package com.teamremastered.betterendforge.bclib.api.surface.rules;

import net.minecraft.world.level.levelgen.SurfaceRules;
import com.teamremastered.betterendforge.mixin.common.bclib.SurfaceRulesContextAccessor;

public interface NoiseCondition extends SurfaceRules.ConditionSource{
	boolean test(SurfaceRulesContextAccessor context);
}
