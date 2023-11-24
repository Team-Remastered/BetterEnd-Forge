package ru.betterend.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;

public class EndConfigGenericEntry<T> {
    protected static ArrayList<EndConfigGenericEntry<?>> endConfigGenericEntries = new ArrayList<>();
    protected final String ID;
    protected final String COMMENT;
    protected final T DEFAULT_VALUE;

    protected ForgeConfigSpec.ConfigValue<T> CONFIG_VALUE;

    public EndConfigGenericEntry(String id, String comment, T default_value) {
        this.ID = id;
        this.COMMENT = comment;
        this.DEFAULT_VALUE = default_value;
        endConfigGenericEntries.add(this);
    }

    public void setup(ForgeConfigSpec.Builder builder) {
        this.CONFIG_VALUE = builder.comment(this.COMMENT).define(this.ID, this.DEFAULT_VALUE);
    }

    public T getRaw() {
        return this.CONFIG_VALUE.get();
    }

    public void set(T value) {
        this.CONFIG_VALUE.set(value);
    }
}
