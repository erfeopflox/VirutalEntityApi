package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.21.11")
public enum ZombieNautilusVariant implements MappedEnum {
    TEMPERATE,
    WARM;
    public static final YamlCodec<ZombieNautilusVariant> CODEC = YamlCodec.fromEnum(ZombieNautilusVariant.class);
    private static final EnumMap<ZombieNautilusVariant, Integer> TO_ID = new EnumMap<>(ZombieNautilusVariant.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
