package dev.by1337.virtualentity.api.virtual.monster;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualMob;
import org.bukkit.block.data.BlockData;

import javax.annotation.Nullable;

public interface VirtualEnderman extends VirtualMob {
    static VirtualEnderman create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.ENDERMAN, VirtualEnderman.class);
    }

    @Nullable
    BlockData getCarriedBlock();

    void setCarriedBlock(@Nullable BlockData param0);

    boolean isCreepy();

    void setCreepy(boolean flag);

    boolean hasBeenStaredAt();

    void setBeingStaredAt();
}
