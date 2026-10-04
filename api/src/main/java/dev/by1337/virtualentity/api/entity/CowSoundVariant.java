package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("26.1")
public enum CowSoundVariant implements MappedEnum {
    MOODY,
    CLASSIC;
    public static final YamlCodec<CowSoundVariant> CODEC = YamlCodec.fromEnum(CowSoundVariant.class);
    private static final EnumMap<CowSoundVariant, Integer> TO_ID = new EnumMap<>(CowSoundVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
