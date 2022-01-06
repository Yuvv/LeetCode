import java.util.*;

/*
 * 1094-car-pooling.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/06
 */
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[2]));
        queue.addAll(Arrays.asList(trips));
        // check
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            if (a[0] > capacity) {
                return false;
            }
            if (!queue.isEmpty()) {
                int[] b = queue.poll();
                if (b[1] >= a[2]) {
                    // not cross, add to queue
                    queue.add(b);
                } else if (a[0] + b[0] > capacity) {
                    return false;
                } else {
                    // keep cross area
                    queue.add(new int[]{a[0] + b[0], Math.max(a[1], b[1]), Math.min(a[2], b[2])});
                    // remainder area
                    if (a[2] < b[2]) {
                        b[1] = a[2];
                        queue.add(b);
                    } else if (a[2] > b[2]) {
                        a[1] = b[2];
                        queue.add(a);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.carPooling(
            new int[][] {{9,3,4},{9,1,7},{4,2,4},{7,4,5}},
            23
        ));
        // false
        System.out.println(s.carPooling(
            new int[][] {{2,1,5},{3,3,7}},
            4
        ));
        // true
        System.out.println(s.carPooling(
            new int[][] {{2,1,5},{3,3,7}},
            5
        ));
        // true
        System.out.println(s.carPooling(
            new int[][] {{3,2,7},{3,7,9},{8,3,9}},
            11
        ));
    }
}