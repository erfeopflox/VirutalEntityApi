package dev.by1337.virtualentity.api.virtual.item;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualEntity;
import org.bukkit.block.data.BlockData;

public interface VirtualPrimedTnt extends VirtualEntity {
    static VirtualPrimedTnt create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.TNT, VirtualPrimedTnt.class);
    }

    int getFuse();

    void setFuse(int fuse);

    @SinceMinecraftVersion("1.20.4")
    BlockData getBlockState();

    @SinceMinecraftVersion("1.20.4")
    void setBlockState(BlockData block);
}
