package com.teamremastered.betterendforge.world.util;

import com.teamremastered.betterendforge.interfaces.PixelTransformer;
import it.unimi.dsi.fastutil.HashCommon;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;

import java.util.Arrays;
import java.util.concurrent.locks.StampedLock;

public class Area {
    private final long[] keys;
    private final int[] values;
    private final int mask;
    private final PixelTransformer operator;
    private final StampedLock lock = new StampedLock();

    public Area(PixelTransformer operator, int size) {
        this.operator = operator;
        size = Mth.smallestEncompassingPowerOfTwo(size);
        this.mask = size - 1;
        this.keys = new long[size];
        Arrays.fill(this.keys, Long.MIN_VALUE);
        this.values = new int[size];
    }

    public int get(int x, int z) {
        long key = this.key(x, z);
        int idx = this.hash(key) & this.mask;
        long stamp = this.lock.readLock();
        int value;
        if (this.keys[idx] == key) {
            value = this.values[idx];
            this.lock.unlockRead(stamp);
            return value;
        } else {
            this.lock.unlockRead(stamp);
            stamp = this.lock.writeLock();
            value = this.operator.apply(x, z);
            this.keys[idx] = key;
            this.values[idx] = value;
            this.lock.unlockWrite(stamp);
            return value;
        }
    }

    private int hash(long key) {
        return (int) HashCommon.mix(key);
    }

    private long key(int x, int z) {
        return ChunkPos.asLong(x, z);
    }

    public int getMaxCache() {
        return this.mask + 1;
    }

}
