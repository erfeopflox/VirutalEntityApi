package dev.by1337.virtualentity.api.virtual.monster;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualMob;

public interface VirtualGuardian extends VirtualMob {
    static VirtualGuardian create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.GUARDIAN, VirtualGuardian.class);
    }

    boolean isMoving();

    void setMoving(boolean flag);

    int getActiveAttackTarget();

    void setActiveAttackTarget(int entityId);

    boolean hasActiveAttackTarget();
}
