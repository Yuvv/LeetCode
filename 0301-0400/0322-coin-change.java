import java.util.*;

/*
 * 0322-coin-change.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/25
 */
public class Solution {

    // dynamic programming - bottom up
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // dp[i] means the min changes to make `i` amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            // since coins.length <= 12, so we can try each coin and find best solution
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] >= 0) {
                    min = Math.min(min, 1 + dp[i - coin]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.coinChange(new int[] {1,2,5}, 11));
        // -1
        System.out.println(s.coinChange(new int[] {2}, 3));
        // 0
        System.out.println(s.coinChange(new int[] {1}, 0));
    }
}