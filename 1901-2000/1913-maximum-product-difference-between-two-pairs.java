/**
 * 1913-maximum-product-difference-between-two-pairs
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/18
 */
public class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = Math.max(nums[0], nums[1]), max2 = Math.min(nums[0], nums[1]);
        int min1 = max2, min2 = max1;
        for (int i = 2; i < nums.length; i++) {
            int n = nums[i];
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return max1 * max2 - min1 * min2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 34
        System.out.println(s.maxProductDifference(
                new int[] { 5, 6, 2, 7, 4 }));
        // 64
        System.out.println(s.maxProductDifference(
                new int[] { 4, 2, 5, 9, 7, 4, 8 }));
    }
}
