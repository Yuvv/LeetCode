import java.util.*;

/*
 * 0091-decode-ways.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/04/17
 */
public class Solution {
    public int numDecodings(String s) {
        int sLen = s.length();
        int[] dp = new int[sLen + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        }
        for (int i = 2; i <= sLen; i++) {
            char c0 = s.charAt(i - 2);
            char c = s.charAt(i - 1);
            dp[i] = 0;
            if (c >= '1' && c <= '9') {
                dp[i] += dp[i - 1];
            }
            if (c >= '0' && (c0 == '1' && c <= '9' || c0 == '2' && c <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[sLen];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.numDecodings("12"));
        // 3
        System.out.println(s.numDecodings("226"));
        // 8
        System.out.println(s.numDecodings("156247982013492102"));

    }
}