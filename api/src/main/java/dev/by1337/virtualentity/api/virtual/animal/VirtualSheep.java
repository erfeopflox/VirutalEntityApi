package dev.by1337.virtualentity.api.virtual.animal;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.DyeColor;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualAgeableMob;

public interface VirtualSheep extends VirtualAgeableMob {
    static VirtualSheep create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.SHEEP, VirtualSheep.class);
    }

    DyeColor getColor();

    void setColor(DyeColor color);

    boolean isSheared();

    void setSheared(boolean param0);
}
