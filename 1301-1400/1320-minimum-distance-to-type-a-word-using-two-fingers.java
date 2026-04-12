import java.util.*;
/**
 * 1320-minimum-distance-to-type-a-word-using-two-fingers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2026/04/12
 */
public class Solution {
    public int minimumDistance(String word) {
        int N = word.length();
        int[][][] dp = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            min = Math.min(min, dfs(dp, i, 0, 0, word));
        }
        for (int j = 1; j < N; j++) {
            min = Math.min(min, dfs(dp, 0, j, 0, word));
        }
        return min;
    }

    private int dfs(int[][][] dp, int i, int j, int k, String word) {
        if (k == word.length()) {
            return 0;
        }
        if (dp[i][j][k] >= 0) {
            return dp[i][j][k];
        }
        // f1 move next character
        int f1 = dis(word, i, k+1) + dfs(dp, k+1, j, k+1, word);
        // f2 move next charcater
        int f2 = dis(word, j, k+1) + dfs(dp, i, k+1, k+1, word);
        // final result
        dp[i][j][k] = Math.min(f1, f2);
        return dp[i][j][k];
    }

    private int dis(String word, int i, int j) {
        if (i >= word.length() || j >= word.length()) {
            return 0;
        }
        int a = (int)(word.charAt(i)-'A');
        int b = (int)(word.charAt(j)-'A');
        return Math.abs(a/6 - b/6) + Math.abs((a%6) - (b%6));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minimumDistance("CAKE"));
        // 6
        System.out.println(s.minimumDistance("HAPPY"));
        // 126
        System.out.println(s.minimumDistance("KQVMTAZNPLXWODIRSYUBCEFHJGLNQTRVPMXKSOAIDYUECHFZBGWLNRJTVQPKM"));
        // 154
        System.out.println(s.minimumDistance("QAZWSXEDCRFVTGBYHNUJMIKOLPPLOKIMJUNHYBGTVFRCDEXSWZAQWERTYUIOPASDFGHJKLZXCVBNM"));
    }
}