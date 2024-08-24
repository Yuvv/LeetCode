/**
 * 2760-longest-even-odd-subarray-with-threshold.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/24
 */
public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && (nums[i] > threshold || nums[i] % 2 == 1)) {
                i++;  // move i to next valid even
            }
            if (i >= nums.length) {
                break;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] <= threshold && (nums[j]%2) != (nums[j-1]%2) ) {
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            i = j;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.longestAlternatingSubarray(new int[] {3,2,5,4}, 5));
        // 1
        System.out.println(s.longestAlternatingSubarray(new int[] {1,2}, 2));
        // 3
        System.out.println(s.longestAlternatingSubarray(new int[] {2,3,4,5}, 4));
        // 0
        System.out.println(s.longestAlternatingSubarray(new int[] {10,1,10}, 3));
    }
}
