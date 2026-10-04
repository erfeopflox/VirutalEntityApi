package dev.by1337.virtualentity.api.entity;

import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum InteractionHand implements MappedEnum {
    MAIN_HAND,
    OFF_HAND;
    public static final YamlCodec<InteractionHand> CODEC = YamlCodec.fromEnum(InteractionHand.class);
    private static final EnumMap<InteractionHand, Integer> TO_ID = new EnumMap<>(InteractionHand.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
