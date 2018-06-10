class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        int mid;
        int result = 0;
        while(r-l>1) {
            mid = (l+r) / 2;
            if(nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid;
            } else {
                return leftTarget(nums, target, mid);
            }
        }
        if (nums[l] == target) {
            return leftTarget(nums, target, l);
        } else if(nums[r] == target) {
            return leftTarget(nums, target, r);
        } else {
            return -1;
        }
    }
    
    int leftTarget(int[] nums, int target, int idx) {
        while(idx > 0 && nums[idx-1] == target) {
            idx--;
        }
        return idx;
    }
}