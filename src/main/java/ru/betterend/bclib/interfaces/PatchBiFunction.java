package ru.betterend.bclib.interfaces;

import ru.betterend.bclib.api.datafixer.MigrationProfile;
import ru.betterend.bclib.api.datafixer.PatchDidiFailException;

@FunctionalInterface
public interface PatchBiFunction<U, V, R> {
	R apply(U t, V v, MigrationProfile profile) throws PatchDidiFailException;
}