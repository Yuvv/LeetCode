import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 0907-sum-of-subarray-minimums.java
 *
 * @date 2024/1/20
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    private static long MOD = 1000000007L;

    // AC but only beats 8.79%
    public int sumSubarrayMins_using_tree(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[] { arr[i], i });
        }
        treeMap.put(0, arr.length - 1);

        long res = 0L;
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            Map.Entry<Integer, Integer> entry = treeMap.lowerEntry(item[1] + 1);
            if (entry == null) {
                System.out.println(treeMap);
                System.out.println("item0=" + item[0] + ", item1=" + item[1]);
                throw new IllegalStateException("entry should not be null");
            }
            treeMap.remove(entry.getKey());
            res += ((long) item[0]) * (item[1] - entry.getKey() + 1) * (entry.getValue() - item[1] + 1);
            res %= MOD;
            if (entry.getKey() < item[1]) {
                treeMap.put(entry.getKey(), item[1] - 1);
            }
            if (entry.getValue() > item[1]) {
                treeMap.put(item[1] + 1, entry.getValue());
            }
        }

        return (int) res;
    }

    public int sumSubarrayMins(int[] arr) {
        int[][] ranges = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            ranges[i][0] = 0;
            ranges[i][1] = arr.length - 1;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { // use >= for max range
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ranges[i][0] = stack.peek() + 1;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ranges[i][1] = stack.peek() - 1;
            }
            stack.push(i);
        }

        long res = 0L;
        for (int i = 0; i < ranges.length; i++) {
            res += ((long) arr[i]) * (i - ranges[i][0] + 1) * (ranges[i][1] - i + 1);
            res %= MOD;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 444
        System.out.println(s.sumSubarrayMins(new int[] { 11, 81, 94, 43, 3 }));
        // 17
        System.out.println(s.sumSubarrayMins(new int[] { 3, 1, 2, 4 }));
    }
}
