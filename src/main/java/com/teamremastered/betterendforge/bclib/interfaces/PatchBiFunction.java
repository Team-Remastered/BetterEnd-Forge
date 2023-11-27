package com.teamremastered.betterendforge.bclib.interfaces;

import com.teamremastered.betterendforge.bclib.api.datafixer.MigrationProfile;
import com.teamremastered.betterendforge.bclib.api.datafixer.PatchDidiFailException;

@FunctionalInterface
public interface PatchBiFunction<U, V, R> {
	R apply(U t, V v, MigrationProfile profile) throws PatchDidiFailException;
}