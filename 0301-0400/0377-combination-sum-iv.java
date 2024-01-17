import java.util.Arrays;

/**
 * 0377-combination-sum-iv.java
 *
 * @date 2024/1/17
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(dp, nums, target);
    }

    private int dfs(int[] dp, int[] nums, int target) {
        if (dp[target] >= 0) {
            return dp[target];
        }
        if (target <= 0) {
            return 0;
        }
        int cnt = 0;
        for (int nu : nums) {
            if (nu > target) {
                continue;
            } else if (nu == target) {
                cnt++;
            } else {
                cnt += dfs(dp, nums, target - nu);
            }
        }
        dp[target] = cnt;
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 718
        System.out.println(s.combinationSum4(
                new int[] { 12, 13, 4, 5, 6, 7, 8, 9, 10 },
                27));
        // 27646775
        System.out.println(s.combinationSum4(
                new int[] { 12, 13, 4, 5, 6, 7, 8, 9, 10 },
                61));
    }
}
