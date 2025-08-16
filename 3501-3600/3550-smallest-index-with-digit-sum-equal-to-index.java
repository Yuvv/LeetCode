/**
 * 3550-smallest-index-with-digit-sum-equal-to-index.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/16
 */
public class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = 0;
            while (n > 0) {
                sum += n%10;
                n /= 10;
            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.smallestIndex(new int[]{1,3,2}));
        // 1
        System.out.println(s.smallestIndex(new int[]{1,10,11}));
        // -1
        System.out.println(s.smallestIndex(new int[]{1,2,3}));
    }
}