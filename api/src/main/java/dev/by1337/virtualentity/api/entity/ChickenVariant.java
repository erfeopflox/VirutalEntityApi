package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.21.5")
public enum ChickenVariant implements MappedEnum {
    TEMPERATE,
    COLD,
    WARM;
    public static final YamlCodec<ChickenVariant> CODEC = YamlCodec.fromEnum(ChickenVariant.class);
    private static final EnumMap<ChickenVariant, Integer> TO_ID = new EnumMap<>(ChickenVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
