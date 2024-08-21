/**
 * 3195-find-the-minimum-area-to-cover-all-ones-i.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/21
 */
public class Solution {
    public int minimumArea(int[][] grid) {
        int left = grid[0].length;
        int top = grid.length;
        int bottom = -1;
        int right = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 6
        System.out.println(s.minimumArea(new int[][]{
            {0,1,0}, {1,0,1}
        }));
        // 1
        System.out.println(s.minimumArea(new int[][]{
            {1,0}, {0,0}
        }));
    }
}
