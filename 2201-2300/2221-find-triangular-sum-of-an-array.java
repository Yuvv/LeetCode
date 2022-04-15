/*
 * 2221-find-triangular-sum-of-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/15
 */
public class Solution {
    public int triangularSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.triangularSum(new int[] {1,2,3,4,5}));
    }
}