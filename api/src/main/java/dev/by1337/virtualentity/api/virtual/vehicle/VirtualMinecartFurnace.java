package dev.by1337.virtualentity.api.virtual.vehicle;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;

public interface VirtualMinecartFurnace extends VirtualAbstractMinecart {
    static VirtualMinecartFurnace create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.FURNACE_MINECART, VirtualMinecartFurnace.class);
    }

    boolean hasFuel();

    void setFuel(boolean hasFuel);
}
