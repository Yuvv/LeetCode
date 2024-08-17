/**
 * 1937-maximum-number-of-points-with-cost.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/17
 */
public class Solution {
    public long maxPoints(int[][] points) {
        long[][] dp = new long[points.length][points[0].length];
        for (int i = 0; i < points[0].length; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                long max = dp[i-1][0] - j;
                for (int k = 1; k < points[i].length; k++) {
                    max = Math.max(max, dp[i-1][k] - Math.abs(k - j));
                }
                dp[i][j] = max + points[i][j];
            }
        }
        long max = dp[dp.length-1][0];
        for (int i = 1; i < dp[dp.length-1].length; i++) {
            max = Math.max(max, dp[dp.length-1][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.maxPoints(new int[][]{
            {1,2,3}, {1,5,1}, {3,1,1}
        }));
        // 11
        System.out.println(s.maxPoints(new int[][]{
            {1,5}, {2,3}, {4,2}
        }));
    }
}
