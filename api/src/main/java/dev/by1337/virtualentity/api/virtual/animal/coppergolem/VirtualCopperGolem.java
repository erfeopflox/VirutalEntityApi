package dev.by1337.virtualentity.api.virtual.animal.coppergolem;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.CopperGolemState;
import dev.by1337.virtualentity.api.entity.CopperWeatherState;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;
import dev.by1337.virtualentity.api.virtual.VirtualMob;

@SinceMinecraftVersion("1.21.9")
public interface VirtualCopperGolem extends VirtualMob {
    static VirtualCopperGolem create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.COPPER_GOLEM, VirtualCopperGolem.class);
    }

    CopperWeatherState getWeatherState();

    void setWeatherState(CopperWeatherState weatherState);

    CopperGolemState getGolemState();

    void setGolemState(CopperGolemState golemState);
}
