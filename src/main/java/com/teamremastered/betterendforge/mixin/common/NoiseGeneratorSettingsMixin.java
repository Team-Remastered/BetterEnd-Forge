package com.teamremastered.betterendforge.mixin.common;

import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import com.teamremastered.betterendforge.interfaces.BETargetChecker;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements BETargetChecker {
	private boolean be_isTargetGenerator;
	
	@Override
	public boolean be_isTarget() {
		return be_isTargetGenerator;
	}
	
	@Override
	public void be_setTarget(boolean target) {
		be_isTargetGenerator = target;
	}
}
