import java.util.*;
/**
 * 0416-partition-equal-subset-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/09/07
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        HashMap<Integer, Boolean>[] dp = new HashMap[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = new HashMap<>();
        }
        if (sum % 2 == 1) {
            return false;
        }
        return dfs(dp, nums, 0, sum/2);
    }

    private boolean dfs(Map<Integer, Boolean>[] dp, int[] nums, int idx, int target) {
        if (idx >= dp.length) {
            return false;
        }
        if (dp[idx].containsKey(target)) {
            return dp[idx].get(target);
        }
        boolean res = false;
        if (nums[idx] == target) {
            res = true;
        } else if (nums[idx] > target) {
            res = dfs(dp, nums, idx+1, target);
        } else {
            res = dfs(dp, nums, idx+1, target-nums[idx]) ||
                dfs(dp, nums, idx+1, target);
        }
        dp[idx].put(target, res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canPartition(new int[] {1,5,11,5}));
        // false
        System.out.println(s.canPartition(new int[] {1,2,3,5}));
    }
}
