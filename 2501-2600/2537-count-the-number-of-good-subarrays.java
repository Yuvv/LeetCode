import java.util.*;
/**
 * 2537-count-the-number-of-good-subarrays.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/05/05
 */
public class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0L;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int i = 0;
        int j = 0;
        int curPair = 0;
        while (j < nums.length) {
            Integer nj = cntMap.getOrDefault(nums[j], 0);
            curPair += nj;
            cntMap.put(nums[j], nj + 1);
            while (curPair >= k) {
                ans += nums.length - j;
                Integer v = cntMap.get(nums[i]);
                curPair -= v - 1;
                cntMap.put(nums[i], v - 1);
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.countGood(new int[]{1, 1, 1, 1, 1}, 10));
        // 4
        System.out.println(s.countGood(new int[]{3,1,4,3,2,2,4}, 2));
    }
}
