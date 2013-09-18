package ru.vmsoftware.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Vyacheslav Mayorov
 * @since 2013-19-09
 */
public class CollectionInitializer {


    public static class MapInitializer<K,V> {

        private Map<K,V> map;

        private MapInitializer(Map<K,V> map) {
            this.map = map;
        }

        /**
         * Associates specified key with specified value
         * @param key key to associate
         * @param value value to associate
         * @return map initializer
         * @see Map#put(Object, Object)
         */
        public MapInitializer<K,V> put(K key, V value) {
            this.map.put(key, value);
            return this;
        }

        /**
         * Makes initialized map read-only.
         * After this call any operation which modifies map will throw {@link UnsupportedOperationException}
         * @return map initializer
         */
        public MapInitializer<K,V> readOnly() {
            this.map = Collections.unmodifiableMap(this.map);
            return this;
        }

        /**
         * Returns initialized map
         * @return initialized map
         */
        public Map<K,V> get() {
            return map;
        }

    }

    /**
     * Creates new initializer for specified {@link LinkedHashMap} instance
     * @param <K> key type
     * @param <V> value type
     * @return new {@link MapInitializer}
     */
    public static <K,V> MapInitializer<K,V> linkedHashMap() {
        return new MapInitializer<K, V>(new LinkedHashMap<K, V>());
    }

    /**
     * Creates new initializer for new {@link HashMap} instance
     * @param <K> key type
     * @param <V> value type
     * @return new {@link MapInitializer}
     */
    public static <K,V> MapInitializer<K,V> hashMap() {
        return new MapInitializer<K, V>(new HashMap<K, V>());
    }

    /**
     * Creates new initializer for specified {@link Map} instance
     * @param map map to initialize
     * @param <K> key type
     * @param <V> value type
     * @return new {@link MapInitializer}
     */
    public static <K,V> MapInitializer<K,V> map(Map<K,V> map) {
        return new MapInitializer<K,V>(map);
    }

}
