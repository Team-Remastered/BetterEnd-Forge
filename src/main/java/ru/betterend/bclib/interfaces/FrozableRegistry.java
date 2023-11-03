package ru.betterend.bclib.interfaces;

public interface FrozableRegistry {
	void setFrozeState(boolean frozen);
	boolean getFrozeState();
}
