package dev.kyuelin.collections;

import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kennethlin on 4/29/17.
 */
public class LRUCache <K,V> {

    private final Map<K,V> cache = new HashMap<>();

    private final TreeMap<K,Instant> lrumap = new TreeMap<K, Instant>(new Comparator<K>() {
        @Override
        //todo
        public int compare(K o1, K o2) {
            return 0;
        }
    });

    private final int CAPACITY = 1000;

    public V get(K key) {
        V value = null;
        if (cache.containsKey(key)) {
            value=cache.get(key);
            lrumap.remove(key);
            lrumap.put(key, Instant.now());
        }
        else {
            value = (V) new DAService<>().find(key);
            put(key, value);
        }
        return value;
    }

    private void put(K key, V value) {
        if(cache.size()+1 >= CAPACITY) {
            lrumap.remove(lrumap.firstKey());
        }
    }

    private class DAService<K,V> {
        private V find(K k) {
            V value=null;
            return value;
        }
    }
}
