package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.20.6")
public enum WolfVariant implements MappedEnum {
    SNOWY,
    ASHEN,
    STRIPED,
    SPOTTED,
    WOODS,
    BLACK,
    CHESTNUT,
    RUSTY,
    PALE,
    ;
    public static final YamlCodec<WolfVariant> CODEC = YamlCodec.fromEnum(WolfVariant.class);
    private static final EnumMap<WolfVariant, Integer> TO_ID = new EnumMap<>(WolfVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
