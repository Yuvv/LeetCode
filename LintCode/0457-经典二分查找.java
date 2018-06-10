public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        // Write your code here
        if(nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        int mid;
        while(r-l>1) {
            mid = (l+r) / 2;
            if(nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid;
            } else {
                return mid;
            }
        }
        if (nums[l] == target) {
            return l;
        } else if(nums[r] == target) {
            return r;
        } else {
            return -1;
        }
    }
}