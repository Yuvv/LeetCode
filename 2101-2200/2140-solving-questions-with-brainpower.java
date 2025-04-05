/**
 * 2140-solving-questions-with-brainpower.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/05
 */
public class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        dp[questions.length - 1] = questions[questions.length - 1][0];
        for (int i = questions.length - 2; i >= 0; i--) {
            if (i + questions[i][1] + 1 >= questions.length) {
                dp[i] = Math.max(dp[i + 1], questions[i][0]);
            } else {
                dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[i + questions[i][1] + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.mostPoints(new int[][] {{3,2},{4,3},{4,4},{2,5}}));
        // 7
        System.out.println(s.mostPoints(new int[][] {{1,1},{2,2},{3,3},{4,4},{5,5}}));
    }
}
