import java.util.*;
/**
 * 2349-design-a-number-container-system.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/15
 */
public class NumberContainers {
    private Map<Integer, TreeSet<Integer>> numMap;
    private Map<Integer, Integer> indexMap;

    public NumberContainers() {
        this.numMap = new HashMap<>();
        this.indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer oldNumber = indexMap.remove(index);
        if (oldNumber != null) {
            numMap.get(oldNumber).remove(index);
        }
        indexMap.put(index, number);
        numMap.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> indices = numMap.get(number);
        if (indices == null || indices.isEmpty()) {
            return -1; // No index found for the given number
        }
        return indices.first(); // Return the smallest index for the number
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        nc.change(1, 10);
        nc.change(2, 20);
        nc.change(3, 10);
        System.out.println(nc.find(10)); // Output: 1
        System.out.println(nc.find(20)); // Output: 2
        System.out.println(nc.find(30)); // Output: -1
    }
}