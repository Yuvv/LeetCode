/**
 * 3560-find-minimum-log-transportation-cost.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/17
 */
public class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if (n <= k && m <= k) {
            return 0L;
        }
        if (m >= n) {
            n = m;
        }
        // long cost = Long.MAX_VALUE;
        // for (long i = n-k; i<=n/2; i++) {
        //     cost = Math.min(cost, i*(n-i));
        // }
        // return cost;
        return ((long)k)*(n-k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minCuttingCost(6, 5, 5));
        // 0
        System.out.println(s.minCuttingCost(4, 4, 6));
    }
}