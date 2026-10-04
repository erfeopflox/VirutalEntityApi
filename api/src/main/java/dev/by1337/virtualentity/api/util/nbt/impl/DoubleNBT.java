package dev.by1337.virtualentity.api.util.nbt.impl;

import dev.by1337.virtualentity.api.util.nbt.NbtType;
import dev.by1337.virtualentity.api.util.nbt.NumericNBT;

import java.util.Objects;

public class DoubleNBT extends NumericNBT {

    private final double value;

    public DoubleNBT(double value) {
        super(value);
        this.value = value;
    }

    @Override
    public NbtType getType() {
        return NbtType.DOUBLE;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleNBT doubleNBT = (DoubleNBT) o;
        return Double.compare(value, doubleNBT.value) == 0;
    }

    @Override
    public Object getAsObject() {
        return value;
    }

    @Override
    public DoubleNBT copy() {
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
