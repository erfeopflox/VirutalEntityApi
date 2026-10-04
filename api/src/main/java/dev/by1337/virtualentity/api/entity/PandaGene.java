package dev.by1337.virtualentity.api.entity;

import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum PandaGene implements MappedEnum {
    NORMAL,
    LAZY,
    WORRIED,
    PLAYFUL,
    BROWN,
    WEAK,
    AGGRESSIVE;
    public static final YamlCodec<PandaGene> CODEC = YamlCodec.fromEnum(PandaGene.class);
    private static final EnumMap<PandaGene, Integer> TO_ID = new EnumMap<>(PandaGene.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
