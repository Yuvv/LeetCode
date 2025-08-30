/**
 * 3000-maximum-area-of-longest-diagonal-rectangle.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/08/30
 */
public class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxdiag = 0;
        int maxarea = 0;
        for (int[] row : dimensions) {
            int x = row[0]*row[0] + row[1]*row[1];
            if (x > maxdiag) {
                maxdiag = x;
                maxarea = row[0] * row[1];
            } else if (x == maxdiag) {
                maxarea = Math.max(maxarea, row[0]*row[1]);
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 48
        System.out.println(s.areaOfMaxDiagonal(new int[][]{
            {9,3}, {8,6}
        }));
        // 12
        System.out.println(s.areaOfMaxDiagonal(new int[][]{
            {3,4}, {4,3}
        }));
    }
}