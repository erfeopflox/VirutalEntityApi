package dev.by1337.virtualentity.api.virtual.animal.sniffer;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.SnifferState;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualAgeableMob;

@SinceMinecraftVersion("1.19.4")
public interface VirtualSniffer extends VirtualAgeableMob {
    static VirtualSniffer create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.SNIFFER, VirtualSniffer.class);
    }

    SnifferState getState();

    void setState(SnifferState state);

    int getDropSeedAtTick();

    void setDropSeedAtTick(int tick);
}
