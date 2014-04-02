package de.kimminich.pitfalls;

import java.util.*;

public class MapUtils {

    public static <K, V> Map<K, List<V>> asSingleKeyMap(K key, V... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Invalid parameter: " + Arrays.asList(values));
        }
        Map<K, List<V>> result = new HashMap<>();
        result.put(key, Arrays.asList(values));
        return Collections.unmodifiableMap(result);
    }

}
