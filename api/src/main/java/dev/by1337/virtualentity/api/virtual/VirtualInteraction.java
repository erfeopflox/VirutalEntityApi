package dev.by1337.virtualentity.api.virtual;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;

@SinceMinecraftVersion("1.19.4")
public interface VirtualInteraction extends VirtualEntity {
    static VirtualInteraction create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.INTERACTION, VirtualInteraction.class);
    }

    float getWidth();

    void setWidth(float width);

    float getHeight();

    void setHeight(float height);

    boolean hasResponse();

    void setResponse(boolean response);
}
