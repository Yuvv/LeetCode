/*
 * 0706-design-hashmap.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2018/10/25
 */
public class MyHashMap {
    static final float LOAD_FACTOR = 0.75F;
    static final int MAX_LINKLIST_LEN = 8;

    private int size;
    private Node<Integer, Integer>[] table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = (Node<Integer, Integer>[]) new Node[16];
        size = 0;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if ((size + 1.0F) / table.length > LOAD_FACTOR) {
            rehash();
        }
        int pos = key % table.length;
        Node<Integer, Integer> node = table[pos];
        if (node == null) {
            table[pos] = new Node<>(key, value);
            size++;
        } else {
            int len = 0;
            Node<Integer, Integer> prevNode = null;
            while (node != null && !node.key.equals(key)) {
                prevNode = node;
                node = node.next;
                len++;
            }
            if (node != null) {
                // find eixsted node, update value
                node.value = value;
            } else {
                prevNode.next = new Node<>(key, value);
                size++;
                len++;
                if (len > MAX_LINKLIST_LEN) {
                    rehash();
                }
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int pos = key % table.length;
        Node<Integer, Integer> node = table[pos];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int pos = key % table.length;
        Node<Integer, Integer> prevNode = null;
        Node<Integer, Integer> node = table[pos];
        while (node != null && !node.key.equals(key)) {
            prevNode = node;
            node = node.next;
        }
        if (node == null) {
            // no this key
            return;
        }
        if (prevNode == null) {
            // first node is target node
            table[pos] = node.next;
        } else {
            // otherwise, link to next one
            prevNode.next = node.next;
        }
    }

    private synchronized void rehash() {
        Node<Integer, Integer>[] originTable = table;
        table = (Node<Integer, Integer>[]) new Node[originTable.length * 2];
        size = 0;

        for (Node<Integer, Integer> node : originTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(19, 19);
        map.put(18, 18);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(18));
        System.out.println(map.get(19));

        map.put(18, 17);
        System.out.println(map.get(18));

        // --> test rehash
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(6, 5);
        map.put(7, 5);
        map.put(8, 5);
        map.put(9, 9);
        map.put(10, 5);
        map.put(11, 8);
        System.out.println(map.get(9));
        map.put(12, 8);
        map.put(13, 8);
        map.put(14, 8);

        // --> test rehash
        map.put(32 + 1, 32);
        map.put(32 * 2 + 1, 32);
        map.put(32 * 3 + 1, 32);
        map.put(32 * 4 + 1, 32);
        map.put(32 * 5 + 1, 32 * 5 + 1);
        System.out.println(map.get(32 * 5 + 1));
        map.put(32 * 6 + 1, 32);
        map.put(32 * 7 + 1, 32);
        map.put(32 * 8 + 1, 32);

        System.out.println(map.get(32 * 5 + 1));
    }
}

class Node<K, V> {
    K key;
    V value;

    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
