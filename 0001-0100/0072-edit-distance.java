import java.util.Arrays;

/*
 * 0072-edit-distance.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/01
 */
public class Solution {
    /**
     * @see: https://en.wikipedia.org/wiki/Levenshtein_distance
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int[][] dp = new int[len1][len2];
        for (int [] row : dp) {
            Arrays.fill(row, -1);
        }
        lev(dp, word1, 0, word2, 0);

        return dp[0][0];
    }

    public int lev(int[][] dp, String word1, int idx1, String word2, int idx2) {
        if (idx1 >= word1.length()) {
            return word2.length() - idx2;
        }
        if (idx2 >= word2.length()) {
            return word1.length() - idx1;
        }
        if (dp[idx1][idx2] >= 0) {
            return dp[idx1][idx2];
        }
        int dis = 0;
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            dis = lev(dp, word1, idx1 + 1, word2, idx2 + 1);
        } else {
            dis = Math.min(lev(dp, word1, idx1 + 1, word2, idx2), lev(dp, word1, idx1, word2, idx2 + 1));
            dis = Math.min(dis, lev(dp, word1, idx1 + 1, word2, idx2 + 1));
            dis += 1;
        }
        dp[idx1][idx2] = dis;
        return dis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minDistance("horse", "ros"));
        // 5
        System.out.println(s.minDistance("intention", "execution"));
    }
}