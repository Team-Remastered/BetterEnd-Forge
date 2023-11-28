package com.teamremastered.betterendforge.bclib.interfaces;

import com.teamremastered.betterendforge.bclib.api.datafixer.MigrationProfile;
import com.teamremastered.betterendforge.bclib.api.datafixer.PatchDidiFailException;

@FunctionalInterface
public interface PatchFunction<T, R> {
	R apply(T t, MigrationProfile profile) throws PatchDidiFailException;
}
