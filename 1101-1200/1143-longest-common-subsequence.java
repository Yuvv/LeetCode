import java.util.Arrays;

/**
 * 1143-longest-common-subsequence.java
 *
 * @date 2024/1/25
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[text2.length()];
            Arrays.fill(dp[i], -1);
        }
        return dfs(dp, 0, 0, text1, text2);
    }

    private int dfs(int[][] dp, int i, int j, String txt1, String txt2) {
        if (i >= txt1.length() || j >= txt2.length()) {
            return 0;
        }
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        int cnt = dfs(dp, i+1, j+1, txt1, txt2);
        if (txt1.charAt(i) == txt2.charAt(j)) {
            cnt++; 
        }
        cnt = Math.max(cnt, dfs(dp, i, j+1, txt1, txt2));
        cnt = Math.max(cnt, dfs(dp, i+1, j, txt1, txt2));
        dp[i][j] = cnt;
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
        // 3
        System.out.println(s.longestCommonSubsequence("abc", "abc"));
        // 0
        System.out.println(s.longestCommonSubsequence("abc", "def"));
    }
}
