package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.20.9")
public enum CopperGolemState implements MappedEnum {
    IDLE,
    GETTING_ITEM,
    GETTING_NO_ITEM,
    DROPPING_ITEM,
    DROPPING_NO_ITEM;;
    public static final YamlCodec<CopperGolemState> CODEC = YamlCodec.fromEnum(CopperGolemState.class);
    private static final EnumMap<CopperGolemState, Integer> TO_ID = new EnumMap<>(CopperGolemState.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
