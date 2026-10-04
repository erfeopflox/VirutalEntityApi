package dev.by1337.virtualentity.api.util.nbt.impl;

import dev.by1337.virtualentity.api.util.nbt.NbtType;
import dev.by1337.virtualentity.api.util.nbt.NumericNBT;

import java.util.Objects;

public class LongNBT extends NumericNBT {

    private final long value;

    private LongNBT(long value) {
        super(value);
        this.value = value;
    }

    public static LongNBT valueOf(long l) {
        return l >= -128L && l <= 1024L ? Cache.cache[(int) l + 128] : new LongNBT(l);
    }

    @Override
    public NbtType getType() {
        return NbtType.LONG;
    }

    public long getValue() {
        return value;
    }

    @Override
    public Object getAsObject() {
        return value;
    }

    @Override
    public LongNBT copy() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongNBT longNBT = (LongNBT) o;
        return value == longNBT.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    static class Cache {
        private static final int HIGH = 1024;
        private static final int LOW = -128;
        static final LongNBT[] cache = new LongNBT[HIGH - LOW + 1];

        static {
            for (int i = 0; i < cache.length; ++i) {
                cache[i] = new LongNBT(LOW + i);
            }

        }

        private Cache() {
        }
    }
}
