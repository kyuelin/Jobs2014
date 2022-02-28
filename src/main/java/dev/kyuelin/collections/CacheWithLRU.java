package dev.kyuelin.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by linken on 6/22/16.
 */
public class CacheWithLRU<K, V> {
    private final Map cache;
    private final LinkedList orderedKeys;
    private ConcurrentHashMap table;

    private final int capacity;

    public CacheWithLRU(int capacity) {
        this.capacity=capacity;
        this.cache = new HashMap<>();
        this.orderedKeys = new LinkedList<>();
    }

    public void set(K key, V value) {
        if (cache.containsKey(key)) {
            orderedKeys.remove(key);
        }
        else if (cache.size() > capacity) {
            orderedKeys.removeLast();
            cache.put(key, value);
        }
        orderedKeys.addFirst(key);
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            orderedKeys.remove(key);
            orderedKeys.addFirst(key);
            return (V) cache.get(key);
        }
        return null;
    }

}
