package dev.by1337.virtualentity.api.virtual.monster.creaking;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.util.geometry.Vec3i;
import dev.by1337.virtualentity.api.virtual.VirtualMob;
import org.jetbrains.annotations.Nullable;

@SinceMinecraftVersion("1.21.3")
public interface VirtualCreaking extends VirtualMob {
    static VirtualCreaking create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.CREAKING, VirtualCreaking.class);
    }

    boolean isIsActive();

    void setIsActive(boolean isActive);

    boolean isCanMove();

    void setCanMove(boolean canMove);

    @SinceMinecraftVersion("1.21.4")
    @Nullable Vec3i getHomePos();

    @SinceMinecraftVersion("1.21.4")
    void setHomePos(@Nullable Vec3i homePos);

    @SinceMinecraftVersion("1.21.4")
    boolean isTearingDown();

    @SinceMinecraftVersion("1.21.4")
    void setTearingDown(boolean tearingDown);
}
