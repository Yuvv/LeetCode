/*
 * 0747-largest-number-at-least-twice-of-others.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/28
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return nums.length - 1;
        }
        int largestIdx = 0;
        int secondaryIdx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[largestIdx]) {
                secondaryIdx = largestIdx;
                largestIdx = i;
            } else {
                if (secondaryIdx < 0) {
                    secondaryIdx = i;
                } else if (nums[i] > nums[secondaryIdx]) {
                    secondaryIdx = i;
                }
            }
        }
        if (secondaryIdx >= 0 && nums[largestIdx] >= 2 * nums[secondaryIdx]) {
            return largestIdx;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.dominantIndex(new int[] {3, 6, 1, 0}));
        // -1
        System.out.println(s.dominantIndex(new int[] {1, 2, 3, 4}));
        // 0
        System.out.println(s.dominantIndex(new int[] {1}));
        // 0
        System.out.println(s.dominantIndex(new int[] {1, 0}));
    }
}