package dev.by1337.virtualentity.api.virtual;


import dev.by1337.virtualentity.api.util.geometry.Direction;

public interface VirtualHangingEntity extends VirtualEntity {
    void setDirection(Direction direction);

    Direction direction();
}
