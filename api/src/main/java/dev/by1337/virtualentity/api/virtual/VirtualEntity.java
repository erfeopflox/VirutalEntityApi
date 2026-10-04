package dev.by1337.virtualentity.api.virtual;


import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.Pose;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;


public interface VirtualEntity extends VirtualEntityController {
    boolean isSilent();

    void setSilent(boolean flag);

    boolean isNoGravity();

    void setNoGravity(boolean flag);

    int getAirSupply();

    void setAirSupply(int airSupply);

    @Nullable
    Component getCustomName();

    void setCustomName(@Nullable Component customName);

    boolean hasCustomName();

    boolean isCustomNameVisible();

    void setCustomNameVisible(boolean flag);

    boolean isGlowing();

    void setGlowing(boolean b);

    boolean isShiftKeyDown();

    void setShiftKeyDown(boolean flag);

    boolean isCrouching();

    boolean isSprinting();

    void setSprinting(boolean flag);

    boolean isSwimming();

    void setSwimming(boolean flag);

    boolean isInvisible();

    void setInvisible(boolean flag);

    Pose getPose();

    void setPose(Pose pose);

    @SinceMinecraftVersion("1.17.1")
    int getTicksFrozen();

    @SinceMinecraftVersion("1.17.1")
    void setTicksFrozen(int ticks);
}
