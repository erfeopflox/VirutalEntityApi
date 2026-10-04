package dev.by1337.virtualentity.api.virtual.monster;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualMob;

@SinceMinecraftVersion("1.20.6")
public interface VirtualBogged extends VirtualMob {
    static VirtualBogged create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.BOGGED, VirtualBogged.class);
    }

    boolean isSheared();

    void setSheared(boolean sheared);
}
