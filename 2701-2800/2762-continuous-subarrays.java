import java.util.*;
/**
 * 2762-continuous-subarrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/11
 */
public class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long ans = 0L;
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            while (j < nums.length && (map.isEmpty() || Math.abs(nums[j] - map.firstKey()) <= 2 && Math.abs(nums[j] - map.lastKey()) <= 2)) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            ans += (j - i);
            int ic = map.get(nums[i]);
            if (ic == 1) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], ic - 1);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 8
        System.out.println(s.continuousSubarrays(new int[]{5,4,2,4}));
        // 6
        System.out.println(s.continuousSubarrays(new int[]{1,2,3}));
    }
}