/*
 * 1909-remove-one-element-to-make-the-array-strictly-increasing.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/10
 */
public class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int nonIncrIndex = -1;
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i] - nums[i - 1];
            if (nums[i - 1] <= 0) {
                if (nonIncrIndex >= 0) {
                    // fast fail
                    return false;
                }
                nonIncrIndex = i - 1;
            }
        }
        if (nonIncrIndex < 0) {
            // nums is strictly increasing, just one
            return nums.length > 1;
        }
        if (nonIncrIndex == 0 || nonIncrIndex == nums.length - 2) {
            return true;
        }
        if (nums[nonIncrIndex] + nums[nonIncrIndex - 1] > 0
                || nums[nonIncrIndex] + nums[nonIncrIndex + 1] > 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // true
        System.out.println(s.canBeIncreasing(new int[] {1,2,10,5,7}));
        // false
        System.out.println(s.canBeIncreasing(new int[] {2,3,1,2}));
        // false
        System.out.println(s.canBeIncreasing(new int[] {1,1,1}));
    }
}