package ru.betterend.bclib.interfaces;

import ru.betterend.bclib.api.datafixer.MigrationProfile;
import ru.betterend.bclib.api.datafixer.PatchDidiFailException;

@FunctionalInterface
public interface PatchFunction<T, R> {
	R apply(T t, MigrationProfile profile) throws PatchDidiFailException;
}
