package dev.by1337.virtualentity.api.virtual.animal;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.RemovedInMinecraftVersion;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.util.geometry.Vec3i;
import dev.by1337.virtualentity.api.virtual.VirtualAgeableMob;

public interface VirtualDolphin extends VirtualAgeableMob {
    static VirtualDolphin create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.DOLPHIN, VirtualDolphin.class);
    }

    @Deprecated
    @RemovedInMinecraftVersion("1.21.5")
    Vec3i getTreasurePos();

    @Deprecated
    @RemovedInMinecraftVersion("1.21.5")
    void setTreasurePos(Vec3i pos);

    boolean gotFish();

    void setGotFish(boolean flag);

    int getMoistnessLevel();

    void setMoisntessLevel(int level);

    @Override
    @SinceMinecraftVersion("1.21.3")
    boolean isBaby();

    @Override
    @SinceMinecraftVersion("1.21.3")
    void setBaby(boolean flag);
}
