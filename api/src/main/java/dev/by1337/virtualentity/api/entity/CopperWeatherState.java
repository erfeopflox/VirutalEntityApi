package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.20.9")
public enum CopperWeatherState implements MappedEnum {
    UNAFFECTED,
    EXPOSED,
    WEATHERED,
    OXIDIZED;
    public static final YamlCodec<CopperWeatherState> CODEC = YamlCodec.fromEnum(CopperWeatherState.class);
    private static final EnumMap<CopperWeatherState, Integer> TO_ID = new EnumMap<>(CopperWeatherState.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
