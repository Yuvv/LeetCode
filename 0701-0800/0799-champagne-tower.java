/**
 * 0799-champagne-tower
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/28
 */
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][];
        dp[0] = new double[] { poured };
        for (int i = 1; i <= query_row; i++) {
            dp[i] = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double lastHalf = Math.max(0, (dp[i - 1][j] - 1) / 2.0);
                dp[i][j] += lastHalf;
                dp[i][j + 1] += lastHalf;
            }
            if (dp[i][i / 2] <= 1 && dp[i][i / 2 + 1] <= 1) {
                break;
            }
        }
        if (dp[query_row] == null) {
            return 0D;
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0.00000
        System.out.println(s.champagneTower(1, 1, 1));
        // 0.50000
        System.out.println(s.champagneTower(2, 1, 1));
        // 1.00000
        System.out.println(s.champagneTower(100000009, 33, 17));
        // 0.86426
        System.out.println(s.champagneTower(1908, 10, 0));
    }
}
