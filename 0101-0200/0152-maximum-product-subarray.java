/*
 * 0152-maximum-product-subarray.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/20
 */
public class Solution {
    public int maxProduct_bruteforce(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int last = 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    max = Math.max(max, 0);
                    break;
                }
                last *= nums[j];
                max = Math.max(max, last);
            }
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int maxP = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int b = curMin * nums[i];
            int c = curMax * nums[i];

            curMax = Math.max(nums[i], Math.max(b, c));
            curMin = Math.min(nums[i], Math.min(b, c));

            maxP = Math.max(maxP, curMax);
        }

        return maxP;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.maxProduct(new int[]{2, 3, -2, 4}));
        // 0
        System.out.println(s.maxProduct(new int[]{-2, 0, -1}));
        // 2
        System.out.println(s.maxProduct(new int[]{0, 2, 0, -1}));
        // -9
        System.out.println(s.maxProduct(new int[]{-9}));
        // 12
        System.out.println(s.maxProduct(new int[]{0, 2, 0, 3, 4}));
        // 2
        System.out.println(s.maxProduct(new int[]{0, 2, 0, -1}));
        // 121927680
        System.out.println(s.maxProduct(new int[]{-2, 3, 1, 2, 3, 2, 1, 1, 1, 2, 1, 4, -2, -7, 1, -6, 1, 5, 1, 3, 7, 1, -4, 3, -2, -1}));
    }
}