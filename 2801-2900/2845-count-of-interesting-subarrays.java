import java.util.*;
/**
 * 2845-count-of-interesting-subarrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/04
 */
public class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] prefixsum = new int[nums.size() + 1];
        for (int i = 1; i <= nums.size(); i++) {
            prefixsum[i] = prefixsum[i - 1] + (nums.get(i - 1) % modulo == k ? 1 : 0);
        }
        long ans = 0L;
        Map<Integer, Long> cntMap = new HashMap<>();
        for (int i = 0; i < prefixsum.length; i++) {
            int mod = (prefixsum[i] + modulo - k) % modulo;
            ans += cntMap.getOrDefault(mod, 0L);
            mod = prefixsum[i] % modulo;
            cntMap.put(mod, cntMap.getOrDefault(mod, 0L) + 1L);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.countInterestingSubarrays(Arrays.asList(3,2,4), 2, 1));
        // 2
        System.out.println(s.countInterestingSubarrays(Arrays.asList(3,1,9,6), 3, 0));
    }
}
