package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("26.1")
public enum PigSoundVariant implements MappedEnum {
    BIG,
    MINI,
    CLASSIC;
    public static final YamlCodec<PigSoundVariant> CODEC = YamlCodec.fromEnum(PigSoundVariant.class);
    private static final EnumMap<PigSoundVariant, Integer> TO_ID = new EnumMap<>(PigSoundVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
