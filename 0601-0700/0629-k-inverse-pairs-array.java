/*
 * 0629-k-inverse-pairs-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/17
 */
public class Solution {
    public int kInversePairs(int n, int k) {
        if (k == 0) {
            return 1;
        }
        // dp(i, j) means the result of `i` numbers with exactly `j` pairs, then
        // dp(0, x) = 0
        // dp(x, 0) = 1 (x > 0)
        // dp(i, j) = \sum_{x=0}^{x=min(n-1,k)} {dp(i-1,k-x)}
        // --> if we add a number `N`, then we should determine where we should put
        // the `N` in `i-1` satuation
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        int MOD = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int val = dp[i-1][j] + MOD;
                if (j >= i) {
                    val -= dp[i-1][j-i];
                }
                val %= MOD;
                dp[i][j] = (dp[i][j-1] + val) % MOD;
            }
        }

        return (dp[n][k] + MOD - dp[n][k-1]) % MOD;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.kInversePairs(1000, 0));
        // 999
        System.out.println(s.kInversePairs(1000, 1));
        // 499499
        System.out.println(s.kInversePairs(1000, 2));
        // 166665500
        System.out.println(s.kInversePairs(1000, 3));
        // 663677020
        System.out.println(s.kInversePairs(1000, 1000));
    }
}