package dev.by1337.virtualentity.api.virtual.animal;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;

public interface VirtualTropicalFish extends VirtualAbstractFish {
    static VirtualTropicalFish create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.TROPICAL_FISH, VirtualTropicalFish.class);
    }

    int getVariant();

    void setVariant(int variant);
}
