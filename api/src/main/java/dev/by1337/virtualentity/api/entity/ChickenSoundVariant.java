package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("26.1")
public enum ChickenSoundVariant implements MappedEnum {
    PICKY,
    CLASSIC;
    public static final YamlCodec<ChickenSoundVariant> CODEC = YamlCodec.fromEnum(ChickenSoundVariant.class);
    private static final EnumMap<ChickenSoundVariant, Integer> TO_ID = new EnumMap<>(ChickenSoundVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
