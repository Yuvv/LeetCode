import java.util.*;

/**
 * 0786-k-th-smallest-prime-fraction.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/01
 */
public class Solution {
    // this is O(n^2), can be better
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]];
        });
        for (int i = 1; i < arr.length; i++) {
            pq.add(new int[]{0, i});
        }

        int[] res = new int[2];
        while (k > 0) {
            int[] pair = pq.poll();
            res[0] = arr[pair[0]];
            res[1] = arr[pair[1]];
            if (pair[1] - pair[0] > 1) {
                pair[0]++;
                pq.add(pair);
            }
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [2,5]
        System.out.println(Arrays.toString(s.kthSmallestPrimeFraction(new int[] {1,2,3,5}, 3)));
        // [1,7]
        System.out.println(Arrays.toString(s.kthSmallestPrimeFraction(new int[] {1,7}, 1)));
    }
}