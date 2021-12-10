/*
 * 1037-valid-boomerang.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/12/10
 */
public class Solution {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[2][0] - points[1][0];
        int y1 = points[2][1] - points[1][1];
        int x2 = points[1][0] - points[0][0];
        int y2 = points[1][1] - points[0][1];
        return y2 * x1 != y1 * x2;
    }

}