/*
 * 0004-median-of-two-sorted-arrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2018/08/19
 */
public class Solution {
    /**
     * 找到两个排序数组的中位数
     * 主要思路就是要在两个数组中找到合适的切点，使得切点的左侧均 <= 切点的右侧且左侧的长度和右侧相等（或差一个）
     * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // 这里交换一下，保证 num1.length <= num2.length，其实主要是为了下面一个判断
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        if (nums1.length == 0) {
            // 上面交换主要是为了这里方便能够判断某一个数组是空
            // 数组为空时，直接从 nums2 里面获取结果即可
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2D;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        int cutIdx1 = 0, cutIdx2 = 0;
        int minCutIdx1 = 0;
        int maxCutIdx1 = nums1.length;

        while (minCutIdx1 <= maxCutIdx1) {
            // 切点 1 用二分查找
            cutIdx1 = (minCutIdx1 + maxCutIdx1) / 2;
            // 切点 2 可以直接计算出来，这里 + 1 是方便处理总长度为奇数的情况
            cutIdx2 = (nums1.length + nums2.length + 1) / 2 - cutIdx1;
            if (cutIdx1 < maxCutIdx1 && nums2[cutIdx2 - 1] > nums1[cutIdx1]) {
                // nums2 的左半部分比 nums1 的右半部分大，说明切点1应该在 nums1 的右半部分
                minCutIdx1 = cutIdx1 + 1;
            } else if (cutIdx1 > minCutIdx1 && nums1[cutIdx1 - 1] > nums2[cutIdx2]) {
                // nums1 的左半部分比 nums2 的右半部分大，说明切点1应该在 nums1 的左半部分
                maxCutIdx1 = cutIdx1 - 1;
            } else {
                break;
            }
        }
        int maxLeft, minRight;
        if (cutIdx1 == 0) {
            // nums1 在整体排序好的右半部分
            maxLeft = nums2[cutIdx2 - 1];
        } else if (cutIdx2 == 0) {
            // num2 在整体排序好的右半部分
            maxLeft = nums1[cutIdx1 - 1];
        } else {
            maxLeft = Math.max(nums1[cutIdx1 - 1], nums2[cutIdx2 - 1]);
        }
        if (cutIdx1 == nums1.length) {
            // nums1 在整体排序好的左半部分
            minRight = nums2[cutIdx2];
        } else if (cutIdx2 == nums2.length) {
            // nums 在整体排序好的左半部分
            minRight = nums1[cutIdx1];
        } else {
            minRight = Math.min(nums1[cutIdx1], nums2[cutIdx2]);
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            // 奇数返回左侧最大值
            return maxLeft;
        } else {
            // 偶数返回左侧最大值与右侧最小值的平均数
            return (maxLeft + minRight) / 2D;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2.0
        System.out.println(s.findMedianSortedArrays(
            new int[] {1,3},
            new int[] {2}
        ));
        // 2.5
        System.out.println(s.findMedianSortedArrays(
            new int[] {1,2},
            new int[] {3,4}
        ));
        // 7.5
        System.out.println(s.findMedianSortedArrays(
            new int[] {1,3,7,9,10,13,15},
            new int[] {0,1,4,5,6,8,10,11,12}
        ));
    }
}