import java.util.*;

/**
 * 0992-subarrays-with-k-different-integers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/03/30
 */
public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
Map<Integer, Integer> cntMap = new HashMap<>();
        int i = 0, j = 0;
        int cnt = 0;
        while (i < nums.length) {
            if (j >= nums.length && cntMap.size() < k) {
                break;
            }
            if (j < nums.length && cntMap.size() < k) {
                cntMap.put(nums[j], cntMap.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            if (cntMap.size() == k) {
                int sj = j - 1;
                while (j < nums.length && cntMap.containsKey(nums[j])) {
                    j++;
                }
                cnt += j - sj;
                int iCnt = cntMap.getOrDefault(nums[i], 0);
                if (iCnt <= 1) {
                    cntMap.remove(nums[i]);
                } else {
                    cntMap.put(nums[i], iCnt-1);
                }
                i++;
                j = sj + 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 7
        System.out.println(s.subarraysWithKDistinct(
            new int[]{1,2,1,2,3}, 2
        ));
        // 3
        System.out.println(s.subarraysWithKDistinct(
            new int[]{1,2,1,3,4}, 3
        ));
    }
}
