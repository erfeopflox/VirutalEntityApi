package dev.by1337.virtualentity.api.virtual.monster;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualMob;

public interface VirtualCreeper extends VirtualMob {
    static VirtualCreeper create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.CREEPER, VirtualCreeper.class);
    }

    boolean isPowered();

    void setPowered(boolean powered);

    int getSwellDir();

    void setSwellDir(int i);

    boolean isIgnited();

    void setIgnited(boolean ignited);

    void ignite();
}
