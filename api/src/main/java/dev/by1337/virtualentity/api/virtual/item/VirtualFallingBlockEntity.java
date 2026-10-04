package dev.by1337.virtualentity.api.virtual.item;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.util.geometry.Vec3i;
import dev.by1337.virtualentity.api.virtual.VirtualEntity;
import org.bukkit.block.data.BlockData;

public interface VirtualFallingBlockEntity extends VirtualEntity {
    static VirtualFallingBlockEntity create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.FALLING_BLOCK, VirtualFallingBlockEntity.class);
    }

    Vec3i getStartPos();

    void setStartPos(Vec3i vec3i);

    void setBlockType(BlockData block);
}
