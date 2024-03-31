import java.util.*;
/**
 * 2444-count-subarrays-with-fixed-bounds.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/31
 */
public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long cnt = 0L;
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && (nums[i] < minK || nums[i] > maxK)) {
                i++;
            }
            if (i >= nums.length) {
                break;
            }
            int curMin = nums[i];
            int curMax = nums[i];
            int j = i;
            while (j < nums.length && nums[j] >= minK && nums[j] <= maxK) {
                curMin = Math.min(curMin, nums[j]);
                curMax = Math.max(curMax, nums[j]);
                j++;
            }
            if (curMin == minK && curMax == maxK) {
                cnt += countSubarrays(nums, i, j-1, minK, maxK);
            }
            i = j;
        }
        return cnt;
    }

    private long countSubarrays(int[] nums, int i, int j, int minK, int maxK) {
        int minKc = 0, maxKc = 0;
        int k = i;
        long cnt = 0L;
        while (k <= j) {
            if (nums[k] == minK) {
                minKc++;
            }
            if (nums[k] == maxK) {
                maxKc++;
            }
            while (i <= j && minKc > 0 && maxKc > 0) {
                cnt += j - k + 1;
                if (nums[i] == minK) {
                    minKc--;
                }
                 if (nums[i] == maxK) {
                    maxKc--;
                }
                i++;
            }
            k++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countSubarrays(new int[] {1,3,5,2,7,5}, 1, 5));
        // 10
        System.out.println(s.countSubarrays(new int[] {1,1,1,1}, 1, 1));
    }
}