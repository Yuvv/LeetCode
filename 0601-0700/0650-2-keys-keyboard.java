/**
 * 0650-2-keys-keyboard.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/17
 */
public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int min = i;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    min = Math.min(min, dp[j] + i / j);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minSteps(3));
        // 0
        System.out.println(s.minSteps(1));
    }
}
