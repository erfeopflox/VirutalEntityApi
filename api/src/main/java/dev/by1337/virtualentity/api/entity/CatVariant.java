package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.19.4")
public enum CatVariant implements MappedEnum {
    RED,
    RAGDOLL,
    JELLIE,
    TABBY,
    WHITE,
    ALL_BLACK,
    BRITISH_SHORTHAIR,
    BLACK,
    SIAMESE,
    CALICO,
    PERSIAN,
    ;
    public static final YamlCodec<CatVariant> CODEC = YamlCodec.fromEnum(CatVariant.class);
    private static final EnumMap<CatVariant, Integer> TO_ID = new EnumMap<>(CatVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
