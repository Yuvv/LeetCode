import java.util.Arrays;

/*
 * 1641-count-sorted-vowel-strings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/25
 */
public class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);

        // dp(i, j) = sum_0_j {dp(i-1, k)}
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum += dp[i - 1][k];
                }
                dp[i][j] = sum;
            }
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dp[n - 1][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.countVowelStrings(1));
        // 15
        System.out.println(s.countVowelStrings(2));
        // 66045
        System.out.println(s.countVowelStrings(33));
    }
}