class Solution {
    List<List<Integer>> lst = new ArrayList();
    
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        
        return lst;
    }
    
    public void permute(int[] nums, int idx) {
        if (idx >= nums.length) {
            List<Integer> arr = new ArrayList();
            for (int n: nums) {
                arr.add(n);
            }
            lst.add(arr);
        }
        
        for (int i=idx; i<nums.length; i++) {
            if (i == idx) {
                permute(nums, idx+1);
            } else {
                swap(nums, i, idx);
                permute(nums, idx+1);
                swap(nums, i, idx);
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}