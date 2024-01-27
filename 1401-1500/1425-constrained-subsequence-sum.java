import java.util.Arrays;
import java.util.TreeMap;

/**
 * 1425-constrained-subsequence-sum.java
 *
 * @date 2024/1/27
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(dp[nums.length - 1], 1);
        int maxRes = dp[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int nextMax = treeMap.lastKey();
            int max = Math.max(nums[i], nums[i] + nextMax);
            dp[i] = max;
            maxRes = Math.max(max, maxRes);
            treeMap.put(max, treeMap.getOrDefault(max, 0) + 1);
            if (i + k < nums.length) {
                Integer v = treeMap.get(dp[i + k]);
                if (v == 1) {
                    treeMap.remove(dp[i + k]);
                } else {
                    treeMap.put(dp[i + k], v - 1);
                }
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 37
        System.out.println(s.constrainedSubsetSum(new int[] { 10, 2, -10, 5, 20 }, 2));
        // -1
        System.out.println(s.constrainedSubsetSum(new int[] { -1, -2, -3 }, 1));
        // 23
        System.out.println(s.constrainedSubsetSum(new int[] { 10, -2, -10, -5, 20 }, 2));
    }
}
