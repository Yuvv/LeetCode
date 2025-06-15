/**
 * 3105-longest-strictly-increasing-or-strictly-decreasing-subarray.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/15
 */
public class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int dir = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[j-1]) {
                if (dir != 1) {
                    max = Math.max(max, j - i);
                    dir = 1;  // increasing
                    i = j - 1;  // start of the current increasing subarray
                }
            } else if (nums[j] < nums[j-1]) {
                if (dir != -1) {
                    max = Math.max(max, j - i);
                    dir = -1;  // decreasing
                    i = j - 1;  // start of the current decreasing subarray
                }
            } else {
                max = Math.max(max, j - i);
                // reset direction on equal elements
                dir = 0;
                i = j;
            }
        }
        if (dir != 0) {
            max = Math.max(max, nums.length - i);  // check the last segment
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.longestMonotonicSubarray(new int[]{1,4,3,3,2}));
        // 1
        System.out.println(s.longestMonotonicSubarray(new int[]{3,3,3,3,3}));
        // 3
        System.out.println(s.longestMonotonicSubarray(new int[]{3,2,1}));
    }
}