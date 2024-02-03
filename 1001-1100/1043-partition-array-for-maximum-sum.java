/**
 * 1043-partition-array-for-maximum-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/02/03
 */
public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        dp[arr.length] = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            int maxVal = arr[i];
            int maxRes = arr[i] + dp[i+1];
            for (int j = i+1; j < arr.length && j < i+k; j++) {
                maxVal = Math.max(maxVal, arr[j]);
                maxRes = Math.max(maxRes, maxVal*(j-i+1)+dp[j+1]);
            }
            dp[i] = maxRes;
        }
        System.out.println(java.util.Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 84
        System.out.println(s.maxSumAfterPartitioning(
            new int[]{1,15,7,9,2,5,10}, 3
        ));
        // 83
        System.out.println(s.maxSumAfterPartitioning(
            new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4
        ));
        // 1
        System.out.println(s.maxSumAfterPartitioning(
            new int[]{1}, 1
        ));
    }
}