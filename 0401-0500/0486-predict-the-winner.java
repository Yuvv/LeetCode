/*
 * 0486-predict-the-winner.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/25
 */
public class Solution {
    int winner(int[] nums, int i, int j, int turn) {
        if (i == j) {
            return turn * nums[i];
        }
        int a = turn * nums[i] + winner(nums, i + 1, j, -turn);
        int b = turn * nums[j] + winner(nums, i, j - 1, -turn);
        // 最后再 *turn 是为了控制 player2 获取时，其实是应该返回较小值的
        return turn * Math.max(turn * a, turn * b);
    }

    public boolean PredictTheWinner(int[] nums) {
        int one = winner(nums, 0, nums.length - 1, 1);
        return one >= 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
    }
}