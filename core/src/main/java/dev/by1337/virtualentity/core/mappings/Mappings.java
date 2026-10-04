package dev.by1337.virtualentity.core.mappings;

import dev.by1337.core.ServerVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.util.nbt.MojangNbtReader;
import dev.by1337.virtualentity.api.util.nbt.NBT;
import dev.by1337.virtualentity.api.util.nbt.NbtOps;
import dev.by1337.virtualentity.api.util.nbt.impl.*;
import dev.by1337.virtualentity.core.SupportedVersions;
import dev.by1337.virtualentity.core.network.PacketType;
import dev.by1337.virtualentity.core.syncher.EntityDataAccessor;
import dev.by1337.virtualentity.core.syncher.EntityDataSerializer;
import dev.by1337.virtualentity.core.syncher.EntityDataSerializers;
import dev.by1337.yaml.codec.RecordYamlCodecBuilder;
import dev.by1337.yaml.codec.YamlCodec;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Mappings {
    public static final YamlCodec<Mappings> CODEC = RecordYamlCodecBuilder.mapOf(
            Mappings::new,
            YamlCodec.mapOf(YamlCodec.STRING, YamlCodec.INT).fieldOf("serializerToId", Mappings::serializerToId),
            YamlCodec.mapOf(VirtualEntityType.CODEC, EntityInfo.CODEC).fieldOf("typeToData", Mappings::entityTypeToEntityInfo),
            YamlCodec.mapOf(YamlCodec.STRING, NetworkValue.CODEC.listOf()).fieldOf("entities", Mappings::entityNetworkValues),
            YamlCodec.mapOf(YamlCodec.STRING, YamlCodec.mapOf(YamlCodec.STRING, YamlCodec.INT)).fieldOf("enums", Mappings::enumMappings)
    );
    public static final Mappings instance;
    private static final Logger LOGGER = LoggerFactory.getLogger("VirtualEntityApi#Mappings");

    static {
        final InputStream in =
                getMappingsInputStream(ServerVersion.CURRENT_PROTOCOL);

        Mappings v = null;

        try (in) {
            CompoundTag nbt = MojangNbtReader.readCompressed(in);

            v = CODEC.decode(toJavaObject(nbt))
                    .getOrThrow();

            v.applyEnumMappings();
        } catch (Exception e) {
            LOGGER.error(
                    "Failed to read mappings file for version {}",
                    ServerVersion.CURRENT_ID,
                    e
            );
        }

        instance = v;
    }

    private final Map<String, Integer> serializerToId;
    private final Map<VirtualEntityType, EntityInfo> entityTypeToEntityInfo;
    private final Map<String, List<NetworkValue>> entityNetworkValues;
    private final Map<String, Map<String, Integer>> enumMappings;

    private Mappings(Map<String, Integer> serializerToId, Map<VirtualEntityType, EntityInfo> entityTypeToEntityInfo, Map<String, List<NetworkValue>> entityNetworkValues, Map<String, Map<String, Integer>> enumMappings) {
        this.serializerToId = serializerToId;
        this.entityTypeToEntityInfo = entityTypeToEntityInfo;
        this.entityNetworkValues = entityNetworkValues;
        this.enumMappings = enumMappings;
    }

    public static void load() {
        // ping static block
    }

    @SuppressWarnings("unchecked")
    public static <T> EntityDataAccessor<T> findAccessor(String clazz, String id) {
        List<NetworkValue> list = instance.entityNetworkValues.get(clazz);
        if (list == null) {
            return null;
            //   throw new IllegalStateException("Has no mappings for entity " + clazz);
        }
        NetworkValue value = list.stream().filter(v -> v.name.equals(id)).findFirst().orElse(null);
        if (value == null) {
            throw new IllegalStateException("Has no NetworkValue " + id + " for entity " + clazz);
        }
        EntityDataSerializer<?> serializer = EntityDataSerializers.getByName(value.type);
        if (serializer == null) {
            throw new IllegalStateException("Unknown EntityDataSerializer type " + value.type);
        }
        return (EntityDataAccessor<T>) new EntityDataAccessor<>(value.id, serializer);
    }

    public static int getNetworkId(VirtualEntityType type) {
        EntityInfo entityInfo = instance.entityTypeToEntityInfo.get(type);
        if (entityInfo == null) {
            throw new IllegalStateException("Has no EntityInfo for type " + type + " Version: " + ServerVersion.CURRENT_ID);
        }
        return entityInfo.networkId;
    }

    public static PacketType getSpawnPacket(VirtualEntityType type) {
        EntityInfo entityInfo = instance.entityTypeToEntityInfo.get(type);
        if (entityInfo == null) {
            throw new IllegalStateException("Has no EntityInfo for type " + type + " Version: " + ServerVersion.CURRENT_ID);
        }
        return entityInfo.spawnPacket;
    }

    private static Object toJavaObject(NBT value) {
        if (value == null || value == NbtOps.EMPTY) {
            return null;
        }

        return switch (value.getType()) {
            case BYTE -> ((ByteNBT) value).getValue();
            case SHORT -> ((ShortNBT) value).getValue();
            case INT -> ((IntNBT) value).getValue();
            case LONG -> ((LongNBT) value).getValue();
            case FLOAT -> ((FloatNBT) value).getValue();
            case DOUBLE -> ((DoubleNBT) value).getValue();
            case STRING -> ((StringNBT) value).getValue();

            case BYTE_ARR -> {
                byte[] array = ((ByteArrNBT) value).getValue();
                List<Byte> result = new java.util.ArrayList<>(array.length);

                for (byte element : array) {
                    result.add(element);
                }

                yield result;
            }

            case INT_ARR -> {
                int[] array = ((IntArrNBT) value).getValue();
                List<Integer> result = new java.util.ArrayList<>(array.length);

                for (int element : array) {
                    result.add(element);
                }

                yield result;
            }

            case LONG_ARR -> {
                long[] array = ((LongArrNBT) value).getValue();
                List<Long> result = new java.util.ArrayList<>(array.length);

                for (long element : array) {
                    result.add(element);
                }

                yield result;
            }

            case LIST -> {
                List<Object> result = new java.util.ArrayList<>();

                for (NBT element : (ListNBT) value) {
                    result.add(toJavaObject(element));
                }

                yield result;
            }

            case COMPOUND -> {
                Map<String, Object> result = new LinkedHashMap<>();

                CompoundTag compound = (CompoundTag) value;

                compound.getTags().forEach((key, element) ->
                        result.put(key, toJavaObject(element))
                );

                yield result;
            }
        };
    }

    @NotNull
    public static InputStream getMappingsInputStream(int version) {
        SupportedVersions.requireProtocol(version);
        InputStream in;
        ClassLoader loader = Mappings.class.getClassLoader();
        URL url = loader.getResource("entity/" + version + ".nbt");
        if (url == null) {
            throw new RuntimeException("Could not find mappings file for version " + version);
        }
        try {
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            in = connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (in == null) {
            throw new RuntimeException("Could not find mappings file for version " + version);
        }
        return in;
    }

    public Map<String, Integer> serializerToId() {
        return serializerToId;
    }

    public Map<VirtualEntityType, EntityInfo> entityTypeToEntityInfo() {
        return entityTypeToEntityInfo;
    }

    public Map<String, List<NetworkValue>> entityNetworkValues() {
        return entityNetworkValues;
    }

    public Map<String, Map<String, Integer>> enumMappings() {
        return enumMappings;
    }

    private void applyEnumMappings() {
        enumMappings.forEach(this::applyEnumMappings);
    }

    @SuppressWarnings("unchecked")
    private <T extends Enum<T>> void applyEnumMappings(String clazz, Map<String, Integer> mappings) {
        try {
            Class<?> clazz1 = Class.forName(clazz);
            if (!clazz1.isEnum()) throw new IllegalArgumentException("Type " + clazz + " is not enum!");
            Class<T> enumType = (Class<T>) clazz1;

            Field field = enumType.getDeclaredField("TO_ID");
            field.setAccessible(true);

            Map<T, Integer> toId = (Map<T, Integer>) field.get(null);

            for (String s : mappings.keySet()) {
                T val = Enum.valueOf(enumType, s);
                toId.put(val, mappings.get(s));
            }
        } catch (Throwable t) {
            LOGGER.error("Failed to apply mappings for {}", clazz, t);
        }
    }

    public record EntityInfo(int networkId, PacketType spawnPacket) {
        public static final YamlCodec<EntityInfo> CODEC = RecordYamlCodecBuilder.mapOf(
                EntityInfo::new,
                YamlCodec.INT.fieldOf("networkId", EntityInfo::networkId),
                PacketType.CODEC.fieldOf("spawnPacket", EntityInfo::spawnPacket)
        );
    }

    public record NetworkValue(String name, int id, String type) {
        public static final YamlCodec<NetworkValue> CODEC = RecordYamlCodecBuilder.mapOf(
                NetworkValue::new,
                YamlCodec.STRING.fieldOf("name", NetworkValue::name),
                YamlCodec.INT.fieldOf("id", NetworkValue::id),
                YamlCodec.STRING.fieldOf("type", NetworkValue::type)
        );
    }
}
