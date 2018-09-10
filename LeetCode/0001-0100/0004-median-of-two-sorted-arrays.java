class Solution {
    /**
     * 找到两个排序数组的中位数
     * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2D;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        int i = 0, j = 0;
        int minI = 0;
        int maxI = nums1.length;

        while (minI <= maxI) {
            i = (minI + maxI) / 2;
            j = (nums1.length + nums2.length + 1) / 2 - i;
            if (i < maxI && nums2[j - 1] > nums1[i]) {
                minI = i + 1;
            } else if (i > minI && nums1[i - 1] > nums2[j]) {
                maxI = i - 1;
            } else {
                break;
            }
        }
        int maxLeft, minRight;
        if (i == 0) {
            maxLeft = nums2[j - 1];
        } else if (j == 0) {
            maxLeft = nums1[i - 1];
        } else {
            maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if (i == nums1.length) {
            minRight = nums2[j];
        } else if (j == nums2.length) {
            minRight = nums1[i];
        } else {
            minRight = Math.min(nums1[i], nums2[j]);
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            // 奇数返回左侧最大值
            return maxLeft;
        } else {
            // 偶数返回左侧最大值与右侧最小值的平均数
            return (maxLeft + minRight) / 2D;
        }
    }
}