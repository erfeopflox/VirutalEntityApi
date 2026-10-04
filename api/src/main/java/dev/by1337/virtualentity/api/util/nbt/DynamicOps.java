package dev.by1337.virtualentity.api.util.nbt;

import dev.by1337.core.util.misc.Pair;
import dev.by1337.yaml.codec.DataResult;

import java.nio.ByteBuffer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface DynamicOps<T> {

    T empty();

    <U> U convertTo(DynamicOps<U> outOps, T input);

    DataResult<Number> getNumberValue(T input);

    T createNumeric(Number value);

    T createByte(byte value);

    T createShort(short value);

    T createInt(int value);

    T createLong(long value);

    T createFloat(float value);

    T createIntList(IntStream input);

    T createLongList(LongStream input);

    T createDouble(double value);

    DataResult<String> getStringValue(T input);

    T createString(String value);

    DataResult<T> mergeToList(T list, T value);

    DataResult<T> mergeToMap(T map, T key, T value);

    DataResult<T> mergeToMap(T map, MapLike<T> values);

    DataResult<Stream<Pair<T, T>>> getMapValues(T map);

    T createMap(Stream<Pair<T, T>> values);

    DataResult<MapLike<T>> getMap(T map);

    DataResult<Stream<T>> getStream(T input);

    T createList(Stream<T> values);

    T remove(T input, String key);

    T emptyMap();

    T emptyList();

    default DataResult<ByteBuffer> getByteBuffer(T input) {
        return DataResult.error("Not a byte array");
    }

    T createByteList(ByteBuffer input);

    default <U> U convertList(DynamicOps<U> outOps, T input) {
        throw new UnsupportedOperationException("convertList is not implemented");
    }

    default <U> U convertMap(DynamicOps<U> outOps, T input) {
        throw new UnsupportedOperationException("convertMap is not implemented");
    }

}
