package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.19.4")
public enum SnifferState implements MappedEnum {
    IDLING,
    FEELING_HAPPY,
    SCENTING,
    SNIFFING,
    SEARCHING,
    DIGGING,
    RISING;
    public static final YamlCodec<SnifferState> CODEC = YamlCodec.fromEnum(SnifferState.class);
    private static final EnumMap<SnifferState, Integer> TO_ID = new EnumMap<>(SnifferState.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
