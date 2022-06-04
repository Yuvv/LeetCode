/*
 * 2148-count-elements-with-strictly-smaller-and-greater-elements.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/06/04
 */
public class Solution {
    public int countElements(int[] nums) {
        int min = nums[0];
        int minCount = 0;
        int max = nums[0];
        int maxCount = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
                minCount = 1;
            } else if (num == min) {
                minCount++;
            }
            if (num > max) {
                max = num;
                maxCount = 1;
            } else if (num == max) {
                maxCount++;
            }
        }
        return Math.max(0, nums.length - minCount - maxCount);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countElements(new int[] {11, 7, 2, 15}));
        // 2
        System.out.println(s.countElements(new int[] {-3, 3, 3, 90}));
    }
}