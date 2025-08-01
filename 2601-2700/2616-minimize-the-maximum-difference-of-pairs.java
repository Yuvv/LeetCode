import java.util.*;
/**
 * 2616-minimize-the-maximum-difference-of-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/06/13
 */
public class Solution {
    // Find the number of valid pairs by greedy approach
    private int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while (index < nums.length - 1) {
            // If a valid pair is found, skip both numbers.
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If there are enough pairs, look for a smaller threshold.
            // Otherwise, look for a larger threshold.
            if (countValidPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.minimizeMax(new int[]{10,1,2,7,1,3}, 2));
        // 0
        System.out.println(s.minimizeMax(new int[]{4,2,1,2}, 1));
    }
}