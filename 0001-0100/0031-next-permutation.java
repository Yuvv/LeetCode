class Solution {
    /**
     * 找到一组数中下一个排列
     * https://leetcode.com/problems/next-permutation/submissions/
     *
     * @param nums 数组
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int lastDescendingIndex = findLastDescendingIndex(nums);
        if (lastDescendingIndex == -1) {
            Arrays.sort(nums);
        } else {
            int lastMinIndex = findLastMin(nums, lastDescendingIndex);
            int temp = nums[lastDescendingIndex];
            nums[lastDescendingIndex] = nums[lastMinIndex];
            nums[lastMinIndex] = temp;
            Arrays.sort(nums, lastDescendingIndex + 1, nums.length);
        }
    }

    /**
     * 逆序查找最先开始降序的位置
     *
     * @param nums 数组
     * @return 降序位置较小数的索引
     */
    private int findLastDescendingIndex(int[] nums) {
        int lastIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                lastIndex = i - 1;
                break;
            }
        }
        return lastIndex;
    }

    /**
     * 顺序查找从降序位置开始的最小的值（不能跟降序位置相等）
     *
     * @param nums                数组
     * @param lastDescendingIndex 降序位置索引
     * @return 右边最小值
     */
    private int findLastMin(int[] nums, int lastDescendingIndex) {
        int lastMinIndex = lastDescendingIndex + 1;
        int min = Integer.MAX_VALUE;
        for (int i = lastDescendingIndex + 1; i < nums.length; i++) {
            if (nums[i] < min && nums[i] > nums[lastDescendingIndex]) {
                min = nums[i];
                lastMinIndex = i;
            }
        }
        return lastMinIndex;
    }
}