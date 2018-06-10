class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int last = nums[0];
        int idx = 1;
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != last) {
                nums[idx] = nums[i];
                idx++;
            }
            last = nums[i];
        }
        
        return idx;
    }
}