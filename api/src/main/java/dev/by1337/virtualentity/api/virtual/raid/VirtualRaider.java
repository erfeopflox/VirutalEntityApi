package dev.by1337.virtualentity.api.virtual.raid;

import dev.by1337.virtualentity.api.virtual.VirtualMob;

public interface VirtualRaider extends VirtualMob {
    boolean isCelebrating();

    void setCelebrating(boolean flag);
}
