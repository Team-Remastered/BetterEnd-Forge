package com.teamremastered.betterendforge.bclib.interfaces;

@FunctionalInterface
public interface TriConsumer<A, B, C> {
	void accept(A a, B b, C c);
}
