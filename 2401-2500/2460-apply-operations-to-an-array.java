/*
 * 2460-apply-operations-to-an-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/11/06
 */
public class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < i || (j < nums.length && nums[j] == 0)) {
                j++;
            }
            if (i < nums.length && j < nums.length) {
                // swap nums[i] nums[j]
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,4,2,0,0,0]
        System.out.println(java.util.Arrays.toString(
            s.applyOperations(new int[] {1,2,2,1,1,0})
        ));
    }
}