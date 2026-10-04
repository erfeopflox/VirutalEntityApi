package dev.by1337.virtualentity.api.virtual.animal.camel;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;

@SinceMinecraftVersion("1.19.4")
public interface VirtualCamel extends dev.by1337.virtualentity.api.virtual.animal.horse.VirtualAbstractHorse {
    static VirtualCamel create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.CAMEL, VirtualCamel.class);
    }

    boolean isDashing();

    void setDashing(boolean flag);

    long getLastPoseChangeTick();

    void setLastPoseChangeTick(long tick);
}
