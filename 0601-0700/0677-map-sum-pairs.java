import java.util.*;

/*
 * 0677-map-sum-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/14
 */
public class MapSum {

    private Trie root;

    public MapSum() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        Trie node = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            node = node.nexts.computeIfAbsent(ch, k -> new Trie());
        }
        node.val = val;
    }

    public int sum(String prefix) {
        Trie node = root;
        for (int i = 0; node != null && i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            node = node.nexts.get(ch);
        }
        if (node == null) {
            return 0;
        }
        // bfs
        int sum = 0;
        LinkedList<Trie> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Trie eachNode = queue.poll();
            if (eachNode.val != null) {
                sum += eachNode.val;
            }
            queue.addAll(eachNode.nexts.values());
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        // return 3 (apple = 3)
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        // return 5 (apple + app = 3 + 2 = 5)
        System.out.println(mapSum.sum("ap"));
    }
}

// since key.length <= 50, we don't need a radix tree
class Trie {
    Integer val;
    Map<Character, Trie> nexts;

    public Trie() {
        this.nexts = new HashMap<>();
    }

    public Trie(int val) {
        this.val = val;
        this.nexts = new HashMap<>();
    }
}