package dev.by1337.virtualentity.api.util.nbt.impl;


import dev.by1337.virtualentity.api.util.nbt.NbtType;
import dev.by1337.virtualentity.api.util.nbt.NumericNBT;

public class ShortNBT extends NumericNBT {

    private final short value;

    private ShortNBT(short value) {
        super(value);
        this.value = value;
    }

    public static ShortNBT valueOf(short i) {
        return i >= -128 && i <= 1024 ? Cache.cache[i + 128] : new ShortNBT(i);
    }

    @Override
    public NbtType getType() {
        return NbtType.SHORT;
    }

    public short getValue() {
        return value;
    }

    @Override
    public Object getAsObject() {
        return value;
    }

    @Override
    public ShortNBT copy() {
        return this;
    }

    static class Cache {
        private static final int HIGH = 1024;
        private static final int LOW = -128;
        static final ShortNBT[] cache = new ShortNBT[HIGH - LOW + 1];

        static {
            for (int i = 0; i < cache.length; ++i) {
                cache[i] = new ShortNBT((short) (LOW + i));
            }

        }

        private Cache() {
        }
    }
}
