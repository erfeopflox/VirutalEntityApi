package dev.by1337.virtualentity.api.util.nbt;

import dev.by1337.core.util.misc.Pair;

import java.util.stream.Stream;

public interface MapLike<T> {

    T get(T key);

    T get(String key);

    Stream<Pair<T, T>> entries();
}
