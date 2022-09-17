/*
 * 0375-guess-number-higher-or-lower-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/17
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        int res = getRes(dp, 0, n - 1);
        System.out.println(java.util.Arrays.deepToString(dp));
        return res;
    }

    private int getRes(int[][] dp, int i, int j) {
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = 0;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int left = k + 1;
            int right = k + 1;
            if (k > i) {
                left += getRes(dp, i, k-1);
            }
            if (k < j) {
                right += getRes(dp, k+1, j);
            }
            min = Math.min(min, Math.max(left, right));
        }

        dp[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 16
        System.out.println(s.getMoneyAmount(10));
        // 0
        System.out.println(s.getMoneyAmount(1));
        // 1
        System.out.println(s.getMoneyAmount(2));
    }
}