package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.20.6")
public enum ArmadilloState implements MappedEnum {
    IDLE,
    ROLLING,
    SCARED,
    UNROLLING;
    public static final YamlCodec<ArmadilloState> CODEC = YamlCodec.fromEnum(ArmadilloState.class);
    private static final EnumMap<ArmadilloState, Integer> TO_ID = new EnumMap<>(ArmadilloState.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
