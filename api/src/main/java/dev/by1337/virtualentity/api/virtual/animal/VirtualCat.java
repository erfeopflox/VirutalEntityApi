package dev.by1337.virtualentity.api.virtual.animal;

import dev.by1337.virtualentity.api.VirtualEntityApi;
import dev.by1337.virtualentity.api.annotations.RemovedInMinecraftVersion;
import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.CatSoundVariant;
import dev.by1337.virtualentity.api.entity.CatVariant;
import dev.by1337.virtualentity.api.entity.DyeColor;
import dev.by1337.virtualentity.api.entity.VirtualEntityType;

public interface VirtualCat extends VirtualTamableAnimal {
    static VirtualCat create() {
        return VirtualEntityApi.getFactory().create(VirtualEntityType.CAT, VirtualCat.class);
    }

    @RemovedInMinecraftVersion("1.19.4")
    int getCatType();

    @RemovedInMinecraftVersion("1.19.4")
    void setCatType(int type);

    boolean isLying();

    void setLying(boolean flag);

    boolean isRelaxStateOne();

    void setRelaxStateOne(boolean flag);

    DyeColor getCollarColor();

    void setCollarColor(DyeColor dyeColor);

    @SinceMinecraftVersion("1.19.4")
    CatVariant getVariant();

    @SinceMinecraftVersion("1.19.4")
    void setVariant(CatVariant variant);

    @SinceMinecraftVersion("26.1")
    CatSoundVariant getSoundVariant();

    @SinceMinecraftVersion("26.1")
    void setSoundVariant(CatSoundVariant variant);
}
