package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("26.1")
public enum CatSoundVariant implements MappedEnum {
    CLASSIC,
    ROYAL;
    public static final YamlCodec<CatSoundVariant> CODEC = YamlCodec.fromEnum(CatSoundVariant.class);
    private static final EnumMap<CatSoundVariant, Integer> TO_ID = new EnumMap<>(CatSoundVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
