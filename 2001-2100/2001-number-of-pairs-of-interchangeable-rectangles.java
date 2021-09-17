import java.util.*;
import java.util.stream.Collectors;

/*
 * 2001-number-of-pairs-of-interchangeable-rectangles.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/17
 */
public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Long> map = new HashMap<>();
        for (int[] rec : rectangles) {
            int mcd = maxCommonDivisor(rec[0], rec[1]);
            String key = rec[0] / mcd + "," + rec[1] / mcd;
            map.put(key, map.getOrDefault(key, 0L) + 1L);
        }
        return map.values().stream()
            .filter(e -> e > 0)
            .map(e -> e * (e - 1) / 2)
            .collect(Collectors.summarizingLong(Long::longValue))
            .getSum();
    }

    public int maxCommonDivisor(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.interchangeableRectangles(new int[][] {
            {4, 8},
            {3, 6},
            {10, 20},
            {15, 30}
        }));
        // 0
        System.out.println(s.interchangeableRectangles(new int[][] {
            {4, 5},
            {7, 8}
        }));
    }
}