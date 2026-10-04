package dev.by1337.virtualentity.api.util.geometry;

public class NumberUtil {
    public static int floor(double num) {
        final int floor = (int) num;
        return floor == num ? floor : floor - (int) (Double.doubleToRawLongBits(num) >>> 63);
    }

    public static double square(double num) {
        return num * num;
    }
}
