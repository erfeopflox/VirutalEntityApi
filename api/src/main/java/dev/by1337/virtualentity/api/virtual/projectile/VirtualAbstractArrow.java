package dev.by1337.virtualentity.api.virtual.projectile;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.virtual.VirtualEntity;

public interface VirtualAbstractArrow extends VirtualEntity {
    boolean isCritArrow();

    void setCritArrow(boolean flag);

    byte getPierceLevel();

    void setPierceLevel(byte value);

    boolean isNoPhysics();

    void setNoPhysics(boolean param0);

    boolean isShotFromCrossbow();

    void setShotFromCrossbow(boolean flag);

    @SinceMinecraftVersion("1.12.3")
    boolean isInGround();

    @SinceMinecraftVersion("1.12.3")
    void setInGround(boolean inGround);
}
