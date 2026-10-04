package dev.by1337.virtualentity.api.entity;

import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum IllagerSpell implements MappedEnum {
    NONE,
    SUMMON_VEX,
    FANGS,
    WOLOLO,
    DISAPPEAR,
    BLINDNESS;
    public static final YamlCodec<IllagerSpell> CODEC = YamlCodec.fromEnum(IllagerSpell.class);
    private static final EnumMap<IllagerSpell, Integer> TO_ID = new EnumMap<>(IllagerSpell.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
