/**
 * 2929-distribute-candies-among-children-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/06
 */
public class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0L;
        for (int i = Math.max(0, n - limit*2); i <= Math.min(limit, n); i++) {
            int ub = Math.min(n-i, limit);
            int lb = Math.max(0, n-i-limit);
            if (ub >= lb) {
                res += ub - lb + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.distributeCandies(5, 2));
        // 10
        System.out.println(s.distributeCandies(3, 3));
    }
}