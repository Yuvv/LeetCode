import java.util.*;

/*
 * 0452-minimum-number-of-arrows-to-burst-balloons.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/01/13
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        int cnt = 0;
        int i = 0;
        while (i < points.length) {
            int ptEnd = points[i][1];
            i++;

            while (i < points.length && points[i][0] <= ptEnd) {
                ptEnd = Math.min(ptEnd, points[i][1]);
                i++;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.findMinArrowShots(new int[][] {
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        }));
        // 4
        System.out.println(s.findMinArrowShots(new int[][] {
                {1, 2}, {3, 4}, {5, 6}, {7, 8}
        }));
        // 2
        System.out.println(s.findMinArrowShots(new int[][] {
                {1, 2}, {2, 3}, {3, 4}, {4, 5}
        }));
    }
}