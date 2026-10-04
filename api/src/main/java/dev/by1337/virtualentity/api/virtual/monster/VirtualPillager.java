package dev.by1337.virtualentity.api.virtual.monster;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.raid.VirtualRaider;

public interface VirtualPillager extends VirtualRaider {
    static VirtualPillager create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.PILLAGER, VirtualPillager.class);
    }

    boolean isChargingCrossbow();

    void setChargingCrossbow(boolean flag);
}
