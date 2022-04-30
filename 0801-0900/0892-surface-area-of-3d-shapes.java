/*
 * 0892-surface-area-of-3d-shapes.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/30
 */
public class Solution {
    public int surfaceArea(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // add self-surface
                if (grid[i][j] > 0) {
                    count += grid[i][j] * 4 + 2;
                }
                // sub left
                if (j > 0) {
                    count -= Math.min(grid[i][j - 1], grid[i][j]);
                }
                // sub right
                if (j < grid[i].length - 1) {
                    count -= Math.min(grid[i][j], grid[i][j + 1]);
                }
                // sub up
                if (i > 0) {
                    count -= Math.min(grid[i - 1][j], grid[i][j]);
                }
                if (i < grid.length - 1) {
                    count -= Math.min(grid[i][j], grid[i + 1][j]);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 34
        System.out.println(s.surfaceArea(
            new int[][] {
                {1,2}, {3,4}
            }
        ));
        // 32
        System.out.println(s.surfaceArea(
            new int[][] {
                {1,1,1}, {1,0,1}, {1,1,1}
            }
        ));
    }
}