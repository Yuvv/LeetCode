import java.util.*;

/*
 * 1301-number-of-paths-with-max-score.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/15
 */
public class Solution {
    static final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int[][][] dp = new int[board.size()][board.size()][2];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        dp[0][0][0] = 0;
        dp[0][0][1] = 1;

        // -- dfs
        return dfs(dp, board.size() - 1, board.size() - 1, board);
    }

    public int[] dfs(int[][][] dp, int i, int j, List<String> board) {
        int[] max = new int[] {0, 0};
        if (i < 0 || j < 0) {
            return max;
        }
        if (dp[i][j][0] >= 0) {
            return dp[i][j];
        }
        char ch = board.get(i).charAt(j);
        if (ch == 'X') {
            dp[i][j][0] = 0;
            dp[i][j][1] = 0;
            return dp[i][j];
        }
        int[] left = dfs(dp, i - 1, j, board);
        int[] up = dfs(dp, i, j - 1, board);
        int[] upright = dfs(dp, i - 1, j - 1, board);
        // find max
        if (left[0] > max[0]) {
            max[0] = left[0];
        }
        if (up[0] > max[0]) {
            max[0] = up[0];
        }
        if (upright[0] > max[0]) {
            max[0] = upright[0];
        }
        // count times
        if (left[0] == max[0]) {
            max[1] = (int) (((long) max[1] + (long) left[1]) % MOD);
        }
        if (up[0] == max[0]) {
            max[1] = (int) (((long) max[1] + (long) up[1]) % MOD);
        }
        if (upright[0] == max[0]) {
            max[1] = (int) (((long) max[1] + (long) upright[1]) % MOD);
        }
        int val = ch - '0';
        if (ch == 'S' || max[1] == 0) {
            val = 0;
        }
        // infact, there is no need to do mod for maximum sum since board.lenfth <= 100
        dp[i][j][0] = (int) (((long) max[0] + (long) val) % MOD);
        dp[i][j][1] = max[1];

        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [7,1]
        System.out.println(Arrays.toString(s.pathsWithMaxScore(Arrays.asList("E23", "2X2", "12S"))));
        // [4,2]
        System.out.println(Arrays.toString(s.pathsWithMaxScore(Arrays.asList("E12", "1X1", "21S"))));
        // [0,0]
        System.out.println(Arrays.toString(s.pathsWithMaxScore(Arrays.asList("E11", "XXX", "11S"))));
    }
}