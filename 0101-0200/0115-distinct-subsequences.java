import java.util.Arrays;

/*
 * 0115-distinct-subsequences.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/19
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        // dp
        return buildDp(dp, s, 0, t, 0);
    }

    public int buildDp(int[][] dp, String s, int si, String t, int ti) {
        if (si >= dp.length) {
            return 0;
        }
        if (ti >= t.length()) {
            return 0;
        }
        if (dp[si][ti] >= 0) {
            return dp[si][ti];
        }
        int count = 0;
        for (int i = si; i < dp.length; i++) {
            if (s.charAt(i) == t.charAt(ti)) {
                if (ti == t.length() - 1) {
                    count += 1;
                } else {
                    count += buildDp(dp, s, i + 1, t, ti + 1);
                }
            }
        }
        dp[si][ti] = count;
        return dp[si][ti];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.numDistinct("babgbag", "bag"));
        // 3
        System.out.println(s.numDistinct("rabbbit", "rabbit"));
    }
}