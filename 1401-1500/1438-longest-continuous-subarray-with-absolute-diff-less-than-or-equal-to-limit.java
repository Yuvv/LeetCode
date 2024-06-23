import java.util.*;

/**
 * 1438-longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/23
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int max = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int j = 0;
        for (int i = 0; i < nums.length && nums.length - j > max; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            int first = treeMap.firstKey();
            int last = treeMap.lastKey();
            if (last-first <= limit) {
                max = Math.max(max, i - j + 1);
                System.out.println("i=" + i + ", j=" + j);
            } else {
                int c = treeMap.get(nums[j]);
                if (c == 1) {
                    treeMap.remove(nums[j]);
                } else {
                    treeMap.put(nums[j], c-1);
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.longestSubarray(new int[]{8,2,4,7}, 4));
        // 4
        System.out.println(s.longestSubarray(new int[]{10,1,2,4,7,2}, 5));
        // 3
        System.out.println(s.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }
}