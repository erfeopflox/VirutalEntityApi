package dev.by1337.virtualentity.api.virtual.decoration;


import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.util.geometry.Vec3f;
import dev.by1337.virtualentity.api.virtual.VirtualLivingEntity;

public interface VirtualArmorStand extends VirtualLivingEntity {

    static VirtualArmorStand create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.ARMOR_STAND, VirtualArmorStand.class);
    }

    boolean isSmall();

    void setSmall(boolean flag);

    boolean isShowArms();

    void setShowArms(boolean flag);

    boolean isNoBasePlate();

    void setNoBasePlate(boolean flag);

    boolean isMarker();

    void setMarker(boolean flag);

    Vec3f getHeadPose();

    void setHeadPose(Vec3f pos);

    Vec3f getBodyPose();

    void setBodyPose(Vec3f pos);

    Vec3f getLeftArmPose();

    void setLeftArmPose(Vec3f pos);

    Vec3f getRightArmPose();

    void setRightArmPose(Vec3f pos);

    Vec3f getLeftLegPose();

    void setLeftLegPose(Vec3f pos);

    Vec3f getRightLegPose();

    void setRightLegPose(Vec3f pos);
}
