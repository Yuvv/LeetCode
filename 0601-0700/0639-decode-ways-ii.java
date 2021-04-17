import java.util.*;

/*
 * 0639-decode-ways-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/04/17
 */
public class Solution {
    public int numDecodings(String s) {
        int sLen = s.length();
        long mod = 1000000007L;
        int[] dp = new int[sLen + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else if (s.charAt(0) == '*') {
            dp[1] = 9;
        }
        for (int i = 2; i <= sLen; i++) {
            char c0 = s.charAt(i - 2);
            char c = s.charAt(i - 1);
            long curVal = 0;
            // 1 char
            if (c >= '1' && c <= '9') {
                curVal += dp[i - 1];
            } else if (c == '*') {
                curVal += dp[i - 1] * 9L;
            }
            // 2 chars
            if (c0 == '1') {
                if (c >= '0' && c <= '9') {
                    curVal += dp[i - 2];
                } else if (c == '*') {
                    curVal += dp[i - 2] * 9L;
                }
            } else if (c0 == '2') {
                if (c >= '0' && c <= '6') {
                    curVal += dp[i - 2];
                } else if (c == '*') {
                    curVal += dp[i - 2] * 6L;
                }
            } else if (c0 == '*') {
                if (c == '*') {
                    curVal += dp[i - 2] * 15L;
                } else if (c >= '0') {
                    if (c <= '6') {
                        // c0 can be '1' or '2'
                        curVal += dp[i - 2] * 2L;
                    } else if (c <= '9') {
                        // c0 can be '1'
                        curVal += dp[i - 2];
                    }
                }
            }
            dp[i] = (int) (curVal % mod);
        }
        return dp[sLen];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 9
        System.out.println(s.numDecodings("*"));
        // 96
        System.out.println(s.numDecodings("**"));
        // 18
        System.out.println(s.numDecodings("1*"));
        // 15
        System.out.println(s.numDecodings("2*"));
        // 3600
        System.out.println(s.numDecodings("134*92*0*9*"));
        // 291868912  ---> int overflow...
        System.out.println(s.numDecodings("*********"));
        // 882201566 ----> long overflow...
        System.out.println(s.numDecodings("1*6*7*1*9*6*2*9*2*3*3*6*3*2*2*4*7*2*9*6*0*6*4*4*1*6*9*0*5*9*2*5*7*7*0*6*9*7*1*5*5*9*3*0*4*9*2*6*2*5*7*6*1*9*4*5*8*4*7*4*2*7*1*2*1*9*1*3*0*6*"));

    }
}