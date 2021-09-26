/*
 * 2016-maximum-difference-between-increasing-elements.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/26
 */
public class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minVal = nums[0];
        int maxVal = nums[0];
        for (int num : nums) {
            if (num < minVal) {
                if (maxVal > minVal) {
                    maxDiff = Math.max(maxDiff, maxVal - minVal);
                }
                minVal = num;
                maxVal = num - 1;
            } else if (num > maxVal) {
                maxVal = num;
            }
        }

        if (maxVal > minVal) {
            maxDiff = Math.max(maxDiff, maxVal - minVal);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 4
        System.out.println(s.maximumDifference(new int[]{7, 1, 5, 4}));
        // -1
        System.out.println(s.maximumDifference(new int[]{9, 4, 3, 2}));
        // 9
        System.out.println(s.maximumDifference(new int[]{1, 5, 2, 10}));
    }

}