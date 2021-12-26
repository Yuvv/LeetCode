/*
 * 1779-find-nearest-point-that-has-the-same-x-or-y-coordinate.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/26
 */
public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int idx = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] pt = points[i];
            if (pt[0] == x || pt[1] == y) {
                int dis = Math.abs(x - pt[0]) + Math.abs(y - pt[1]);
                if (dis < minDis) {
                    idx = i;
                    minDis = dis;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2
        System.out.println(s.nearestValidPoint(3, 4, new int[][] {{1,2},{3,1},{2,4},{2,3},{4,4}}));
        // 0
        System.out.println(s.nearestValidPoint(3, 4, new int[][] {{3,4}}));
        // -1
        System.out.println(s.nearestValidPoint(3, 4, new int[][] {{2,3}}));
    }
}