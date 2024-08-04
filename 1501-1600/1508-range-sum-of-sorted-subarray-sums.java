import java.util.*;

/**
 * 1508-range-sum-of-sorted-subarray-sums.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/04
 */
public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] prefixSum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                pq.add(prefixSum[j] - prefixSum[i]);
            }
        }
        System.out.println(pq);
        long res = 0L;
        int i = 1;
        right = Math.min(right, pq.size());
        while (i <= right) {
            int x = pq.poll();
            if (i >= left) {
                res += x;
                res %= 1000000007L;
            }
            i++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 89
        System.out.println(s.rangeSum(new int[]{2, 16, 9, 7, 6, 9, 17, 18, 12, 2}, 10, 1, 10));
        // 13
        System.out.println(s.rangeSum(new int[]{1,2,3,4}, 4, 1, 5));
        // 13
        System.out.println(s.rangeSum(new int[]{4,3,2,1}, 4, 1, 5));
        // 6
        System.out.println(s.rangeSum(new int[]{1,2,3,4}, 4, 3, 4));
        // 50
        System.out.println(s.rangeSum(new int[]{1,2,3,4}, 4, 1, 10));
    }
}
