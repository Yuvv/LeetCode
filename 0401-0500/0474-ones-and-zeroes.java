import java.util.*;

/*
 * 0474-ones-and-zeroes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/23
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp(i, j) means the max subset size if it constraints to i-0s and j-1s
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            // count 0 & 1
            int one = 0;
            int zero = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            // to get dp(i, j), we should try all possible way
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.findMaxForm(
            new String[] {"10","0001","111001","1","0"},
            5, 3
        ));
        // 2
        System.out.println(s.findMaxForm(
            new String[] {"10","0","1"},
            1, 1
        ));
    }
}

