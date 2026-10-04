package dev.by1337.virtualentity.api.virtual.display;

import dev.by1337.virtualentity.api.annotations.SinceMinecraftVersion;
import dev.by1337.virtualentity.api.entity.BillboardConstraints;
import dev.by1337.virtualentity.api.util.Transformation;
import dev.by1337.virtualentity.api.virtual.VirtualEntity;
import org.bukkit.Color;
import org.jetbrains.annotations.Nullable;

@SinceMinecraftVersion("1.19.4")
public interface VirtualDisplay extends VirtualEntity {

    @SinceMinecraftVersion("1.20.4")
    int getPosRotInterpolationDuration();

    @SinceMinecraftVersion("1.20.4")
    void setPosRotInterpolationDuration(int i);

    void setTransformation(Transformation transformation);

    // in 1.20.4 renamed to getTransformationInterpolationDuration
    int getInterpolationDuration();

    // in 1.20.4 renamed to setTransformationInterpolationDuration
    void setInterpolationDuration(int i);

    int getTransformationInterpolationDuration();

    void setTransformationInterpolationDuration(int i);

    // in 1.20.4 renamed to getTransformationInterpolationDelay
    int getInterpolationDelay();

    // in 1.20.4 renamed to setTransformationInterpolationDelay
    void setInterpolationDelay(int i);

    int getTransformationInterpolationDelay();

    void setTransformationInterpolationDelay(int i);

    void setBillboardConstraints(BillboardConstraints billboardConstraints);

    void setBrightnessOverride(int block, int sky);

    int getPackedBrightnessOverride();

    float getViewRange();

    void setViewRange(float f);

    float getShadowRadius();

    void setShadowRadius(float f);

    float getShadowStrength();

    void setShadowStrength(float f);

    float getWidth();

    void setWidth(float f);

    @Nullable Color getGlowColorOverride();

    void setGlowColorOverride(@Nullable Color color, int alpha);

    float getHeight();

    void setHeight(float f);
}
