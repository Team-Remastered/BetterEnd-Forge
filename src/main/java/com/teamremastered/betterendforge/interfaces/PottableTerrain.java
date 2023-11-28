package com.teamremastered.betterendforge.interfaces;

public interface PottableTerrain {
	default boolean canBePotted() {
		return true;
	}
}
