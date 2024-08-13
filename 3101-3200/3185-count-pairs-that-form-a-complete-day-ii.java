import java.util.*;

/**
 * 3185-count-pairs-that-form-a-complete-day-ii.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/13
 */
public class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] cntarr = new int[24];
        long cnt = 0L;
        for (int h : hours) {
            h = h % 24;
            cnt += cntarr[(24 - h) % 24];
            cntarr[h]++;
        }
        return cnt;
    }

    // AC but slower
    public long countCompleteDayPairs_map(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0L;
        for (int h : hours) {
            h = h % 24;
            cnt += map.getOrDefault((24 - h) % 24, 0);
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.countCompleteDayPairs(new int[] {12,12,30,24,24}));
        // 3
        System.out.println(s.countCompleteDayPairs(new int[] {72,48,24,3}));
    }
}
