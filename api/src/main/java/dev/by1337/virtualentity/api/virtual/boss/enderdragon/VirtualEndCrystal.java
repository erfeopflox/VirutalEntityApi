package dev.by1337.virtualentity.api.virtual.boss.enderdragon;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.util.geometry.Vec3i;
import dev.by1337.virtualentity.api.virtual.VirtualEntity;
import org.jetbrains.annotations.Nullable;

public interface VirtualEndCrystal extends VirtualEntity {
    static VirtualEndCrystal create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.END_CRYSTAL, VirtualEndCrystal.class);
    }

    @Nullable Vec3i getBeamTarget();

    void setBeamTarget(@Nullable Vec3i vec3i);

    boolean isShowBottom();

    void setShowBottom(boolean showBottom);
}
