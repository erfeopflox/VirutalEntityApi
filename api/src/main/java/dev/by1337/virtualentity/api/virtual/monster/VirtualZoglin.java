package dev.by1337.virtualentity.api.virtual.monster;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualMob;

public interface VirtualZoglin extends VirtualMob {
    static VirtualZoglin create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.ZOGLIN, VirtualZoglin.class);
    }

    boolean isBaby();

    void setBaby(boolean param0);
}
