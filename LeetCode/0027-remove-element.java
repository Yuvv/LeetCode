class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0, idx = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                len++;
                nums[idx] = nums[i];   
                idx++;
            }
        }
        return len;
    }
}