import java.util.Arrays;

/**
 * 3254-find-the-power-of-k-size-subarrays-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/23
 */
public class Solution {
    public int[] resultsArray(int[] nums, int k) {
        long[] prefixSum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        int[] res = new int[nums.length-k+1];
        for (int i = k; i <= nums.length; i++) {
            long x = (long)(nums[i-1] + nums[i-k]) * (long)(k) / 2L;
            if (nums[i-1] - nums[i-k] == k-1 && prefixSum[i] - prefixSum[i-k] == x) {
                res[i-k] = nums[i-1];
            } else {
                res[i-k] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [3,4,-1,-1,-1]
        System.out.println(Arrays.toString(s.resultsArray(new int[] {1,2,3,4,3,2,5}, 3)));
        // [-1,-1]
        System.out.println(Arrays.toString(s.resultsArray(new int[] {2,2,2,2,2}, 4)));
        // [-1,3,-1,3,-1]
        System.out.println(Arrays.toString(s.resultsArray(new int[] {3,2,3,2,3,2}, 2)));
    }
}
