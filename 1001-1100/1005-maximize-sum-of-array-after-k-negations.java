/*
 * 1005-maximize-sum-of-array-after-k-negations.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/09/10
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        java.util.Arrays.sort(nums);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (k > 0) {
                    sum -= nums[i];
                    k--;
                } else {
                    sum += nums[i];
                }
                min = Math.min(min, -nums[i]);
            } else {
                sum += nums[i];
                min = Math.min(min, nums[i]);
            }
        }
        if (k % 2 == 0) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.largestSumAfterKNegations(
            new int[] {4, 2, 3}, 1
        ));
        // 6
        System.out.println(s.largestSumAfterKNegations(
            new int[] {3,-1,0,2}, 3
        ));
        // 13
        System.out.println(s.largestSumAfterKNegations(
            new int[] {2,-3,-1,5,-4}, 2
        ));
    }
}
