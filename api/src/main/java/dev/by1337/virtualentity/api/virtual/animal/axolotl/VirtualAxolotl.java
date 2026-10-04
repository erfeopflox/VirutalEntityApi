package dev.by1337.virtualentity.api.virtual.animal.axolotl;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.AxolotVariant;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualAgeableMob;

@SinceMinecraftVersion("1.17.1")
public interface VirtualAxolotl extends VirtualAgeableMob {
    static VirtualAxolotl create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.AXOLOTL, VirtualAxolotl.class);
    }

    void setVariant(AxolotVariant variant);

    boolean isPlayingDead();

    void setPlayingDead(boolean flag);

    boolean isFromBucket();

    void setFromBucket(boolean flag);
}
