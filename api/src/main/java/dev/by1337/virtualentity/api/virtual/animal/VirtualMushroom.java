package dev.by1337.virtualentity.api.virtual.animal;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.MushroomType;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualAgeableMob;

public interface VirtualMushroom extends VirtualAgeableMob {
    static VirtualMushroom create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.MOOSHROOM, VirtualMushroom.class);
    }

    MushroomType getMushroomType();

    void setMushroomType(MushroomType type);
}
