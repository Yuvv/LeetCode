/*
 * https://leetcode.com/problems/house-robber/description/
 */
class Solution {
    public int rob(int[] nums) {
        int last, cur, tmp;
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            last = nums[0];
            cur = Math.max(nums[0], nums[1]);
            for (int i=2; i<nums.length; i++) {
                tmp = Math.max(cur, last + nums[i]);
                last = cur;
                cur = tmp;
            }
        }
        return cur;
        // return rob(nums, nums.length-1);
    }
    
    // TLE....
    // idx 为截取的索引值
//     public int rob(int[] nums, int idx) {
//         int sum = 0;
//         if (idx == 0) {
//             sum = nums[0];
//         } else if (idx == 1) {
//             sum = Math.max(nums[0], nums[1]);
//         } else {
//             sum = Math.max(rob(nums, idx-1), rob(nums, idx-2) + nums[idx]);
//         }
        
//         return sum;
//     }
}