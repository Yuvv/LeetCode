/*
 * 0712-minimum-ascii-delete-sum-for-two-strings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/10
 */
public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // dp(i,j) means the minimum sum of s1[i:] & s2[j:]
        // dp(i,j) = MIN{dp(i+1,j)+s1[i], dp(i,j+1)+s2[j], dp(i+1,j+1)+check(s1[i]+s2[j])}
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // init last row & column
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = s1.charAt(i) + dp[i + 1][s2.length()];
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = s2.charAt(j) + dp[s1.length()][j + 1];
        }
        // calc result
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int r1 = dp[i + 1][j + 1];
                if (s1.charAt(i) != s2.charAt(j)) {
                    r1 += s1.charAt(i) + s2.charAt(j);
                }
                int r2 = dp[i + 1][j] + s1.charAt(i);
                int r3 = dp[i][j + 1] + s2.charAt(j);

                dp[i][j] = Math.min(r1, Math.min(r2, r3));
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 231
        System.out.println(s.minimumDeleteSum("sea", "eat"));
        // 403
        System.out.println(s.minimumDeleteSum("delete", "leet"));
    }
}