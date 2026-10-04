package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.19.4")
public enum FrogVariant implements MappedEnum {
    TEMPERATE,
    COLD,
    WARM;

    public static final YamlCodec<FrogVariant> CODEC = YamlCodec.fromEnum(FrogVariant.class);
    private static final EnumMap<FrogVariant, Integer> TO_ID = new EnumMap<>(FrogVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
