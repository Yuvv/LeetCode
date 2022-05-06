/*
 * 0486-predict-the-winner.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/25
 */
public class Solution {
    /**
     * 这个算法相当于模拟整个流程，然后返回最后的得分
     *
     * @param turn 指代当前选手身份，如果是 A 就是 +1， B就是 -1
     */
    int winner(int[] nums, int i, int j, int turn) {
        if (i == j) {
            // 只有一个数了，直接返回
            return turn * nums[i];
        }
        // 这里就是模拟，取左侧值的结果和取右侧值的结果
        int a = turn * nums[i] + winner(nums, i + 1, j, -turn);
        int b = turn * nums[j] + winner(nums, i, j - 1, -turn);
        // 最后再 *turn 是为了控制 player2 获取时，其实是应该返回较小值的
        return turn * Math.max(turn * a, turn * b);
    }

    public boolean PredictTheWinner_recursive(int[] nums) {
        int one = winner(nums, 0, nums.length - 1, 1);
        return one >= 0;
    }

    public boolean PredictTheWinner(int[] nums) {
        /* 假设 dp(i,j) 是在`i-j`位置能够拿到的最高得分（最优结果）
         * 他的得分只依赖于在当前位置拿 nums[i] 还是拿 nums[j]
         * 如果拿了 nums[i] 则最终结果等于 nums[i] - dp(i+1,j)
         * 如果拿了 nums[j] 则最终结果等于 nums[j] - dp(i,j-1)
         * 所以在当前位置最优解 dp(i,j) = MAX( nums[i] - dp(i+1,j), nums[j] - dp(i,j-1))
         */
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    int a = nums[i] - dp[i + 1][j];
                    int b = nums[j] - dp[i][j - 1];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public boolean PredictTheWinner_1d_dp(int[] nums) {
        int[] dp = new int[nums.length];
        for (int s = nums.length - 1; s >= 0; s--) {
            for (int e = s; e < nums.length; e++) {
                if (s == e) {
                    dp[s] = nums[s];
                } else {
                    int a = nums[s] - dp[e];
                    int b = nums[e] - dp[e - 1];
                    dp[e] = Math.max(a, b);
                }
            }
        }
        return dp[nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.PredictTheWinner(new int[] {1,5,2}));
        // true
        System.out.println(s.PredictTheWinner(new int[] {1,5,233,7}));
    }
}