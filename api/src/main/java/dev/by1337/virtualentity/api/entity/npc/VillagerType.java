package dev.by1337.virtualentity.api.entity.npc;

import dev.by1337.virtualentity.api.entity.MappedEnum;
import dev.by1337.virtualentity.api.entity.MappedEnumUtils;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum VillagerType implements MappedEnum {
    DESERT,
    JUNGLE,
    PLAINS,
    SAVANNA,
    SNOW,
    SWAMP,
    TAIGA;
    public static final YamlCodec<VillagerType> CODEC = YamlCodec.fromEnum(VillagerType.class);
    private static final EnumMap<VillagerType, Integer> TO_ID = new EnumMap<>(VillagerType.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
