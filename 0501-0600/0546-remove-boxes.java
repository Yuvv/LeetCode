import java.util.*;

/*
 * 0546-remove-boxes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/14
 */
public class Solution {
    // https://leetcode.com/problems/remove-boxes/discuss/101310/Java-top-down-and-bottom-up-DP-solutions
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        if (n == 0) {
            return 0;
        }
        int[][][] dp = new int[n][n][n];  // from, to, prefix of from

        for (int j = 0; j < n; j++) {
            for (int k = 0; k <= j; k++) {
                dp[j][j][k] = (k + 1) * (k + 1);
            }
        }

        for (int l = 1; l < n; l++) {
            for (int j = l; j < n; j++) {
                int i = j - l;

                for (int k = 0; k <= i; k++) {
                    int res = (k + 1) * (k + 1) + dp[i + 1][j][0];

                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            res = Math.max(res, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                        }
                    }

                    dp[i][j][k] = res;
                }
            }
        }

        return dp[0][n - 1][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 23
        System.out.println(s.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
        // 47
        System.out.println(s.removeBoxes(new int[]{1, 1, 2, 1, 1, 2, 1, 1, 2, 2, 2}));
        // 50
        System.out.println(s.removeBoxes(new int[]{1, 1, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2}));
        // 2758
        System.out.println(s.removeBoxes(new int[]{
                1, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 2, 2, 2, 2, 1, 2, 1, 1, 2, 2, 1,
                2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 1, 1, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2,
                2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1}));
    }
}