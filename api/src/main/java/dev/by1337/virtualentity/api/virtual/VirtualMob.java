package dev.by1337.virtualentity.api.virtual;

public interface VirtualMob extends VirtualLivingEntity {
    boolean isNoAi();

    void setNoAi(boolean flag);

    boolean isLeftHanded();

    void setLeftHanded(boolean flag);

    boolean isAggressive();

    void setAggressive(boolean flag);
}
