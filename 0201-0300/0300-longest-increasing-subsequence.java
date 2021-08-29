import java.util.*;

/*
 * 0300-longest-increasing-subsequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/29
 */
public class Solution {
    private Map<Integer, Integer> cacheMap;

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // init cacheMap
        cacheMap = new HashMap<>();

        // build indexMap
        TreeMap<Integer, List<Integer>> indexMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, getMaxLen(nums, i, indexMap));
        }
        return maxLen;
    }

    public int getMaxLen(int[] nums, int fromIdx, TreeMap<Integer, List<Integer>> indexMap) {
        if (fromIdx >= nums.length) {
            return 0;
        }
        if (cacheMap.containsKey(fromIdx)) {
            return cacheMap.get(fromIdx);
        }
        int maxLen = 1;
        // choose this one
        int val = nums[fromIdx];
        Map.Entry<Integer, List<Integer>> entry = null;
        while ((entry = indexMap.ceilingEntry(val + 1)) != null) {
            Integer nextIdx = null;
            for (Integer idx : entry.getValue()) {
                if (idx.compareTo(fromIdx) > 0) {
                    nextIdx = idx;
                    break;
                }
            }
            if (nextIdx != null) {
                maxLen = Math.max(maxLen, 1 + getMaxLen(nums, nextIdx, indexMap));
            }
            val = entry.getKey();
        }
        // final result
        cacheMap.put(fromIdx, maxLen);

        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "6"
        System.out.println(s.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        // "4"
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,2,5,3,7,3,7,101,18,10,9}));
        // "4"
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        // "4"
        System.out.println(s.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        // "1"
        System.out.println(s.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}