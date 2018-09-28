class Solution {
    /**
     * 将数组循环移动 k 位（翻转3次即可）
     * https://leetcode.com/problems/rotate-array/description/
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);
    }

    void reverseArr(int[] nums, int begin, int end) {
        int temp;
        while (begin < end) {
            temp = nums[end];
            nums[end] = nums[begin];
            nums[begin] = temp;
            begin++;
            end--;
        }
    }
}