import java.util.*;
/**
 * 2594-minimum-time-to-repair-cars.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/04/13
 */
public class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1L;
        long right = (long) Arrays.stream(ranks).max().getAsInt() * cars * cars;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(ranks, mid, cars)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] ranks, long time, int cars) {
        long total = 0L;
        for (int r : ranks) {
            total += Math.sqrt(time / r);
            if (total >= cars) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 16
        System.out.println(s.repairCars(new int[]{4, 2, 3, 1}, 10));
        // 16
        System.out.println(s.repairCars(new int[]{5,1,8}, 6));
    }
}
