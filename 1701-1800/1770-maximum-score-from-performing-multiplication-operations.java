import java.util.*;

/*
 * 1770-maximum-score-from-performing-multiplication-operations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/16
 */
public class Solution {

    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] dp = new Integer[multipliers.length][nums.length];
        return find(dp, nums, 0, multipliers, 0);
    }

    private int find(Integer[][] dp, int[] nums, int i, int[] multipliers, int k) {
        if (k >= multipliers.length) {
            return 0;
        }
        Integer cachedRes = dp[k][i];
        if (cachedRes != null) {
            return cachedRes;
        }
        int j = nums.length - 1 + i - k;
        int left = nums[i] * multipliers[k] + find(dp, nums, i + 1, multipliers, k + 1);
        int right = nums[j] * multipliers[k] + find(dp, nums, i, multipliers, k + 1);
        int res = Math.max(left, right);
        dp[k][i] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 14
        System.out.println(s.maximumScore(
            new int[] {1,2,3},
            new int[] {3,2,1}
        ));
        // 102
        System.out.println(s.maximumScore(
            new int[] {-5,-3,-3,-2,7,1},
            new int[] {-10,-5,3,4,6}
        ));
    }
}