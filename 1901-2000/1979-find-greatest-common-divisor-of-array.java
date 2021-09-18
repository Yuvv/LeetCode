/*
 * 1979-find-greatest-common-divisor-of-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/18
 */
public class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return maxCommonDivisor(max, min);
    }

    public int maxCommonDivisor(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findGCD(new int[] {2,5,6,9,10}));
        // 1
        System.out.println(s.findGCD(new int[] {7,5,6,8,3}));
        // 3
        System.out.println(s.findGCD(new int[] {3, 3}));
    }
}