/*
 * 0209-minimum-size-subarray-sum.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/12
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j =0;
        int sum = 0;
        int minLen = nums.length + 1;
        while (j < nums.length) {
            sum += nums[j];
            if (sum == target) {
                minLen = Math.min(minLen, j - i + 1);
                j++;
            } else if (sum > target) {
                while (sum > target) {
                    minLen = Math.min(minLen, j - i + 1);
                    sum -= nums[i];
                    i++;
                }
                if (i > j) {
                    j = i;
                } else {
                    sum -= nums[j];
                }
            } else {
                j++;
            }
        }
        if (minLen > nums.length) {
            return 0;
        }
        return minLen;
    }

    // PS: 还可以用前缀和，然后用二分法找。
    // 注意二分的时候，可能会有两个区间都有可能的情况

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        // 1
        System.out.println(s.minSubArrayLen(4, new int[] {1,4,4}));
        // 0
        System.out.println(s.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1}));
        // 1
        System.out.println(s.minSubArrayLen(11, new int[] {11,12,13,14}));
    }
}