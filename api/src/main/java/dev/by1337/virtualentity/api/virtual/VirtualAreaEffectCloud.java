package dev.by1337.virtualentity.api.virtual;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.RemovedInMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.particles.ParticleOptions;
import org.bukkit.Color;

public interface VirtualAreaEffectCloud extends VirtualEntity {
    static VirtualAreaEffectCloud create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.AREA_EFFECT_CLOUD, VirtualAreaEffectCloud.class);
    }

    @RemovedInMinecraftVersion("1.20.6")
    Color getColor();

    @RemovedInMinecraftVersion("1.20.6")
    void setColor(Color color);

    float getRadius();

    void setRadius(float radius);

    boolean isWaiting();

    void setWaiting(boolean waiting);

    ParticleOptions<?> getParticle();

    void setParticle(ParticleOptions<?> particle);
}
