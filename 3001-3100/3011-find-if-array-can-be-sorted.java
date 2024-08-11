import java.util.*;

/**
 * 3011-find-if-array-can-be-sorted.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/11
 */
public class Solution {
    public boolean canSortArray(int[] nums) {
        int lastMax = 0;
        Map<Integer, Integer> bsmap = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            int bs = bsmap.computeIfAbsent(nums[i], this::bscnt);
            int max = nums[i];
            int min = nums[i];
            int j = i + 1;
            while (j < nums.length && bsmap.computeIfAbsent(nums[j], this::bscnt) == bs) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                j++;
            }
            if (min < lastMax) {
                return false;
            }
            lastMax = max;
            i = j;
            if (j < nums.length) {
                bs = bsmap.computeIfAbsent(nums[j], this::bscnt);
            }
        }
        return true;
    }

    private int bscnt(int k ) {
        int cnt = 0;
        while (k > 0) {
            if ((k & 1) > 0) {
                cnt++;
            }
            k >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // false
        System.out.println(s.canSortArray(new int[] {75,34,30}));
        // true
        System.out.println(s.canSortArray(new int[] {8,4,2,30,15}));
        // true
        System.out.println(s.canSortArray(new int[] {1,2,3,4,5}));
        // false
        System.out.println(s.canSortArray(new int[] {3,16,8,4,2}));
    }
}
