/**
 * 1219-path-with-maximum-gold.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/05/26
 */
public class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, getMax(grid, flag, i, j));
            }
        }

        return max;
    }

    private int getMax(int[][] grid, boolean[][] flag, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        if (flag[i][j]) {
            return 0;
        }
        flag[i][j] = true;
        int max = 0;
        max = Math.max(max, getMax(grid, flag, i+1, j));
        max = Math.max(max, getMax(grid, flag, i-1, j));
        max = Math.max(max, getMax(grid, flag, i, j+1));
        max = Math.max(max, getMax(grid, flag, i, j-1));
        flag[i][j] = false;
        max += grid[i][j];
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 24
        System.out.println(s.getMaximumGold(new int[][]{
            {0,6,0},{5,8,7},{0,9,0}
        }));
        // 28
        System.out.println(s.getMaximumGold(new int[][]{
            {1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}
        }));
    }
}
