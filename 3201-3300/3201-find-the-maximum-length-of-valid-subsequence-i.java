import java.util.Arrays;
/**
 * 3201-find-the-maximum-length-of-valid-subsequence-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/19
 */
public class Solution {
    public int maximumLength(int[] nums) {
        int oddCount = 0;
        int evenCount = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        int max = Math.max(oddCount, evenCount);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(max, dfs(dp, 0, nums));
    }

    private int dfs(int[] dp, int idx, int[] nums) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx] >= 0) {
            return dp[idx];
        }
        int x = nums[idx]&1;
        int y = 1-x;
        int j = idx + 1;
        while (j < nums.length && (nums[j]&1) != y) {
            j++;
        }
        if (j < nums.length) {
            dp[idx] = 1 + dfs(dp, j, nums);
        } else {
            dp[idx] = 1;
        }
        return dp[idx];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maximumLength(new int[]{1, 2, 3, 4}));
        // 6
        System.out.println(s.maximumLength(new int[]{1,2,1,1,2,1,2}));
        // 2
        System.out.println(s.maximumLength(new int[]{1,3}));
    }
}