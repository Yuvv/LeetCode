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


class AnotherLRUCache {
    int size;
    LRUCacheNode[] nodes;
    LRUCacheNode head;
    LRUCacheNode tail;

    public AnotherLRUCache(int capacity) {
        this.size = 0;
        this.nodes = new LRUCacheNode[capacity];
    }

    private void accessNode(LRUCacheNode node) {
        if (node == head) {
            return;
        } else if (node == tail) {
            head = tail;
            tail = tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = head.prev;
            node.next = head;
            tail.next = node;
            head = node;
        }
    }

    private void evictOne() {
        LRUCacheNode node = tail;
        tail.prev.next = tail.next;
        tail.next.prev = tail.prev;
        tail = tail.prev;

        int idx = node.key % nodes.length;
        LRUCacheNode prevNode = null;
        LRUCacheNode cursor = nodes[idx];

        while (cursor != null && cursor != node) {
            prevNode = cursor;
            cursor = cursor.bottom;
        }
        if (prevNode == null) {
            nodes[idx] = node.bottom;
        } else {
            prevNode.bottom = node.bottom;
        }

        this.size--;
    }

    public int get(int k) {
        int idx = k % nodes.length;
        LRUCacheNode node = nodes[idx];
        while (node != null && node.key != k) {
            node = node.bottom;
        }
        if (node == null) {
            return -1;
        }
        accessNode(node);
        return node.value;
    }

    public void put(int k, int v) {
        int idx = k % nodes.length;
        if (size == 0) {
            LRUCacheNode nNode = new LRUCacheNode(k, v);
            nodes[idx] = nNode;
            head = nNode;
            tail = nNode;
            // make a ring
            head.next = tail;
            head.prev = tail;
            this.size++;
            return;
        }

        LRUCacheNode node = nodes[idx];
        while (node != null && node.key != k) {
            node = node.bottom;
        }
        if (node == null) {
            if (this.size >= nodes.length) {
                // evict least recently used node
                evictOne();
            }
            LRUCacheNode nNode = new LRUCacheNode(k, v);
            this.size++;
            // just put it at first place
            nNode.bottom = nodes[idx];
            nodes[idx] = nNode;
            // link to head
            head.prev.next = nNode;
            nNode.prev = head.prev;
            nNode.next = head;
            head = nNode;
        } else {
            node.value = v;
            accessNode(node);
        }
    }
}

class LRUCacheNode {
    int key;
    int value;

    LRUCacheNode prev;
    LRUCacheNode next;

    LRUCacheNode bottom;

    public LRUCacheNode(int k, int v) {
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString() {
        return "[" + key + "->" + value + "]";
    }
}