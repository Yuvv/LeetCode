import java.util.*;

/**
 * 2370-longest-ideal-subsequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/15
 */
public class Solution {
    public int longestIdealString(String s, int k) {
        int gm = 0;
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        int[] dp = new int[s.length()+1];
        for (int i = s.length()-1; i >= 0; i--) {
            int chord = s.charAt(i) - 'a';
            int b = 0;
            for (int j = Math.max(0, chord-k); j <= Math.min(25, chord+k); j++) {
                if (idx[j] >= 0 && dp[idx[j]] > b) {
                    b = dp[idx[j]];
                }
            }
            dp[i] = b + 1;
            gm = Math.max(gm, dp[i]);
            idx[chord] = i;
        }

        return gm;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.longestIdealString("azsjklfhuiewhfsalkjfklsd", 2));
        // 4
        System.out.println(s.longestIdealString("acfgbd", 2));
        // 4
        System.out.println(s.longestIdealString("abcd", 3));
    }
}
