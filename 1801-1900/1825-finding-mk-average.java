import java.util.*;

/*
 * 1825-finding-mk-average.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/08
 */
public class MKAverage {
    private int m;
    private int k;
    private LinkedList<Integer> mQueue;

    private SortedList minHeap;
    private SortedList midHeap;
    private SortedList maxHeap;


    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.mQueue = new LinkedList<>();
        this.minHeap = new SortedList();
        this.midHeap = new SortedList();
        this.maxHeap = new SortedList();
    }

    public void addElement(int num) {
        mQueue.offer(num);
        if (mQueue.size() > m) {
            Integer toRemove = mQueue.poll();
            if (minHeap.contains(toRemove)) {
                minHeap.remove(toRemove);
                minHeap.addElement(midHeap.removeFirst());
                midHeap.addElement(maxHeap.removeFirst());
            } else if (midHeap.contains(toRemove)) {
                midHeap.remove(toRemove);
                midHeap.addElement(maxHeap.removeFirst());
            } else {
                maxHeap.remove(toRemove);
            }
        }

        minHeap.addElement(num);
        if (minHeap.size() > k) {
            midHeap.addElement(minHeap.removeLast());
        }
        if (midHeap.size() > (m - 2 * k)) {
            maxHeap.addElement(midHeap.removeLast());
        }
    }

    public int calculateMKAverage() {
        if (mQueue.size() < m) {
            return -1;
        }
        return (int) (midHeap.sum / (m - 2 * k));
    }

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);
        obj.addElement(1);
        // -1
        System.out.println(obj.calculateMKAverage());
        obj.addElement(10);
        // 3
        System.out.println(obj.calculateMKAverage());
        obj.addElement(5);
        obj.addElement(5);
        obj.addElement(5);
        // 5
        System.out.println(obj.calculateMKAverage());
    }
}

class SortedList {
    long sum;
    int size;
    TreeMap<Integer, Integer> map;

    public SortedList() {
        this.sum = 0L;
        this.size = 0;
        this.map = new TreeMap<>();
    }

    public int size() {
        return size;
    }

    public boolean contains(Integer key) {
        return map.containsKey(key);
    }

    public Integer remove(Integer key) {
        Integer value = map.get(key);
        if (value == null) {
            return null;
        }
        if (value > 1) {
            map.put(key, value - 1);
        } else {
            map.remove(key);
        }
        sum -= key;
        size--;
        return key;
    }

    public Integer removeFirst() {
        return remove(map.firstKey());
    }

    public Integer removeLast() {
        return remove(map.lastKey());
    }

    public void addElement(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        sum += num;
        size++;
    }
}
