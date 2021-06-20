import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * 0146-lru-cache.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/20
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;
    private LinkedHashSet<Integer> useList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.useList = new LinkedHashSet<>();
    }

    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) {
            return -1;
        }
        accessKey(key);
        return value;
    }

    public void put(int key, int value) {
        cache.put(key, value);
        accessKey(key);
        if (cache.size() > capacity) {
            // evict
            Integer evictValue = useList.iterator().next();
            useList.remove(evictValue);
            cache.remove(evictValue);
        }
    }

    private void accessKey(Integer key) {
        useList.remove(key);
        useList.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */