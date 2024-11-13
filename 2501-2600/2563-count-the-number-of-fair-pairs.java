import java.util.*;

/**
 * 2563-count-the-number-of-fair-pairs.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/11/13
 */
public class Solution {
    public long countFairPairs_tle(int[] nums, int lower, int upper) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long cnt = 0L;
        for (int n : nums) {
            int lo = lower - n;
            int up = upper - n;
            Map.Entry<Integer, Integer> entry = map.higherEntry(lo-1);
            while (entry != null && entry.getKey() <= up) {
                cnt += entry.getValue();
                entry = map.higherEntry(entry.getKey());
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return cnt;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long cnt = 0L;
        int i = nums.length - 1;
        int j = nums.length - 1;
        for (int k = 0; k < j; k++) {
            int lo = lower - nums[k];
            int up = upper - nums[k];
            while (j > k && nums[j] > up) {  // nums[j] is the last one LTE "up"
                j--;
            }
            if (j <= k) {
                break;
            }
            if (i >= j) {
                i = j;
            }
            while (i > k && nums[i] >= lo) { // nums[i] is first one GTE "lo"
                i--;
            }
            if (i < k) {
                i = k;
            }
            cnt += j - i;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.countFairPairs(
            new int[]{0,1,7,4,4,5}, 3, 6
        ));
        // 1
        System.out.println(s.countFairPairs(
            new int[]{1,7,9,2,5}, 11, 11
        ));
        // 512
        System.out.println(s.countFairPairs(
            new int[]{44, 10, -89, -95, -98, -87, -88, 2, -91, -51, 3, -74, -77, 11, -60,
            -99, -87, 86, 84, -94, -50, 3, 4, 63, 15, -94, -24, 31, -74, 84, 80, -41, 35, 91,
            18, 53, -39, 36, -48, -92, 49, -61, 35, -26, -56, 80, -56, -40, 34, -89, 20, 76, -11,
            17, 57, -13, -70, -12, -39, -48, 12, -40, -83, 13, 8, -40, -82, -10, 36, 72, -43, 64,
            35, 24, -55, -83, 32, 17, 2, -82, 94, -58, 72, -19, -69, 33, 90, 75, 89, 1, -14, -58,
            -86, 48, 95, 79, -53, -67, 95, -88},
            -10, 10
        ));
    }
}
