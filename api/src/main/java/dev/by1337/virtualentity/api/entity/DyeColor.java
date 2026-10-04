package dev.by1337.virtualentity.api.entity;

import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum DyeColor implements MappedEnum {
    WHITE,
    ORANGE,
    MAGENTA,
    LIGHT_BLUE,
    YELLOW,
    LIME,
    PINK,
    GRAY,
    LIGHT_GRAY,
    CYAN,
    PURPLE,
    BLUE,
    BROWN,
    GREEN,
    RED,
    BLACK;
    public static final YamlCodec<DyeColor> CODEC = YamlCodec.fromEnum(DyeColor.class);
    private static final EnumMap<DyeColor, Integer> TO_ID = new EnumMap<>(DyeColor.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
