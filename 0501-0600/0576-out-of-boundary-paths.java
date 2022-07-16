/*
 * 0576-out-of-boundary-paths.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/16
 */
public class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }
        return findPaths(dp, startRow, startColumn, maxMove - 1);
    }

    private int findPaths(int[][][] dp, int i, int j, int mm) {
        if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length) {
            return 1;
        }
        if (mm < 0) {
            return 0;
        }
        if (dp[i][j][mm] >= 0) {
            return dp[i][j][mm];
        }
        long res = 0L;
        // left
        res += findPaths(dp, i - 1, j, mm - 1);
        // right
        res +=findPaths(dp, i + 1, j, mm - 1);
        // up
        res += findPaths(dp, i, j - 1, mm - 1);
        // down
        res += findPaths(dp, i, j + 1, mm - 1);

        dp[i][j][mm] = (int) (res % 1000000007);
        return dp[i][j][mm];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.findPaths(2,2,2,0,0));
        // 12
        System.out.println(s.findPaths(1,3,3,0,1));
    }
}