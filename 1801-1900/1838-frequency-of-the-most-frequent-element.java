import java.util.*;

/**
 * 1838-frequency-of-the-most-frequent-element
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/11/18
 */
public class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = 1;
        Arrays.sort(nums);
        long prefixSum = nums[0];
        long avg;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            prefixSum += nums[j];
            avg = (prefixSum + k) / (j - i + 1);
            if (avg >= nums[j]) {
                max = Math.max(max, j - i + 1);
            } else {
                prefixSum -= nums[i];
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.maxFrequency(new int[] { 1, 2, 4 }, 5));
        // 2
        System.out.println(s.maxFrequency(new int[] { 1, 4, 8, 13 }, 5));
        // 1
        System.out.println(s.maxFrequency(new int[] { 3, 9, 6 }, 2));
    }
}
