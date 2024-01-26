import java.util.Arrays;

/**
 * 0688-knight-probability-in-chessboard.java
 *
 * @date 2024/1/26
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public static int[][] directions = new int[][] {
            { 1, 2 }, { 2, 1 },
            { -1, 2 }, { -2, 1 },
            { -1, -2 }, { -2, -1 },
            { 1, -2 }, { 2, -1 }
    };

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1.0);
            }
        }

        return dfs(dp, k - 1, row, column);
    }

    private double dfs(double[][][] dp, int k, int i, int j) {
        if (i < 0 || i >= dp.length || j < 0 || j >= dp.length) {
            return 0;
        }
        if (k < 0) {
            return 1.0;
        }
        if (dp[i][j][k] >= 0) {
            return dp[i][j][k];
        }
        double res = 0.0;
        for (int[] dire : directions) {
            res += dfs(dp, k - 1, i + dire[0], j + dire[1]) / directions.length;
        }
        dp[i][j][k] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 0.06250
        System.out.println(s.knightProbability(3, 2, 0, 0));
        // 1.00000
        System.out.println(s.knightProbability(1, 0, 0, 0));
    }
}
