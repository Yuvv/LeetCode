import java.util.*;
/**
 * 2364-count-number-of-bad-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/20
 */
public class Solution {
    public long countBadPairs(int[] nums) {
        long res = nums.length * (nums.length - 1L) / 2L;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - i;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int v : map.values()) {
            res -= (long) v * (v - 1L) / 2L;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.countBadPairs(new int[]{4, 1, 3, 3}));
        // 0
        System.out.println(s.countBadPairs(new int[]{1,2,3,4,5}));
    }
}
