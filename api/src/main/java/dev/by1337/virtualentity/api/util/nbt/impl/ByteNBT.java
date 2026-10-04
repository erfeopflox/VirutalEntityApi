package dev.by1337.virtualentity.api.util.nbt.impl;

import dev.by1337.virtualentity.api.util.nbt.NbtType;
import dev.by1337.virtualentity.api.util.nbt.NumericNBT;

import java.util.Objects;

public class ByteNBT extends NumericNBT {
    private final byte value;

    private ByteNBT(byte value) {
        super(value);
        this.value = value;
    }

    public static ByteNBT valueOf(byte b) {
        return Cache.cache[128 + b];
    }

    @Override
    public NbtType getType() {
        return NbtType.BYTE;
    }

    public byte getValue() {
        return value;
    }

    @Override
    public Object getAsObject() {
        return value;
    }

    @Override
    public ByteNBT copy() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByteNBT byteNBT = (ByteNBT) o;
        return value == byteNBT.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    static class Cache {
        static final ByteNBT[] cache = new ByteNBT[256];

        static {
            for (int i = 0; i < cache.length; ++i) {
                cache[i] = new ByteNBT((byte) (i - 128));
            }

        }

        private Cache() {
        }
    }
}
