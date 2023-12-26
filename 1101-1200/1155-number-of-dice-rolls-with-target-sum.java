import java.util.Arrays;

/**
 * 1155-number-of-dice-rolls-with-target-sum
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/26
 */
public class Solution {
    public static final long MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        // dp[i][j] means when 'i' dies for target 'j'
        long[][] dp = new long[n+1][target+1];
        for (int i = 1; i <= Math.min(k, target); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= Math.min(target, k*i); j++) {
                long cnt = 0L;
                for (int x = 1; x <= Math.min(j-(i-1),k); x++) {
                    cnt += dp[i-1][j-x];
                    cnt %= MOD;
                }
                dp[i][j] = cnt;
            }
        }
        return (int)dp[n][target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.numRollsToTarget(1, 6, 3));
        // 6
        System.out.println(s.numRollsToTarget(2, 6, 7));
        // 222616187
        System.out.println(s.numRollsToTarget(30, 30, 500));
    }
}
