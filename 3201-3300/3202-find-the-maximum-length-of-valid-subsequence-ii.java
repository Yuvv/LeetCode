import java.util.Arrays;
/**
 * 3202-find-the-maximum-length-of-valid-subsequence-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/07/19
 */
public class Solution {
    public int maximumLength(int[] nums, int k) {
        int max = 0;
        int[] dp = new int[k];
        for (int i = 0; i < k; i++) { // try every possible remainder
            Arrays.fill(dp, 0);   // reset dp
            for (int n : nums) {
                int mod = n % k;
                dp[mod] = Math.max(dp[mod], dp[(i+k-mod) % k] + 1);
                max = Math.max(max, dp[mod]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.maximumLength(new int[]{1, 2, 3, 4, 5}, 2));
        // 4
        System.out.println(s.maximumLength(new int[]{1,4,2,3,1,4}, 3));
    }
}