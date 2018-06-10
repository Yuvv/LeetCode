/**
 * Given an integer array nums, find the sum of the elements between indices i and j 
 * (i ≤ j), inclusive.
 *
 * eg)
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */

class NumArray {
    
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k=i; k<=j; i++) {
            sum += nums[k];
        }
        
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */