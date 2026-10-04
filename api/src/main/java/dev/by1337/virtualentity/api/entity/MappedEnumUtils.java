package dev.by1337.virtualentity.api.entity;


import org.bukkit.Bukkit;

import java.util.Map;

public class MappedEnumUtils {

    public static <T extends Enum<T>> int getId(T value, Map<T, Integer> map) {
        Integer id = map.get(value);
        if (id == null) {
            throw new IllegalStateException("Unable to serialize value " + value + " on version " + Bukkit.getVersion());
        }
        return id;
    }

    public static <T extends Enum<T>> int getIdOr(T value, Map<T, Integer> map, int def) {
        Integer id = map.get(value);
        if (id == null) {
            return def;
        }
        return id;
    }
}
