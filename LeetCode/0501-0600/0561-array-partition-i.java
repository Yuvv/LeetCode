class Solution {
    /**
     * 数组分片，求最小值的和
     * https://leetcode.com/problems/array-partition-i/description/
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}