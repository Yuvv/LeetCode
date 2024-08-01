import java.util.*;

/**
 * 3066-minimum-operations-to-exceed-threshold-value-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/01
 */
public class Solution {
    public int minOperations(int[] nums, int k) {
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minLEK = -1;
        for (int n : nums) {
            if (n < k) {
                pq.add(n);
            } else if (minLEK < 0 || minLEK > n) {
                minLEK = n;
            }
        }
        if (minLEK >= 0) {
            pq.add(minLEK);
        }
        while (pq.size() >= 2 && pq.peek() < k) {
            int a = pq.poll();
            int b = pq.poll();
            if (Integer.MAX_VALUE - a - b < a) {
                pq.add(Integer.MAX_VALUE);
            } else {
                pq.add(a*2+b);
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minOperations(new int[] {2,11,10,1,3}, 10));
        // 4
        System.out.println(s.minOperations(new int[] {1,1,2,4,9}, 20));
    }
}
