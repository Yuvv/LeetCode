/*
 * 0647-palindromic-substrings.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/05/22
 */
public class Solution {
    public int countSubstrings(String s) {
        // dp[j][i] means if s(i-j) is palindromic
        int[][] dp = new int[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new int[i + 1];
            java.util.Arrays.fill(dp[i], -1);
            dp[i][i] = 1;
        }
        int total = 0;
        for (int j = 0; j < s.length(); j++) {
            // j as center --> odd length
            total += getMax(s, dp, j, true);
            // j & j+1 as center --> even length
            total += getMax(s, dp, j, false);
        }
        return total;
    }

    public int getMax(String s, int[][] dp, int i, boolean isOddLen) {
        int ii, jj;
        int expLen = 0;
        if (isOddLen) {
            int maxExpandLen = Math.min(i, s.length() - 1 - i);
            for (expLen = 1; expLen <= maxExpandLen; expLen++) {
                ii = i - expLen;
                jj = i + expLen;
                if (!isPalindromic(s, ii, jj, dp)) {
                    break;
                }
            }
            return expLen;
        } else {
            int maxExpandLen = Math.min(i, s.length() - 2 - i);
            for (expLen = 0; expLen <= maxExpandLen; expLen++) {
                ii = i - expLen;
                jj = i + 1 + expLen;
                if (!isPalindromic(s, ii, jj, dp)) {
                    break;
                }
            }
            return expLen;
        }
    }

    public boolean isPalindromic(String s, int ii, int jj, int[][] dp) {
        if (ii >= jj) {
            return true;
        }
        if (dp[jj][ii] >= 0) {
            return dp[jj][ii] == 1;
        }
        boolean res = s.charAt(ii) == s.charAt(jj) && isPalindromic(s, ii + 1, jj - 1, dp);
        dp[jj][ii] = res ? 1 : 0;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.countSubstrings("abc"));
        // 6
        System.out.println(s.countSubstrings("aaa"));
        // 35
        System.out.println(s.countSubstrings("aaababaababbbab"));
    }
}