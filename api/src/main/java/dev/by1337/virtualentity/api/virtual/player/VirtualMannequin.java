package dev.by1337.virtualentity.api.virtual.player;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@SinceMinecraftVersion("1.21.9")
public interface VirtualMannequin extends VirtualAvatar {
    static VirtualMannequin create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.MANNEQUIN, VirtualMannequin.class);
    }

    boolean isImmovable();

    void setImmovable(boolean immovable);

    Optional<Component> getDescription();

    void setDescription(@Nullable Component description);
}
