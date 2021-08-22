import java.util.*;

/*
 * 0223-rectangle-area.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/08/22
 */
public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int res = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        // get intersection
        if (bx1 >= ax2 || ax1 >= bx2) {
            //
        } else if (by1 >= ay2 || ay1 >= by2) {
            //
        } else {
            // has intersection
            int[] xArr = new int[] {ax1, ax2, bx1, bx2};
            Arrays.sort(xArr);
            int[] yArr = new int[] {ay1, ay2, by1, by2};
            Arrays.sort(yArr);

            res -= (xArr[2] - xArr[1]) * (yArr[2] - yArr[1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 45
        System.out.println(s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        // 42
        System.out.println(s.computeArea(-3, 0, 3, 4, 3, -1, 9, 2));
        // 16
        System.out.println(s.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
}