import java.util.Arrays;

/**
 * 1458-max-dot-product-of-two-subsequences.java
 *
 * @date 2024/1/27
 * @author Yuvv <yuvv_th@outlook.com>
 */
public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // dp(i,j) means the max result for nums1[0..i] .* nums2[0..j]
        int[][] dp = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0]*nums2[0];
        for (int j = 1; j < nums2.length; j++) {
            dp[0][j] = Math.max(nums1[0]*nums2[j], dp[0][j-1]);
        }
        for (int i = 1; i < nums1.length; i++) {
            dp[i][0] = Math.max(nums1[i]*nums2[0], dp[i-1][0]);
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                int max = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
                int v = nums1[i]*nums2[j];
                max = Math.max(v, Math.max(max, dp[i-1][j-1]+v));

                dp[i][j] = max;
            }
        }
        return dp[nums1.length-1][nums2.length-1];    
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 18
        System.out.println(s.maxDotProduct(new int[]{2,1,-2,5}, new int[]{3,0,-6}));
        // 21
        System.out.println(s.maxDotProduct(new int[]{3,-2}, new int[]{2,-6,7}));
        // -1
        System.out.println(s.maxDotProduct(new int[]{-1,-1}, new int[]{1,1}));
    }
}
