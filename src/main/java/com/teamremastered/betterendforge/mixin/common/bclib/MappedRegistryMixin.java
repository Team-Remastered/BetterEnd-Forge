package com.teamremastered.betterendforge.mixin.common.bclib;

import net.minecraft.core.MappedRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import com.teamremastered.betterendforge.bclib.interfaces.FrozableRegistry;

@Mixin(MappedRegistry.class)
public class MappedRegistryMixin<T> implements FrozableRegistry {
	@Shadow
	private boolean frozen;
	
	@Override
	public void setFrozeState(boolean frozen) {
		this.frozen = frozen;
	}
	
	@Override
	public boolean getFrozeState() {
		return this.frozen;
	}
}
