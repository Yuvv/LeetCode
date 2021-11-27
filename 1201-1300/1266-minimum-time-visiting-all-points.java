/*
 * 1266-minimum-time-visiting-all-points.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/27
 */
public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        int[] last = points[0];
        for (int i = 1; i < points.length; i++) {
            int a = Math.abs(points[i][0] - last[0]);
            int b = Math.abs(points[i][1] - last[1]);
            sum += Math.min(a, b) + Math.abs(a - b);

            last = points[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 5
        System.out.println(s.minTimeToVisitAllPoints(new int[][] {{3,2},{-2,2}}));
        // 7
        System.out.println(s.minTimeToVisitAllPoints(new int[][] {{1,1},{3,4},{-1,0}}));
    }
}