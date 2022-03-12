import java.util.*;

/*
 * 0460-lfu-cache.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/12
 */
public class LFUCache {

    private int capacity;
    private Map<Integer, Node> kvMap;
    private TreeMap<Integer, LinkedHashSet<Integer>> useTimeMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.kvMap = new HashMap<>(capacity);
        this.useTimeMap = new TreeMap<>();
    }

    public int get(int key) {
        if (!kvMap.containsKey(key)) {
            return -1;
        }
        Node node = kvMap.get(key);
        accessNode(key, node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = kvMap.get(key);
        if (node == null) {
            node = new Node(value);
            if (kvMap.size() >= capacity) {
                // evict
                Map.Entry<Integer, LinkedHashSet<Integer>> entry = useTimeMap.firstEntry();
                if (entry == null) {
                    return;
                }
                Integer k = entry.getValue().iterator().next();
                entry.getValue().remove(k);
                if (entry.getValue().isEmpty()) {
                    useTimeMap.remove(entry.getKey());
                }
                kvMap.remove(k);
            }
            kvMap.put(key, node);
            useTimeMap.computeIfAbsent(node.time, k -> new LinkedHashSet<>()).add(key);
        } else {
            node.value = value;
            accessNode(key, node);
        }
    }

    private void accessNode(int key, Node node) {
        LinkedHashSet<Integer> lhs = useTimeMap.get(node.time);
        lhs.remove(key);
        if (lhs.isEmpty()) {
            useTimeMap.remove(node.time);
        }
        node.time++;
        useTimeMap.computeIfAbsent(node.time, k -> new LinkedHashSet<>()).add(key);
    }
}

class Node {
    int value;
    int time;

    public Node(int v) {
        this.value = v;
        this.time = 1;
    }
}
