package dev.by1337.virtualentity.api.virtual.animal.horse;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;

public interface VirtualHorse extends VirtualAbstractHorse {
    static VirtualLlama create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.LLAMA, VirtualLlama.class);
    }

    int getTypeVariant();

    void setTypeVariant(int typeVariant);
}
