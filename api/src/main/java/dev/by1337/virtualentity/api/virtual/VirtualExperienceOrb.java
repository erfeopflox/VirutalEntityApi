package dev.by1337.virtualentity.api.virtual;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;

public interface VirtualExperienceOrb extends VirtualEntity {
    static VirtualExperienceOrb create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.EXPERIENCE_ORB, VirtualExperienceOrb.class);
    }

    int value();

    void setValue(int value);
}
