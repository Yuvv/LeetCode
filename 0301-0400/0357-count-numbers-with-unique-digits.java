/*
 * 0357-count-numbers-with-unique-digits.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/02
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][0] = 9;
        dp[1][1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] * (11 - i);
            dp[i][1] = dp[i][0] + dp[i - 1][1];
        }
        return dp[n][1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 739
        System.out.println(s.countNumbersWithUniqueDigits(3));
        // 1
        System.out.println(s.countNumbersWithUniqueDigits(0));
        // 10
        System.out.println(s.countNumbersWithUniqueDigits(1));
        // 91
        System.out.println(s.countNumbersWithUniqueDigits(2));
    }
}