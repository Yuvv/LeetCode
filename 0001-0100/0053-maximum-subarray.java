class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int global = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            if (current < 0) {
                current = Math.max(current, nums[i]);
            } else {
                current = Math.max(current + nums[i], 0);
            }
            global = Math.max(global, current);
        }
        
        return global;
    }
}