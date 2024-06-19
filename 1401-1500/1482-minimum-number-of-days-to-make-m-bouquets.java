import java.util.*;

/**
 * 1482-minimum-number-of-days-to-make-m-bouquets.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/06/19
 */
public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long len = (long)m * (long)k;
        if (len > bloomDay.length) {
            return -1;
        }
        int min = bloomDay[0];
        int max = bloomDay[0];
        for (int b : bloomDay) {
            min = Math.min(b, min);
            max = Math.max(b, max);
        }
        while (min < max) {
            int mid = (min + max) / 2;
            // check
            int i = 0;
            int mc = 0;
            while (i < bloomDay.length && mc < m && (m - mc) * k <= (bloomDay.length - i)) {
                if (bloomDay[i] > mid) {
                    i++;
                    continue;
                }
                boolean ok = true;
                for (int j = i; j < bloomDay.lenth && j < i+k; j++) {
                    if (bloomDay[j] > mid) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    i += k;
                    mc++;
                } else {
                    i++;
                }
            }
            // check result
            if (mc >= m) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 3
        System.out.println(s.minDays(new int[] {1,10,3,10,2}, 3, 1));
        // -1
        System.out.println(s.minDays(new int[] {1,10,3,10,2}, 3, 2));
        // 12
        System.out.println(s.minDays(new int[] {7,7,7,7,12,7,7}, 2, 3));
    }
}