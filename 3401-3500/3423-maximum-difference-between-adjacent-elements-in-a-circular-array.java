/**
 * 3423-maximum-difference-between-adjacent-elements-in-a-circular-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/14
 */
public class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = Math.abs(nums[0] - nums[nums.length - 1]);
        for (int i = 0; i < nums.length-1; i++) {
            int diff = Math.abs(nums[i] - nums[i+1]);
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxAdjacentDistance(new int[]{1, 2, 4}));
        // 5
        System.out.println(s.maxAdjacentDistance(new int[]{-5, -10, -5}));
    }
}