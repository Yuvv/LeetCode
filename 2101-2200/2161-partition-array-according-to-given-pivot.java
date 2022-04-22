/*
 * 2161-partition-array-according-to-given-pivot.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/23
 */
public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (int num : nums) {
            if (num < pivot) {
                res[i++] = num;
            }
        }
        for (int k = nums.length - 1; k >= 0; k--) {
            if (nums[k] > pivot) {
                res[j--] = nums[k];
            }
        }
        while (i <= j) {
            res[i] = pivot;
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [9,5,3,10,10,12,14]
        System.out.println(s.pivotArray(new int[] {9,12,5,10,14,3,10}, 10));
    }
}