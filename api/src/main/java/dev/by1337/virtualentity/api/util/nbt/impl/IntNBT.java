package dev.by1337.virtualentity.api.util.nbt.impl;

import dev.by1337.virtualentity.api.util.nbt.NbtType;
import dev.by1337.virtualentity.api.util.nbt.NumericNBT;

import java.util.Objects;

public class IntNBT extends NumericNBT {

    private final int value;

    private IntNBT(int value) {
        super(value);
        this.value = value;
    }

    public static IntNBT valueOf(int i) {
        return i >= -128 && i <= 1024 ? Cache.cache[i + 128] : new IntNBT(i);
    }

    @Override
    public NbtType getType() {
        return NbtType.INT;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Object getAsObject() {
        return value;
    }

    @Override
    public IntNBT copy() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntNBT intNBT = (IntNBT) o;
        return value == intNBT.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    static class Cache {
        private static final int HIGH = 1024;
        private static final int LOW = -128;
        static final IntNBT[] cache = new IntNBT[HIGH - LOW + 1];

        static {
            for (int i = 0; i < cache.length; ++i) {
                cache[i] = new IntNBT(LOW + i);
            }

        }

        private Cache() {
        }
    }
}
