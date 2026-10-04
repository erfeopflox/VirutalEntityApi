package dev.by1337.virtualentity.api.virtual.projectile;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualEntity;
import org.bukkit.inventory.ItemStack;

public interface VirtualEyeOfEnder extends VirtualEntity {
    static VirtualEyeOfEnder create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.EYE_OF_ENDER, VirtualEyeOfEnder.class);
    }

    ItemStack getItem();

    void setItem(ItemStack itemStack);
}
