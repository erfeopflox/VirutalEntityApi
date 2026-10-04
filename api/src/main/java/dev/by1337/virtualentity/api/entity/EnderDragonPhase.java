package dev.by1337.virtualentity.api.entity;

import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum EnderDragonPhase implements MappedEnum {
    HOLDING_PATTERN,
    STRAFE_PLAYER,
    LANDING_APPROACH,
    LANDING,
    TAKEOFF,
    SITTING_FLAMING,
    SITTING_SCANNING,
    SITTING_ATTACKING,
    CHARGING_PLAYER,
    DYING,
    HOVERING;
    public static final YamlCodec<EnderDragonPhase> CODEC = YamlCodec.fromEnum(EnderDragonPhase.class);
    private static final EnumMap<EnderDragonPhase, Integer> TO_ID = new EnumMap<>(EnderDragonPhase.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
