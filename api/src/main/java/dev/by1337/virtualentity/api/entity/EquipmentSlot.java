package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum EquipmentSlot implements MappedEnum {
    MAINHAND,
    OFFHAND,
    FEET,
    LEGS,
    CHEST,
    HEAD,
    @SinceMinecraftVersion("1.20.6")
    BODY,
    @SinceMinecraftVersion("1.21.5")
    SADDLE;
    public static final YamlCodec<EquipmentSlot> CODEC = YamlCodec.fromEnum(EquipmentSlot.class);
    private static final EnumMap<EquipmentSlot, Integer> TO_ID = new EnumMap<>(EquipmentSlot.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
