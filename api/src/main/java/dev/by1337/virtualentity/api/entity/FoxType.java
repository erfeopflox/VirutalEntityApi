package dev.by1337.virtualentity.api.entity;

import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum FoxType implements MappedEnum {
    RED,
    SNOW;
    public static final YamlCodec<FoxType> CODEC = YamlCodec.fromEnum(FoxType.class);
    private static final EnumMap<FoxType, Integer> TO_ID = new EnumMap<>(FoxType.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
