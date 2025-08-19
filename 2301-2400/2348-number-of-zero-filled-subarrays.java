/**
 * 2348-number-of-zero-filled-subarrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/19
 */
public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0;
        long res = 0L;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            if (i < nums.length) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                res += (long)(j-i)*(j-i+1)/2;
                i = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        // 9
        System.out.println(s.zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
        // 0
        System.out.println(s.zeroFilledSubarray(new int[]{2,10,2019}));
    }
}