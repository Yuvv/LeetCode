class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    // 二分法实现
    public int binarySearch(int[] nums, int start, int end, int target) {
        // end 可能比 start 小的
        if (start >= end) {
            if (nums[start] == target) {
                while (start >= 0 && nums[start] == target) {
                    start--;
                }
                return start + 1;
            } else if (nums[start] > target) {
                return start;
            } else {
                return start + 1;
            }
        }
            
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, start, mid-1, target);
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid+1, end, target);
        } else {
            while (mid >= 0 && nums[mid] == target) {
                mid--;
            }
            return mid + 1;
        }
    }
}