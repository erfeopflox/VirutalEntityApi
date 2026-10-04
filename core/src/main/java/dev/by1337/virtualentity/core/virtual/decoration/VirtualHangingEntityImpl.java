package dev.by1337.virtualentity.core.virtual.decoration;

import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.util.geometry.Direction;
import dev.by1337.virtualentity.core.mappings.Mappings;
import dev.by1337.virtualentity.core.syncher.EntityDataAccessor;
import dev.by1337.virtualentity.core.virtual.VirtualEntityImpl;

public class VirtualHangingEntityImpl extends VirtualEntityImpl implements dev.by1337.virtualentity.api.virtual.decoration.VirtualHangingEntityImpl {
    private static final EntityDataAccessor<Direction> DATA_DIRECTION;

    static {
        DATA_DIRECTION = Mappings.findAccessor("HangingEntity", "DATA_DIRECTION");
    }

    public VirtualHangingEntityImpl(VirtualEntityType type) {
        super(type);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_DIRECTION, Direction.SOUTH);
    }

    @Override
    public Direction getDirection() {
        return entityData.get(DATA_DIRECTION);
    }

    @Override
    public void setDirection(Direction direction) {
        entityData.set(DATA_DIRECTION, direction);
    }
}
