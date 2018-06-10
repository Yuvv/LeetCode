public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
     
    List<Integer> cur;
    
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        
        permute(nums, 0, nums.length, result);
        
        return result;
    }
    void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    void permute(int[] nums, int idx, int len, List<List<Integer>> result) {
        if(len == 0) {
            result.add(new ArrayList<>());
            return;
        }
        
        if(idx == len - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        
        for(int i=idx; i<len; i++) {
            swap(nums, idx, i);
            permute(nums, idx+1, len, result);
            swap(nums, idx, i);
        }
    }
}