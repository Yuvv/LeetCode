/*
 * 0221-maximal-square.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/17
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int nRows = matrix.length, nCols = matrix[0].length;
        int[][] dp = new int[nRows + 1][nCols + 1];
        int max = 0;
        for (int i = 1; i <= nRows; i++) {
            for (int j = 1; j <= nCols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4 [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        System.out.println(s.maximalSquare(new char[][] {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'},
        }));
    }
}