package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.21.5")
public enum WolfSoundVariant implements MappedEnum {
    BIG,
    SAD,
    ANGRY,
    CUTE,
    PUGLIN,
    CLASSIC,
    GRUMPY,
    ;
    public static final YamlCodec<WolfSoundVariant> CODEC = YamlCodec.fromEnum(WolfSoundVariant.class);
    private static final EnumMap<WolfSoundVariant, Integer> TO_ID = new EnumMap<>(WolfSoundVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
