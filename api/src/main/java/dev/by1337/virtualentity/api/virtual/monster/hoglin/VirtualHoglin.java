package dev.by1337.virtualentity.api.virtual.monster.hoglin;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualAgeableMob;

public interface VirtualHoglin extends VirtualAgeableMob {
    static VirtualHoglin create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.HOGLIN, VirtualHoglin.class);
    }

    boolean isImmuneToZombification();

    void setImmuneToZombification(boolean immune);
}
