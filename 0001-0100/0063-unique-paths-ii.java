/*
 * 0063-unique-paths-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2020/11/15
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][];
        for (int i = 0; i < rows; i++) {
            dp[i] = new int[cols];
        }
        dp[0][0] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[rows - 1][cols  -1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1 expected
        System.out.println(s.uniquePathsWithObstacles(new int[][] {
            {0, 0},
            {1, 0}
        }));
        // 2 expected
        System.out.println(s.uniquePathsWithObstacles(new int[][] {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        }));
        // 3 expected
        System.out.println(s.uniquePathsWithObstacles(new int[][] {
            {0, 0, 0, 1},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0}
        }));
    }
}