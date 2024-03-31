import java.util.*;

/**
 * 2958-length-of-longest-subarray-with-at-most-k-frequency.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/31
 */
public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        TreeMap<Integer, Set<Integer>> freqMap = new TreeMap();
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            if (j >= nums.length && (freqMap.isEmpty() || freqMap.lastKey() <= k)) {
                break;
            }
            while (j < nums.length && (freqMap.isEmpty() || freqMap.lastKey() <= k)) {
                maxLen = Math.max(maxLen, j-i);
                int jc = cntMap.getOrDefault(nums[j], 0);
                if (freqMap.containsKey(jc)) {
                    freqMap.get(jc).remove(nums[j]);
                }
                jc++;
                cntMap.put(nums[j], jc);
                freqMap.computeIfAbsent(jc, x -> new HashSet<>()).add(nums[j]);
                j++;
            }
            if (!freqMap.isEmpty() && freqMap.lastKey() <= k) {
                maxLen = Math.max(maxLen, j-i);
            }
            while (!freqMap.isEmpty() && freqMap.lastKey() > k && i < j) {
                int ic = cntMap.get(nums[i]);
                Set<Integer> icSet = freqMap.get(ic);
                icSet.remove(nums[i]);
                if (icSet.isEmpty()) {
                    freqMap.remove(ic);
                }
                freqMap.computeIfAbsent(ic-1, x -> new HashSet<>()).add(nums[i]);
                cntMap.put(nums[i], ic-1);
                i++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
        // 2
        System.out.println(s.maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1));
        // 4
        System.out.println(s.maxSubarrayLength(new int[]{5,5,5,5,5,5,5,5}, 4));
    }
}