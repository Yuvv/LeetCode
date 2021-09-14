/*
 * 0396-rotate-function.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/14
 */
public class Solution {
    public int maxRotateFunction(int[] nums) {
        // F(k) = F(k-1) + sum(arr_{k-1}) - n * arr_{k-1}[n - 1]
        // F(0) = 0 * arr_0[0] + 1 * arr_0[1] + ... + (n-1) * arr_0[n-1]
        int num_sum = 0;
        int f0 = 0;
        for (int i= 0; i < nums.length; i++) {
            num_sum += nums[i];
            f0 += i * nums[i];
        }
        int max_f = f0;
        for (int i = 1; i < nums.length; i++) {
            f0 = f0 + num_sum - nums.length * nums[nums.length - i];
            max_f = Math.max(max_f, f0);
        }
        return max_f;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 26
        System.out.println(s.maxRotateFunction(new int[]{4,3,2,6}));
        // 53
        System.out.println(s.maxRotateFunction(new int[]{4,3,2,6,7}));
        // 0
        System.out.println(s.maxRotateFunction(new int[]{100}));
        // 3759
        System.out.println(s.maxRotateFunction(new int[]{1,3,4,2,3,4,5,6,7,7,98,9,8,7,6,5,6,7,89,9}));

    }
}