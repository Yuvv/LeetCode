/**
 * 1653-minimum-deletions-to-make-string-balanced.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/07/30
 */
public class Solution {
    public int minimumDeletions(String s) {
        int[] aCount = new int[s.length()+1];
        for (int i = s.length()-1; i >= 0; i--) {
            aCount[i] = aCount[i+1] + (s.charAt(i) == 'a' ? 1 : 0);
        }
        int[] dp = new int[s.length()];
        for (int i = s.length()-2; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.min(dp[i+1]+1, aCount[i]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minimumDeletions("aababbab"));
        // 2
        System.out.println(s.minimumDeletions("bbaaaaaaaabb"));
    }
}
