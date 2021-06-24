/*
 * 0440-k-th-smallest-in-lexicographical-order.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/23
 */
public class Solution {
    public int findKthNumber(int n, int k) {
        long rank = 1;
        long num = 1;
        while (rank < k) {
            // cnt means each level count
            long cnt = 0;
            for (long cur = num, next = cur + 1; cur <= n; cur *= 10, next *= 10) {
                cnt += Math.min(next, n + 1) - cur;
            }
            if (rank + cnt <= k) {
                num++;
                rank += cnt;
            } else {
                num *= 10;
                rank++;
            }
        }
        return (int) num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 10
        System.out.println(s.findKthNumber(13, 2));
        // 1
        System.out.println(s.findKthNumber(1, 1));
        // 7
        System.out.println(s.findKthNumber(8, 7));
        // 1108
        System.out.println(s.findKthNumber(8396, 123));
        // 416126219
        System.out.println(s.findKthNumber(681692778, 351251360));
    }
}