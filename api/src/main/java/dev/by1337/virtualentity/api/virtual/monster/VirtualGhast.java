package dev.by1337.virtualentity.api.virtual.monster;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualMob;

public interface VirtualGhast extends VirtualMob {
    static VirtualGhast create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.GHAST, VirtualGhast.class);
    }

    boolean isCharging();

    void setCharging(boolean param0);
}
