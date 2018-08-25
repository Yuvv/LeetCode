class Solution {
    /**
     * 找出滑动窗口中最大值
     * https://leetcode.com/problems/sliding-window-maximum/description/
     *
     * 直接滑动窗口计算（记录最大值下标，减小比较次数）
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];   // 说好的 non-empty 呢。。。
        }
        int winBegin = 0;     // 窗口开始下标
        int winEnd = k - 1;   // 窗口结束下标
        int winMax;           // 窗口中最大数下标

        int[] result = new int[nums.length - k + 1];

        winMax = getWinMaxIndex(nums, winBegin, winEnd);
        result[0] = nums[winMax];
        for (int i = k; i < nums.length; i++) {
            winBegin++;
            winEnd++;
            if (i - k == winMax) {
                winMax = getWinMaxIndex(nums, winBegin, winEnd);
            } else if (nums[winMax] < nums[i]) {
                winMax = i;
            }
            result[winBegin] = nums[winMax];
        }

        return result;
    }

    int getWinMaxIndex(int[] nums, int begin, int end) {
        int maxIndex = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}