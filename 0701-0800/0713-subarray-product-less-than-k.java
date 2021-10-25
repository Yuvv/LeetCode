import java.util.*;

/*
 * 0713-subarray-product-less-than-k.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/10/25
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int total = 0;
        int product = 1;
        int i = 0, j = 0;
        while (j < nums.length) {
            product *= nums[j];
            while (product >= k && i < nums.length) {
                product /= nums[i];
                i++;
            }
            if (i >= nums.length) {
                break;
            }
            // 每次只算当前 j 元素在内的子数组
            total += j - i + 1;
            j++;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));
        // 0
        System.out.println(s.numSubarrayProductLessThanK(new int[] {1,2,3}, 0));
    }

}