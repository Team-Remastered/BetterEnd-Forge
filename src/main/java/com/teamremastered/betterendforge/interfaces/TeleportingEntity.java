package com.teamremastered.betterendforge.interfaces;

import net.minecraft.core.BlockPos;

public interface TeleportingEntity {
	void be_setExitPos(BlockPos pos);
	
	void be_resetExitPos();
	
	boolean be_canTeleport();
}
