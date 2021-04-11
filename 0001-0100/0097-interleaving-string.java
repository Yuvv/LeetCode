import java.util.*;

/*
 * 0097-interleaving-string.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/04/11
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3,
                                int s1i, int s2i, int s3i) {
        if (s1i >= s1.length()) {
            while (s2i < s2.length() && s3i < s3.length()) {
                if (s2.charAt(s2i) == s3.charAt(s3i)) {
                    s2i++;
                    s3i++;
                } else {
                    return false;
                }
            }
            return s2i >= s2.length() && s3i >= s3.length();
        }
        if (s2i >= s2.length()) {
            while (s1i < s1.length() && s3i < s3.length()) {
                if (s1.charAt(s1i) == s3.charAt(s3i)) {
                    s1i++;
                    s3i++;
                } else {
                    return false;
                }
            }
            return s1i >= s1.length() && s3i >= s3.length();
        }

        // try each character
        while (s1i < s1.length()) {
            if (s1.charAt(s1i) != s3.charAt(s3i)) {
                return false;
            }
            s3i++;

            // try s2
            int tempS2i = s2i;
            int tempS3i = s3i;
            while (tempS2i < s2.length() && tempS3i < s3.length() && s2.charAt(tempS2i) == s3.charAt(tempS3i)) {
                if (isInterleave(s1, s2, s3, s1i + 1, tempS2i + 1, tempS3i + 1)) {
                    return true;
                }
                tempS2i++;
                tempS3i++;
            }
            // s2 not solve, continue to try s1
            s1i++;
        }
        return false;
    }

    /**
     * brute force method -- accepted, but not efficient
     *
     * As s3(n) = s1(1) + s2(1) + s3(n - 1), so just check every s1(i), s2(i),
     * recursively deal with it
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            // fast false
            return false;
        }
        if (isInterleave(s1, s2, s3, 0, 0, 0)) {
            return true;
        }
        if (isInterleave(s2, s1, s3, 0, 0, 0)) {
            return true;
        }
        return false;
    }

    /**
     * 2D Dynamic Programming
     *
     * find a route at s1*s2 table that equals s3
     */
    public boolean isInterleave_2d_dp(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 1D Dynamic Programming
     *
     * same as 2D Dynamic Programming, but convert s1*s2 table to an array
     */
    public boolean isInterleave_1d_dp(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        // false
        System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        // true
        System.out.println(s.isInterleave("", "", ""));
        // true
        System.out.println(s.isInterleave("aaaa", "aaaa", "aaaaaaaa"));
        // true
        System.out.println(s.isInterleave("a", "b", "ab"));
        // true
        System.out.println(s.isInterleave("a", "b", "ba"));
        // true
        System.out.println(s.isInterleave(
            "ktmypuzuaipvwdqzfcpxdcmgwvzyxksuwevvvqwctemofplgyiwivejfukzuwexritfvockcevmgqxpbrrbswojwylsdsfczanys",
            "igvyxazocbpkfmcdunslzwvrtxbhzbxredftkbzwotkmjwowpbzjohovxsvcoisgagdbgossqxnljmfuibfmfobdqjmakgdrnzkj",
            "kigtvyxazomycbppuzuaikfpvwdqzmcdfcpunxdcmgwslzwvrvztxbhzbxyxredftkksuwevbzwvvqwotkmjwocwpbzjohtemofpovxlgyiwisvcoivsgagdejfukzbugosswexritqxnfvlockjmfuceibfmfovmbgqxdqjmapbrrbskgdrnzkwojwylsdsfczanysj"));
    }
}