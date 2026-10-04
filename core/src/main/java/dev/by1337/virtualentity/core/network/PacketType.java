package dev.by1337.virtualentity.core.network;

import dev.by1337.virtualentity.api.entity.MappedEnum;
import dev.by1337.virtualentity.api.entity.MappedEnumUtils;
import dev.by1337.yaml.codec.YamlCodec;

import java.util.EnumMap;

public enum PacketType implements MappedEnum {
    SET_ENTITY_DATA_PACKET,
    ANIMATE_PACKET,
    ROTATE_HEAD_PACKET,
    TELEPORT_ENTITY_PACKET,
    ADD_ENTITY_PACKET,
    REMOVE_ENTITIES_PACKET,
    SET_EQUIPMENT_PACKET,
    MOVE_ENTITY_PACKET_POS,
    MOVE_ENTITY_PACKET_POS_ROT,
    MOVE_ENTITY_PACKET_ROT,
    SET_ENTITY_MOTION_PACKET,
    SET_PLAYER_TEAM_PACKET,
    ENTITY_EVENT_PACKET,

    REMOVE_PLAYER_PACKET,

    UPDATE_PLAYER_INFO_PACKET,

    ENTITY_POSITION_SYNC_PACKET;
    public static final YamlCodec<PacketType> CODEC = YamlCodec.fromEnum(PacketType.class);
    private static final EnumMap<PacketType, Integer> TO_ID = new EnumMap<>(PacketType.class);

    @Override
    public int getId() {
        return MappedEnumUtils.getId(this, TO_ID);
    }

    public int getId(int def) {
        return MappedEnumUtils.getIdOr(this, TO_ID, def);
    }
}
