/**
 * 2419-longest-subarray-with-maximum-bitwise-and.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/03
 */
public class Solution {
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        int maxLen = 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < max) {
                i++;
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxLen = 1;
            }
            int len = 0;
            while (i < nums.length && nums[i] == max) {
                len++;
                i++;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.longestSubarray(new int[]{1, 2, 3, 3, 2, 1}));
        // 1
        System.out.println(s.longestSubarray(new int[]{1,2,3,4}));
        // 3
        System.out.println(s.longestSubarray(new int[]{4,4,2,3,4,4,4}));
        // 3
        System.out.println(s.longestSubarray(new int[]{4,4,4,2,3,4,4}));
    }
}