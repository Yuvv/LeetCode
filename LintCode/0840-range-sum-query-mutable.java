/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 */

class NumArray {
    
    int[] nums;
    // 常规解法会 TLE，保存计算结果即可
    int last_i;
    int last_j;
    int sum;

    public NumArray(int[] nums) {
        this.nums = nums;
        
        this.last_i = -1;
        this.last_j = -1;
        this.sum = Integer.MIN_VALUE;
    }
    
    public void update(int i, int val) {
        
        if (last_i != -1 && i >= last_i && i <= last_j) {
            sum += val - nums[i];
        }
        
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        if (last_i != -1) {
            if (i < last_i) {
                for(int k=i; k<last_i; k++) {
                    this.sum += nums[k];
                }
            } else {
                for(int k=last_i; k<i; k++) {
                    this.sum -= nums[k];
                }
            }
            if (j < last_j) {
                for(int k=last_j; k>j; k--) {
                    this.sum -= nums[k];
                }
            } else {
                for(int k=j; k>last_j; k--) {
                    this.sum += nums[k];
                }
            }
        } else {
            int sum = 0;
            for(int k=i; k<=j; k++) {
                sum += nums[k];
            }
            this.sum = sum;
        }
        last_i = i;
        last_j = j;
        
        return this.sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */