package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.17.1")
public enum AxolotVariant implements MappedEnum {
    LUCY,
    WILD,
    GOLD,
    CYAN,
    BLUE,
    ;
    public static final YamlCodec<AxolotVariant> CODEC = YamlCodec.fromEnum(AxolotVariant.class);
    private static final EnumMap<AxolotVariant, Integer> TO_ID = new EnumMap<>(AxolotVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
