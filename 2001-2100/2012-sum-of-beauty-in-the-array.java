/*
 * 2012-sum-of-beauty-in-the-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/26
 */
public class Solution {
    public int sumOfBeauties(int[] nums) {
        int[] maxArr = new int[nums.length];
        maxArr[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            maxArr[i] = Math.max(maxArr[i - 1], nums[i]);
        }
        int[] minArr = new int[nums.length];
        minArr[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            minArr[i] = Math.min(minArr[i + 1], nums[i]);
        }

        int sum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > maxArr[i - 1] && nums[i] < minArr[i + 1]) {
                sum += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.sumOfBeauties(new int[]{1, 2, 3}));
        // 1
        System.out.println(s.sumOfBeauties(new int[]{2, 4, 6, 4}));
        // 0
        System.out.println(s.sumOfBeauties(new int[]{3, 2, 1}));
    }

}