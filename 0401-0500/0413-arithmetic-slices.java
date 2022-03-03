/*
 * 0413-arithmetic-slices.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/03/04
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int sum = 0;
        int diff = nums[1] - nums[0];
        int idx = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                int len = i - idx;
                if (len >= 2) {
                    sum += (len - 2) * (len - 1) / 2;
                }
                idx = i - 1;
                diff = nums[i] - nums[i - 1];
            }
        }
        int len = nums.length - idx;
        if (len >= 2) {
            sum += (len - 2) * (len - 1) / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.numberOfArithmeticSlices(new int[] {1,2,3,4}));
        // 0
        System.out.println(s.numberOfArithmeticSlices(new int[] {1}));
        // 0
        System.out.println(s.numberOfArithmeticSlices(new int[] {1,2,3,4,7,10,13,14,15,16,17,18}));
    }
}