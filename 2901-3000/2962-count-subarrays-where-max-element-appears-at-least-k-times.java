import java.util.*;
/**
 * 2962-count-subarrays-where-max-element-appears-at-least-k-times.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/30
 */
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        long cnt = 0L;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int i = 0;
        int j = 0;
        int maxcnt = 0;
        while (i < nums.length) {
            if (maxcnt < k) {
                if (j < nums.length) {
                    if (nums[j] == max) {
                        maxcnt++;
                    }
                    j++;
                } else {
                    break;
                }
            } else {
                cnt += nums.length - j + 1;
                if (nums[i] == max) {
                    maxcnt--;
                }
                i++;
            }
        }
        return cnt;
    }

    public long countSubarrays_map(int[] nums, int k) {
        long cnt = 0L;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        Map<Integer, Integer> cntMap = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            int maxcnt = cntMap.getOrDefault(max, 0);
            if (maxcnt < k) {
                if (j < nums.length) {
                    cntMap.put(nums[j], cntMap.getOrDefault(nums[j], 0) + 1);
                    j++;
                } else {
                    break;
                }
            } else {
                cnt += nums.length - j + 1;
                int ic = cntMap.get(nums[i]);
                if (ic <= 1) {
                    cntMap.remove(nums[i]);
                } else {
                    cntMap.put(nums[i], ic - 1);
                }
                i++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countSubarrays(new int[]{1,3,2,3,3}, 2));
        // 0
        System.out.println(s.countSubarrays(new int[]{1,4,2,1}, 3));
    }
}
