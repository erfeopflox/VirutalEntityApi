package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.21.5")
public enum CowVariant implements MappedEnum {
    TEMPERATE,
    COLD,
    WARM;
    public static final YamlCodec<CowVariant> CODEC = YamlCodec.fromEnum(CowVariant.class);
    private static final EnumMap<CowVariant, Integer> TO_ID = new EnumMap<>(CowVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
