package dev.by1337.virtualentity.api.virtual;

import dev.by1337.virtualentity.api.entity.EntityAnimation;
import dev.by1337.virtualentity.api.entity.EntityEvent;
import dev.by1337.virtualentity.api.entity.EquipmentSlot;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.task.TickTask;
import dev.by1337.virtualentity.api.util.geometry.Vec3d;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

public interface VirtualEntityController extends ViewTracker, Identifiable {
    void clearEquipment();

    void setEquipment(EquipmentSlot slot, @Nullable ItemStack item);

    @Nullable
    ItemStack getEquipment(EquipmentSlot slot);

    Vec3d getOldPos();

    Vec3d getPos();

    void setPos(Vec3d pos);

    byte yaw();

    byte pitch();

    byte dimensions();

    boolean isOnGround();

    void setOnGround(boolean onGround);

    UUID getUuid();

    VirtualEntityType getType();

    int getCustomEntityData();

    float getYaw();

    void setYaw(float yaw);

    float getPitch();

    void setPitch(float pitch);

    float getDimensions();

    void setDimensions(float dimensions);

    void playAnimation(EntityAnimation animation);

    void lookAt(Vec3d at);

    default void onTick() {
    }

    void sendEntityEvent(EntityEvent event);

    default void broadcastEntityEvent(EntityEvent event) {
        sendEntityEvent(event);
    }

    void respawn();

    Set<Player> getLastViewers();

    default void setNoMotion() {
        setMotion(Vec3d.ZERO);
    }

    void setMotion(Vec3d motion);

    void addTickTask(TickTask task);

    boolean removeTickTask(TickTask task);

    void removeAllTickTask();
}
