package de.kimminich.pitfalls;

import java.util.*;

public class MapUtilsFixed {

    public static <K, V> Map<K, List<V>> asSingleKeyMap(K key, V... values) {
        if (values == null || values.length == 0) {
            // Arrays.asList(null) would cause a NullPointerException while Arrays.toString(null) safely returns "null"
            throw new IllegalArgumentException("Invalid parameter: " + Arrays.toString(values));
        }
        Map<K, List<V>> result = new HashMap<>();
        result.put(key, Arrays.asList(values));
        return Collections.unmodifiableMap(result);
    }

}
