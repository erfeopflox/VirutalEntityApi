package dev.by1337.virtualentity.api.util.nbt;

import com.google.common.collect.Lists;
import dev.by1337.core.util.misc.Pair;
import dev.by1337.core.util.text.MessageFormatter;
import dev.by1337.virtualentity.api.util.nbt.impl.*;
import dev.by1337.yaml.codec.DataResult;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NbtOps implements DynamicOps<NBT> {

    public static final NbtOps INSTANCE = new NbtOps();

    public static final NBT EMPTY = new StringNBT(null);

    protected NbtOps() {
    }

    @Override
    public NBT empty() {
        return EMPTY;
    }

    @Override
    public <U> U convertTo(DynamicOps<U> outOps, NBT nbt) {
        return switch (nbt.getType()) {
            case BYTE -> outOps.createByte(((ByteNBT) nbt).getValue());
            case DOUBLE -> outOps.createDouble(((DoubleNBT) nbt).getValue());
            case FLOAT -> outOps.createFloat(((FloatNBT) nbt).getValue());
            case INT -> outOps.createInt(((IntNBT) nbt).getValue());
            case LONG -> outOps.createLong(((LongNBT) nbt).getValue());
            case SHORT -> outOps.createShort(((ShortNBT) nbt).getValue());

            case STRING -> outOps.createString(((StringNBT) nbt).getValue());

            case BYTE_ARR -> outOps.createByteList(
                    ByteBuffer.wrap(((ByteArrNBT) nbt).getValue())
            );

            case INT_ARR -> outOps.createIntList(
                    Arrays.stream(((IntArrNBT) nbt).getValue())
            );

            case LONG_ARR -> outOps.createLongList(
                    Arrays.stream(((LongArrNBT) nbt).getValue())
            );

            case LIST -> convertList(outOps, nbt);
            case COMPOUND -> convertMap(outOps, nbt);
        };
    }

    @Override
    public DataResult<Number> getNumberValue(NBT nbt) {
        if (nbt instanceof NumericNBT numeric) {
            return DataResult.success(numeric.getAsNumber());
        }

        return DataResult.error("Not a number");
    }

    @Override
    public NBT createNumeric(Number number) {
        return new DoubleNBT(number.doubleValue());
    }

    @Override
    public NBT createByte(byte value) {
        return ByteNBT.valueOf(value);
    }

    @Override
    public NBT createShort(short value) {
        return ShortNBT.valueOf(value);
    }

    @Override
    public NBT createInt(int value) {
        return IntNBT.valueOf(value);
    }

    @Override
    public NBT createLong(long value) {
        return LongNBT.valueOf(value);
    }

    @Override
    public NBT createFloat(float value) {
        return new FloatNBT(value);
    }

    @Override
    public NBT createDouble(double value) {
        return new DoubleNBT(value);
    }

    @Override
    public NBT createIntList(IntStream input) {
        return new IntArrNBT(input.toArray());
    }

    @Override
    public NBT createLongList(LongStream input) {
        return new LongArrNBT(input.toArray());
    }

    @Override
    public DataResult<String> getStringValue(NBT nbt) {
        if (nbt instanceof StringNBT string) {
            return DataResult.success(string.getValue());
        }

        return DataResult.error("Not a string");
    }

    @Override
    public NBT createString(String value) {
        return new StringNBT(value);
    }

    @Override
    public DataResult<NBT> mergeToList(NBT list, NBT value) {
        if (list instanceof ListNBT || list == EMPTY) {
            ListNBT listNBT;

            if (list instanceof ListNBT existingList) {
                listNBT = new ListNBT(
                        existingList.getList(),
                        existingList.isAllowMultipleType()
                );
            } else {
                listNBT = new ListNBT();
            }

            try {
                listNBT.add(value);
            } catch (ListNBT.NBTCastException exception) {
                return DataResult.error(exception.getMessage());
            }

            return DataResult.success(listNBT);
        }

        if (value instanceof NumericNBT numeric) {
            if (list instanceof ByteArrNBT array) {
                byte[] result = new byte[array.getValue().length + 1];

                System.arraycopy(
                        array.getValue(),
                        0,
                        result,
                        0,
                        array.getValue().length
                );

                result[result.length - 1] = numeric.byteValue();

                return DataResult.success(new ByteArrNBT(result));
            }

            if (list instanceof IntArrNBT array) {
                int[] result = new int[array.getValue().length + 1];

                System.arraycopy(
                        array.getValue(),
                        0,
                        result,
                        0,
                        array.getValue().length
                );

                result[result.length - 1] = numeric.intValue();

                return DataResult.success(new IntArrNBT(result));
            }

            if (list instanceof LongArrNBT array) {
                long[] result = new long[array.getValue().length + 1];

                System.arraycopy(
                        array.getValue(),
                        0,
                        result,
                        0,
                        array.getValue().length
                );

                result[result.length - 1] = numeric.longValue();

                return DataResult.success(new LongArrNBT(result));
            }
        }

        return DataResult.error(
                MessageFormatter.apply(
                        "Unable to add {} to {}",
                        value.getType(),
                        list.getType()
                )
        );
    }

    @Override
    public DataResult<NBT> mergeToMap(NBT map, NBT key, NBT value) {
        if (!(map instanceof CompoundTag) && map != EMPTY) {
            return DataResult.error(
                    "mergeToMap called with not a map: " + map,
                    map
            );
        }

        if (!(key instanceof StringNBT stringKey)) {
            return DataResult.error(
                    "key is not a string: " + key,
                    map
            );
        }

        CompoundTag newTag;

        if (map instanceof CompoundTag compound) {
            newTag = (CompoundTag) compound.copy();
        } else {
            newTag = new CompoundTag();
        }

        newTag.putTag(stringKey.getValue(), value);

        return DataResult.success(newTag);
    }

    @Override
    public DataResult<NBT> mergeToMap(
            NBT map,
            MapLike<NBT> values
    ) {
        if (!(map instanceof CompoundTag) && map != EMPTY) {
            return DataResult.error(
                    "mergeToMap called with not a map: " + map,
                    map
            );
        }

        CompoundTag newTag;

        if (map instanceof CompoundTag compound) {
            newTag = (CompoundTag) compound.copy();
        } else {
            newTag = new CompoundTag();
        }

        List<NBT> missed = Lists.newArrayList();

        values.entries().forEach(entry -> {
            NBT key = entry.getLeft();

            if (!(key instanceof StringNBT stringKey)) {
                missed.add(key);
                return;
            }

            newTag.putTag(stringKey.getValue(), entry.getRight());
        });

        if (!missed.isEmpty()) {
            return DataResult.error(
                    "some keys are not string: " + missed,
                    newTag
            );
        }

        return DataResult.success(newTag);
    }

    @Override
    public DataResult<Stream<Pair<NBT, NBT>>> getMapValues(NBT map) {
        if (!(map instanceof CompoundTag) && map != EMPTY) {
            return DataResult.error("Not a map: " + map);
        }

        if (map instanceof CompoundTag tag) {
            return DataResult.success(
                    tag.getTags()
                            .entrySet()
                            .stream()
                            .map(entry -> Pair.of(
                                    new StringNBT(entry.getKey()),
                                    entry.getValue() == EMPTY
                                            ? null
                                            : entry.getValue()
                            ))
            );
        }

        return DataResult.success(Stream.empty());
    }

    @Override
    public NBT createMap(Stream<Pair<NBT, NBT>> stream) {
        CompoundTag compound = new CompoundTag();

        stream.forEach(pair -> {
            NBT key = pair.getLeft();
            NBT value = pair.getRight();

            compound.putTag(
                    String.valueOf(key.getAsObject()),
                    value
            );
        });

        return compound;
    }

    @Override
    public DataResult<MapLike<NBT>> getMap(NBT map) {
        if (!(map instanceof CompoundTag) && map != EMPTY) {
            return DataResult.error("Not a map: " + map);
        }

        Map<String, NBT> nbtMap;

        if (map instanceof CompoundTag tag) {
            nbtMap = new HashMap<>(tag.getTags());
        } else {
            nbtMap = Collections.emptyMap();
        }

        MapLike<NBT> result = new MapLike<>() {
            @Override
            public NBT get(NBT key) {
                if (key instanceof StringNBT stringKey) {
                    return nbtMap.get(stringKey.getValue());
                }

                return null;
            }

            @Override
            public NBT get(String key) {
                return nbtMap.get(key);
            }

            @Override
            public Stream<Pair<NBT, NBT>> entries() {
                return nbtMap.entrySet()
                        .stream()
                        .map(entry -> Pair.of(
                                new StringNBT(entry.getKey()),
                                entry.getValue()
                        ));
            }
        };

        return DataResult.success(result);
    }

    @Override
    public DataResult<Stream<NBT>> getStream(NBT nbt) {
        if (nbt == EMPTY) {
            return DataResult.success(Stream.empty());
        }

        if (nbt instanceof ListNBT list) {
            return DataResult.success(list.stream());
        }

        if (nbt instanceof ByteArrNBT array) {
            return DataResult.success(
                    array.stream().map(ByteNBT::valueOf)
            );
        }

        if (nbt instanceof IntArrNBT array) {
            return DataResult.success(
                    array.stream().map(IntNBT::valueOf)
            );
        }

        if (nbt instanceof LongArrNBT array) {
            return DataResult.success(
                    array.stream().map(LongNBT::valueOf)
            );
        }

        return DataResult.error("Not a list: " + nbt.getType());
    }

    @Override
    public NBT createList(Stream<NBT> stream) {
        List<NBT> values = new ArrayList<>();
        stream.forEach(values::add);

        if (values.isEmpty()) {
            return new ListNBT();
        }

        if (values.stream().allMatch(value ->
                value.getType() == NbtType.BYTE
        )) {
            byte[] array = new byte[values.size()];

            for (int i = 0; i < values.size(); i++) {
                array[i] = ((ByteNBT) values.get(i)).byteValue();
            }

            return new ByteArrNBT(array);
        }

        if (values.stream().allMatch(value ->
                value.getType() == NbtType.INT
        )) {
            int[] array = new int[values.size()];

            for (int i = 0; i < values.size(); i++) {
                array[i] = ((IntNBT) values.get(i)).intValue();
            }

            return new IntArrNBT(array);
        }

        if (values.stream().allMatch(value ->
                value.getType() == NbtType.LONG
        )) {
            long[] array = new long[values.size()];

            for (int i = 0; i < values.size(); i++) {
                array[i] = ((LongNBT) values.get(i)).longValue();
            }

            return new LongArrNBT(array);
        }

        return new ListNBT(values);
    }

    @Override
    public <U> U convertList(DynamicOps<U> outOps, NBT input) {
        if (!(input instanceof ListNBT list)) {
            throw new IllegalArgumentException("Not a list: " + input);
        }

        return outOps.createList(
                list.stream()
                        .map(value -> convertTo(outOps, value))
        );
    }

    @Override
    public <U> U convertMap(DynamicOps<U> outOps, NBT input) {
        if (!(input instanceof CompoundTag compound)) {
            throw new IllegalArgumentException("Not a compound: " + input);
        }

        return outOps.createMap(
                compound.getTags()
                        .entrySet()
                        .stream()
                        .map(entry -> Pair.of(
                                outOps.createString(entry.getKey()),
                                convertTo(outOps, entry.getValue())
                        ))
        );
    }

    @Override
    public NBT remove(NBT nbt, String key) {
        if (nbt instanceof CompoundTag tag) {
            CompoundTag copy = tag.copy();
            copy.remove(key);
            return copy;
        }

        return nbt;
    }

    @Override
    public NBT emptyMap() {
        return new CompoundTag();
    }

    @Override
    public NBT emptyList() {
        return new ListNBT();
    }

    @Override
    public DataResult<ByteBuffer> getByteBuffer(NBT input) {
        if (input instanceof ByteArrNBT array) {
            return DataResult.success(
                    ByteBuffer.wrap(array.getValue())
            );
        }

        return DynamicOps.super.getByteBuffer(input);
    }

    @Override
    public NBT createByteList(ByteBuffer input) {
        ByteBuffer copy = input.slice();

        byte[] bytes = new byte[copy.remaining()];
        copy.get(bytes);

        return new ByteArrNBT(bytes);
    }
}
