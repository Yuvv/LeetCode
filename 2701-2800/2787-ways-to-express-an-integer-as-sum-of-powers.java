import java.util.Arrays;
/**
 * 2787-ways-to-express-an-integer-as-sum-of-powers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/16
 */
public class Solution {
    static int MOD = 1000000007;
    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int power = (int) Math.pow(i, x);
            for (int sum = n; sum >= power; sum--) {
                dp[sum] = (dp[sum] + dp[sum - power]) % MOD;
            }
        }
        return dp[n];
    }

    public int numberOfWays_2d_dp(int n, int x) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(dp, n, n, x);
    }

    private int dfs(int[][] dp, int i, int j, int x) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        int n = 0;
        for (int jj = j; jj > 0; jj--) {
            int next = i - (int)Math.pow(jj, x);
            n += dfs(dp, next, Math.min(jj-1, next), x);
            n %= MOD;
        }
        dp[i][j] = n;
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numberOfWays(10, 2));
        // 2
        System.out.println(s.numberOfWays(4, 1));
    }
}