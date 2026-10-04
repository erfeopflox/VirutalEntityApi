package dev.by1337.virtualentity.api.entity;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

@SinceMinecraftVersion("1.19.4")
public enum BillboardConstraints implements MappedEnum {
    FIXED,
    VERTICAL,
    HORIZONTAL,
    CENTER,
    ;
    public static final YamlCodec<BillboardConstraints> CODEC = YamlCodec.fromEnum(BillboardConstraints.class);
    private static final EnumMap<BillboardConstraints, Integer> TO_ID = new EnumMap<>(BillboardConstraints.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }
}
