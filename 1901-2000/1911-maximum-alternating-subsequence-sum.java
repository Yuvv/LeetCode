/*
 * 1911-maximum-alternating-subsequence-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/23
 */
public class Solution {
    public long maxAlternatingSum(int[] nums) {
        // 0-even, 1-odd
        long[][] dp = new long[nums.length][2];
        // dp
        return getMaxSum(nums, 0, dp, true);
    }

    public long getMaxSum(int[] nums, int fromIdx, long[][] dp, boolean isEven) {
        if (fromIdx >= nums.length) {
            return 0;
        }
        int subIdx = isEven ? 0 : 1;
        if (dp[fromIdx][subIdx] > 0) {
            return dp[fromIdx][subIdx];
        }
        int num = isEven ? nums[fromIdx] : -nums[fromIdx];

        // pick this num
        long a = num + getMaxSum(nums, fromIdx + 1, dp, !isEven);
        // don't pick this num
        long b = getMaxSum(nums, fromIdx + 1, dp, isEven);
        dp[fromIdx][subIdx] = Math.max(a, b);

        return dp[fromIdx][subIdx];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.maxAlternatingSum(new int[] {4,2,5,3}));
        // 8
        System.out.println(s.maxAlternatingSum(new int[] {5,6,7,8}));
        // 10
        System.out.println(s.maxAlternatingSum(new int[] {6,2,1,2,4,5}));
    }
}