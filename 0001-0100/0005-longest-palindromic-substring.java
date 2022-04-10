/*
 * 0005-longest-palindromic-substring.java
 *
 * 最长回文串
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2018/09/26
 */
public class Solution {
    /**
     * 虽然算是暴力解法，但是由于有"fail fast"的存在，所以实际时间和下面的动态规划法差不多
     */
    public String longestPalindrome_BruteForce(String s) {
        int sLen = s.length();
        if (sLen < 2) {
            return s;
        }
        int maxBegin = 0, maxEnd = 0;
        int end;
        for (int i = 0; i < sLen; i++) {
            end = sLen - 1;
            if (maxEnd - maxBegin >= end - i) {
                // fail fast
                break;
            }
            while (end > i) {
                if (maxEnd - maxBegin >= end - i) {
                    // fail fast
                    break;
                }
                if (isPalindrome(s, i, end) && end - i > maxEnd - maxBegin) {
                    maxEnd = end;
                    maxBegin = i;
                }
                end--;
            }
        }
        return s.substring(maxBegin, maxEnd + 1);
    }

    boolean isPalindrome(String s, int begin, int end) {
        while (end > begin) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            end--;
            begin++;
        }
        return true;
    }

    /** let's dynamic programming
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxI = 0, maxJ = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i < len - 1) {
                boolean ok = s.charAt(i) == s.charAt(i + 1);
                dp[i][i + 1] = ok;
                if (ok) {
                    maxI = i;
                    maxJ = i + 1;
                }
            }
        }
        for (int i = len - 3; i >= 0; i--) {
            for (int j = i + 2; j < len; j++) {
                if ((i + 1 >= j - 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j - i > maxJ - maxI) {
                        maxJ = j;
                        maxI = i;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        // System.out.println(java.util.Arrays.deepToString(dp));
        return s.substring(maxI, maxJ + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "bab"
        System.out.println(s.longestPalindrome("babad"));
        // "bb"
        System.out.println(s.longestPalindrome("cbbd"));
        // "babbab"
        System.out.println(s.longestPalindrome("cbbdbbabbabc"));
    }
}